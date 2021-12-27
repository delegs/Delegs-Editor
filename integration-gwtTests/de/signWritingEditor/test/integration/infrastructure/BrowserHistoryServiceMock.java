package de.signWritingEditor.test.integration.infrastructure;

import de.signWritingEditor.client.service.BrowserHistoryService;
import de.signWritingEditor.shared.model.material.FileItem;

public class BrowserHistoryServiceMock implements BrowserHistoryService {

	@Override
	public void createHistoryToken(FileItem fileItem) {
	}

	@Override
	public void navigateToUrl(String url) {
	}

	@Override
	public void setBrowserHistoryListener(BrowserHistoryListener listener) {
	}

	@Override
	public void navigateToPreviousUrl() {
	}

	@Override
	public void openEmptyDocument() {
	}

	@Override
	public boolean isInPublicFolder() {
		return false;
	}

	@Override
	public boolean isInNewDocument(String href) {
		return false;
	}
}
