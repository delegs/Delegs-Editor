package videoImport;

import de.signWritingEditor.server.service.ConfigurationService.OS;
import de.signWritingEditor.server.service.ConfigurationService;
import excel.ExcelImportLogger;
import excel.ExcelImportSettings;
import excel.ExcelImportTimer;
import excel.ExcelImportTimerState;

import java.io.*;
import java.nio.file.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipInputStream;

public class VideoImportService {

    String ffmpegCommand;
    String videoLocation;
    String libLocation;

    public VideoImportService(ConfigurationService configurationService) {

        videoLocation = configurationService.getProperty(ExcelImportSettings.VIDEO_UPLOAD_DIR);
        libLocation = configurationService.getProperty(ConfigurationService.PROPERTY_VIDEO_LIB_DIR);

        OS os = configurationService.getOS();
        ffmpegCommand = resolveFFmpegCommand(os);
    }

    public boolean runImport(File zipFile) {

        Path tmpVideoPath = null;
        File[] tempVideoFiles = null;

        try {
            String zipFileLocation = zipFile.getAbsolutePath();
            tmpVideoPath = Files.createTempDirectory("videoImport");
            File tmpVideoDir = tmpVideoPath.toFile();
            String tmpVideoLocation = tmpVideoDir.getAbsolutePath();

            boolean unzipSuccess = unzip(zipFileLocation, tmpVideoLocation);
            ExcelImportTimer.setTimeStamp(ExcelImportTimerState.UNZIP);
            String unzipDurationString = ExcelImportTimer.getDurationString(ExcelImportTimerState.UPLOAD, ExcelImportTimerState.UNZIP);
            String unzipDurationMessage = String.format("Entpacken des Zip Archivs abgeschlossen. %s", unzipDurationString);
            ExcelImportLogger.logInfo(unzipDurationMessage);

            tempVideoFiles = tmpVideoDir.listFiles();
            if (unzipSuccess && tempVideoFiles != null) {
                convert(tmpVideoDir, tempVideoFiles);
                ExcelImportTimer.setTimeStamp(ExcelImportTimerState.CONVERT);
                String convertDurationString = ExcelImportTimer.getDurationString(ExcelImportTimerState.UPLOAD, ExcelImportTimerState.CONVERT);
                String convertDurationMessage = String.format("Konvertieren abgeschlossen. %s", convertDurationString);
                ExcelImportLogger.logInfo(convertDurationMessage);

                copy(tempVideoFiles);
                ExcelImportTimer.setTimeStamp(ExcelImportTimerState.COPY);
                String copyDurationString = ExcelImportTimer.getDurationString(ExcelImportTimerState.CONVERT, ExcelImportTimerState.COPY);
                String copyDurationMessage = String.format("Kopieren der Videos abgeschlossen. %s", copyDurationString);
                ExcelImportLogger.logInfo(copyDurationMessage);
            }

            return unzipSuccess;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (tempVideoFiles != null)
                    for (File tempVideoFile : tempVideoFiles) {
                        Path filePath = tempVideoFile.toPath();
                        Files.delete(filePath);
                    }

                if (tmpVideoPath != null)
                    Files.delete(tmpVideoPath);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private boolean unzip(String sourceFilePath, String tmpVideoPath) throws IOException {
        byte[] buffer = new byte[4096];
        FileInputStream fileInputStream = new FileInputStream(sourceFilePath);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        ZipInputStream zipInputStream = new ZipInputStream(bufferedInputStream);

        try {
            ZipEntry zipEntry = zipInputStream.getNextEntry();

            while (zipEntry != null) {
                if (!zipEntry.isDirectory()) {
                    String zipEntryName = zipEntry.getName();
                    if (zipEntryName.endsWith(".mp4")) {
                        File file = new File(tmpVideoPath, zipEntryName);

                        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
                             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream, buffer.length)) {

                            int len = zipInputStream.read(buffer);
                            while (len > 0) {
                                bufferedOutputStream.write(buffer, 0, len);
                                len = zipInputStream.read(buffer);
                            }
                        }
                    }
                }
                zipEntry = zipInputStream.getNextEntry();
            }
            zipInputStream.closeEntry();
            zipInputStream.close();
            return true;
        } catch (IllegalArgumentException e) {
            zipInputStream.close();
            ExcelImportLogger.logError("Ein Dateiname in der Zip Datei enthält ungültige Zeichen (z.B. Klammern)");
            return false;
        } catch (ZipException e) {
            zipInputStream.close();
            ExcelImportLogger.logError("Die verwendete Kompressionsmethode wird nicht unterstützt. Bitte nutzen Sie 7Zip oder Winzip.");
            return false;
        }
    }

    private void convert(File tmpVideoDir, File[] videoFiles) throws IOException, InterruptedException {
        for (File file : videoFiles) {

            String filePath = file.getAbsolutePath();
            String filename = file.getName();

            ProcessBuilder processBuilder = new ProcessBuilder(ffmpegCommand,
                    "-n",
                    "-i",
                    filePath,
                    "-an",
                    "-crf 28",
                    filename + ".mp4");

            processBuilder.directory(tmpVideoDir);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            process.waitFor();
        }
    }

    private void copy(File[] tempVideoFiles) throws IOException {
        Path videoPath = Paths.get(videoLocation);

        for (File tempVideoFile : tempVideoFiles) {
            Path sourcePath = tempVideoFile.toPath();
            Path targetPath = Paths.get(videoPath + File.separator + tempVideoFile.getName());
            Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
        }
    }

    private String resolveFFmpegCommand(OS os) {
        switch (os) {
            case Windows:
                return libLocation + File.separator + "ffmpeg.exe";
            case Linux:
                return libLocation + File.separator + "linuxffmpeg";
            case Mac:
                return libLocation + File.separator + "macosffmpeg";
            default:
                throw new RuntimeException("Unsupported OS: " + os.name());
        }
    }
}
