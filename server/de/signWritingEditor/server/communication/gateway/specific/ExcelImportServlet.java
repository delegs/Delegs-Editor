package de.signWritingEditor.server.communication.gateway.specific;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import excel.ExcelImportLogger;
import excel.ExcelImportTimer;
import excel.ExcelImportTimerState;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import de.signWritingEditor.server.communication.gateway.SignWritingServlet;
import de.signWritingEditor.server.service.ConfigurationService;
import excel.ExcelImportService;
import videoImport.VideoImportService;

public class ExcelImportServlet extends SignWritingServlet {

    private static final long serialVersionUID = -3851612629630870720L;
    private static final Logger LOG = Logger.getLogger(ExcelImportServlet.class);
    private static final String EXCEL_IMPORT_PATH = "esf.excel.folder";
    private ServletFileUpload uploader;
    private File excelFolder;
    private ExcelImportService excelImportService;
    private VideoImportService videoImportService;
    private final Gson gson = new Gson();

    @Override
    protected Logger getLog() {
        return LOG;
    }

    @Override
    public void init() {
        try {
            ConfigurationService configService = new ConfigurationService();
            excelImportService = new ExcelImportService(configService);
            videoImportService = new VideoImportService(configService);
            excelFolder = new File(configService.getProperty(EXCEL_IMPORT_PATH));
            DiskFileItemFactory fileFactory = new DiskFileItemFactory();
            fileFactory.setRepository(excelFolder);
            uploader = new ServletFileUpload(fileFactory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        assert request != null : "Precondition failed: request != null";
        assert response != null : "Precondition failed: response != null";

        ExcelImportTimer.setTimeStamp(ExcelImportTimerState.START);

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST");
        response.setHeader("Access-Control-Max-Age", "600");
        response.setHeader("Access-Control-Allow-Headers", "content-type");
        response.setHeader("Content-Type", "text/plain");

        if (!ServletFileUpload.isMultipartContent(request))
            throw new ServletException("Content type is not multipart/form-data");

        try {

            ExcelImportLogger.clear();

            List<FileItem> uploadedFiles = uploader.parseRequest(request);
            ExcelImportTimer.setTimeStamp(ExcelImportTimerState.UPLOAD);
            String uploadDurationString = ExcelImportTimer.getDurationString(ExcelImportTimerState.START, ExcelImportTimerState.UPLOAD);
            String uploadDurationMessage = String.format("Upload abgeschlossen. %s", uploadDurationString);
            ExcelImportLogger.logInfo(uploadDurationMessage);

            for (FileItem fileItem : uploadedFiles) {

                String filename = fileItem.getName();
                String fieldName = fileItem.getFieldName();
                LocalDateTime currentDateTime = LocalDateTime.now();
                String sha256Hex = DigestUtils.sha256Hex(fieldName + currentDateTime);
                String fileName = sha256Hex.substring(0, 7);

                if (filename.endsWith(".zip")) {

                    String fileNamePrefix = "videos-";
                    String fileExtension = ".zip";
                    String finalFileName = fileNamePrefix + fileName + fileExtension;
                    File sourceFile = new File(excelFolder, finalFileName);
                    fileItem.write(sourceFile);

                    boolean videoImportSuccess = videoImportService.runImport(sourceFile);
                    Path sourceFilePath = sourceFile.toPath();
                    Files.delete(sourceFilePath);

                    if (!videoImportSuccess)
                        break;
                }

                if (filename.endsWith(".xlsx")) {

                    String fileNamePrefix = "import-";
                    String fileExtension = ".xlsx";
                    String finalFileName = fileNamePrefix + fileName + fileExtension;
                    File sourceFile = new File(excelFolder, finalFileName);
                    fileItem.write(sourceFile);

                    excelImportService.runImport(sourceFile);
                    Path sourceFilePath = sourceFile.toPath();
                    Files.delete(sourceFilePath);
                }
            }

            ExcelImportTimer.setTimeStamp(ExcelImportTimerState.END);

            String totalDurationString = ExcelImportTimer.getDurationString(ExcelImportTimerState.START, ExcelImportTimerState.END);
            String totalDurationMessage = String.format("Import abgeschlossen. %s", totalDurationString);
            ExcelImportLogger.logInfo(totalDurationMessage);

            PrintWriter responseWriter = response.getWriter();
            String logText = ExcelImportLogger.getLogText();
            String logTextAsJson = gson.toJson(logText);
            responseWriter.write(logTextAsJson);

        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        } finally {
            File[] createdFiles = excelFolder.listFiles();
            if (createdFiles != null)
                for (File createdFile : createdFiles) {
                    Path createdFilePath = createdFile.toPath();
                    Files.delete(createdFilePath);
                }
        }
    }
}
