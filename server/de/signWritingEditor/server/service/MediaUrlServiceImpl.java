package de.signWritingEditor.server.service;

import de.signWritingEditor.client.service.MediaUrlService;

public class MediaUrlServiceImpl implements MediaUrlService {
	private ConfigurationService configurationService;

	public MediaUrlServiceImpl(ConfigurationService configurationService) {
		this.configurationService = configurationService;
	}

	@Override
	public String getMediaUrl() {
		return configurationService.getProperty(ConfigurationService.PROPERTY_MEDIA_URL);
	}
}
