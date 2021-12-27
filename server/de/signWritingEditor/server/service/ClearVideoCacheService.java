package de.signWritingEditor.server.service;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;

public class ClearVideoCacheService {

	private static final Logger LOG = Logger.getLogger(ClearVideoCacheService.class);

	public static void clearCache() {
		try {
			ConfigurationService configurationService = new ConfigurationService();
			File cacheDir = new File(configurationService.getProperty(ConfigurationService.PROPERTY_VIDEO_CACHE_DIR));

			assert cacheDir != null : "Precondition failed: cacheDir != null";
			assert cacheDir.exists() : "Precondition failed: cacheDir.exists()";
			assert cacheDir.isDirectory() : "Precondition failed: cacheDir.isDirectory()";

			LOG.info("Start ClearVideoCacheService: Delete video cache in " + cacheDir.getAbsolutePath());

			for (File file : cacheDir.listFiles()) {
				boolean result = file.delete();
				assert result : "Precondition failed: result ";
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		clearCache();
	}
}
