package de.signWritingEditor.server.service.video;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import de.signWritingEditor.server.service.ConfigurationService.OS;
import de.signWritingEditor.shared.infrastructure.URLConverter;

public class FfmpegVideoUtilService {

	private static final Logger LOGGER = Logger.getLogger(FfmpegVideoUtilService.class);

	private final File cacheDirectory;
	private final File uploadDirectory;
	private final OS os;
	private final URLConverter urlConverter;
	private final String ffmpegCall;
	private final String delegsUrl;

	public FfmpegVideoUtilService(File libDirectory, File cacheDirectory, File uploadDirectory, OS os,
			URLConverter urlConverter, String delegsUrl) {
		this.cacheDirectory = cacheDirectory;
		this.uploadDirectory = uploadDirectory;
		this.os = os;
		this.urlConverter = urlConverter;
		this.delegsUrl = delegsUrl;

		if (!libDirectory.exists()) {
			RuntimeException e = new RuntimeException(
					"INCORRECT SERVER SETUP: lib directory not found at: " + libDirectory.getAbsolutePath());
			LOGGER.fatal(e);
			throw e;
		}

		ffmpegCall = libDirectory.getAbsolutePath() + File.separator + getOSSpecificExecutable();
	}

	private String getOSSpecificExecutable() {
		switch (os) {
		case Windows:
			return "ffmpeg.exe";

		case Linux:
			return "linuxffmpeg";

		case Mac:
			return "macosffmpeg";

		default:
			RuntimeException e = new RuntimeException("Unsupported OS: " + os.name());
			LOGGER.fatal(e);
			throw e;
		}
	}

	public boolean ensureStillJpgExists(String url) {
		assert url != null : "Precondition failed: url != null";
		boolean generated = false;

		try {
			String videoName = urlEncode(url);
			String stillName = videoName + ".jpg";
			File stillFile = new File(cacheDirectory, stillName);

			String source = sourceFromUrl(url);

			if (!stillFile.exists()) {
				LOGGER.debug("EXTRACTING STILL FROM " + source);
				ProcessBuilder processBuilder = new ProcessBuilder(ffmpegCall, //
						"-loglevel", "quiet", //
						"-y", //
						"-i", source, //
						"-vframes", "1", stillName.replaceAll("%", "%%"));
				processBuilder.directory(cacheDirectory);
				processBuilder.redirectErrorStream(true);

				Process process = processBuilder.start();
				new StreamGobbler(process.getInputStream()).start();
				process.waitFor(); // synchronuous(!)
				generated = stillFile.exists();
				LOGGER.info("STILL FILE " + stillFile.getAbsolutePath() + " EXTRACTED FROM " + source);
			} else {
				generated = true;
			}
			assert stillFile.exists() : "Postcondition failed: new still file does not exist: "
					+ stillFile.getAbsolutePath();
		} catch (Exception e) {
			LOGGER.error(e);
			throw new RuntimeException("Fehler beim Erzeugen des Video-Stills.", e);
		}
		return generated;
	}

	public String sourceFromUrl(String url) {
		if (!url.startsWith(delegsUrl))
			return url;

		// Uploaded videos are already available, no need to download again
		int indexOfLastSlash = url.lastIndexOf('/');
		String filename = url.substring(indexOfLastSlash + 1);
		return uploadDirectory + File.separator + filename;
	}

	public boolean ensureMp4WebmVideosExist(String url) {
		assert cacheDirectory != null : "Precondition failed: cacheDirectory != null";
		assert cacheDirectory.exists() : "Precondition failed: cacheDirectory.exists()";
		assert cacheDirectory.isDirectory() : "Precondition failed: cacheDirectory.isDirectory()";
		assert url != null : "Precondition failed: url != null";

		String videoName = urlEncode(url);
		File mp4VideoFile = new File(cacheDirectory, videoName + ".mp4");
		File webmVideoFile = new File(cacheDirectory, videoName + ".webm");

		String source = sourceFromUrl(url);

		if (mp4VideoFile.exists() || webmVideoFile.exists()) {
			return true;
		}

		else if (videoName.toLowerCase().endsWith(".mov") && !mp4VideoFile.exists()) {
			doConvertVideo(videoName, source, "mp4");
			return true;
		}

		else if (videoName.toLowerCase().endsWith(".webm") && !webmVideoFile.exists()) {
			doConvertVideo(videoName, source, "webm");
			return true;
		}

		else if (videoName.toLowerCase().endsWith(".mp4")) {
			if (!webmVideoFile.exists()) {
				doConvertVideo(videoName, source, "webm");
			}
			return true;
		}

		return false;
	}

	public String urlEncode(String url) {
		assert url != null : "Precondition failed: url != null";
		String result = urlConverter.encode(url);

		if (os == OS.Windows) {
			// Use only last 50 chars to prevent too long paths on windows
			LOGGER.warn("Path potentially too long for windows");
        }
		return result;
	}

	// protected interface
	protected void doConvertVideo(String videoName, String source, String toVideoFormat) {
		assert videoName != null : "Precondition failed: videoName != null";
		assert source != null : "Precondition failed: source != null";

		try {
			LOGGER.debug("PREPARE CONVERTING VIDEO " + source + " TO " + toVideoFormat);

			ProcessBuilder processBuilder = null;
			if (toVideoFormat.equals("mp4")) {
				processBuilder = new ProcessBuilder(ffmpegCall, "-v", "-8", //
						"-y", //
						"-i", source, //
						"-vcodec", "h264", "-an", "-preset", "ultrafast", "-pix_fmt", "yuv420p", //
						"-g", "10", "-keyint_min", "1", "-vf", "scale=-2:1080", //
						videoName + ".mp4");
			} else if (toVideoFormat.equals("webm")) {
				processBuilder = new ProcessBuilder(ffmpegCall, "-v", "-8", //
						"-y", //
						"-i", source, //
						"-c:v", "libvpx", "-crf", "10", "-b:v", "250k", "-an", //
						videoName + ".webm");
			} else {
				assert false : "Precondition failed: toVideoFormat.equals(\"mp4\") || toVideoFormat.equals(\"webm\"): "
						+ toVideoFormat;
			}

			processBuilder.directory(cacheDirectory);
			processBuilder.redirectErrorStream(true);
			Process process = processBuilder.start(); // asynchronuous(!)

			new StreamGobbler(process.getInputStream()).start();

			LOGGER.debug("CONVERTING VIDEO " + source + " TO " + toVideoFormat);
			process.waitFor(); // synchronous
		} catch (Exception e) {
			LOGGER.error(e);
			throw new RuntimeException("Fehler beim Konvertieren des Videos nach " + toVideoFormat + ".");
		}

	}

	public String getPosterUrl(String url) {
		return cacheDirectory.getAbsolutePath() + "/" + urlEncode(url) + ".jpg";
	}

	private static class StreamGobbler extends Thread {
		private InputStream stream;

		private StreamGobbler(InputStream stream) {
			assert stream != null : "Precondition failed: stream != null";
			this.stream = stream;
		}

		@Override
		public void run() {
			try (BufferedReader br = new BufferedReader(new InputStreamReader(stream))) {
				String line = br.readLine();
				while (line != null) {
					LOGGER.error(line); // as ffmpeg is started in quiet mode,
					// all output is most likely to be an
					// error
					line = br.readLine();
				}
			} catch (IOException ignored) {
			}
		}
	}

}
