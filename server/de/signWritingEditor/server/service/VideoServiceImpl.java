package de.signWritingEditor.server.service;

import java.io.File;

import de.signWritingEditor.client.service.VideoService;
import de.signWritingEditor.server.communication.infrastructure.URLConverterServerImpl;
import de.signWritingEditor.server.service.ConfigurationService.OS;
import de.signWritingEditor.server.service.video.FfmpegVideoUtilService;
import de.signWritingEditor.shared.infrastructure.URLConverter;

public class VideoServiceImpl implements VideoService {
	FfmpegVideoUtilService videoUtil;

	public VideoServiceImpl(ConfigurationService configurationService) {
		OS os = configurationService.getOS();
		File libDirectory = new File(configurationService.getProperty(ConfigurationService.PROPERTY_VIDEO_LIB_DIR));
		File cacheDirectory = new File(configurationService.getProperty(ConfigurationService.PROPERTY_VIDEO_CACHE_DIR));
		File uploadDirectory = new File(
				configurationService.getProperty(ConfigurationService.PROPERTY_VIDEO_UPLOAD_DIR));
		URLConverter urlConverter = new URLConverterServerImpl();

		if (!cacheDirectory.exists() || !cacheDirectory.isDirectory()) {
			cacheDirectory.mkdirs();
		}
		String delegsUrl = configurationService.getProperty(ConfigurationService.PROPERTY_APP_URL);

		videoUtil = new FfmpegVideoUtilService(libDirectory, cacheDirectory, uploadDirectory, os, urlConverter, delegsUrl);
	}

	@Override
	public boolean loadVideoFromUrl(String url) {
		boolean result = false;
		String lowerURL = url.toLowerCase();
		if (lowerURL.contains(".mp4") || lowerURL.contains(".webm") || lowerURL.contains(".mov")) {
			result = videoUtil.ensureStillJpgExists(url);
			result = videoUtil.ensureMp4WebmVideosExist(url) && result;
			return result;
		}
		return false;

	}

	public String urlEncode(String url) {
		return videoUtil.urlEncode(url);
	}

	public String getPosterUrl(String url) {
		return this.videoUtil.getPosterUrl(url);
	}
}
