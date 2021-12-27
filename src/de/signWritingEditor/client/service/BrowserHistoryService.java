package de.signWritingEditor.client.service;

import de.signWritingEditor.shared.model.material.DocumentItem;
import de.signWritingEditor.shared.model.material.FileItem;
import de.signWritingEditor.shared.model.material.FolderItem;

public interface BrowserHistoryService {

	public void createHistoryToken(FileItem token);

	public void navigateToUrl(String url);

	public void openEmptyDocument();

	public void setBrowserHistoryListener(BrowserHistoryListener listener);

	interface BrowserHistoryListener {

		void onDocumentItemRequested(FolderItem folderItem, DocumentItem documentItem);

		void onFolderItemRequested(FolderItem folderItem);

		void onDefaultFileItemRequested();

		void onFileItemAccessDenied();

		void onSessionInvalid();
	}

	public void navigateToPreviousUrl();

	public boolean isInPublicFolder();

	public boolean isInNewDocument(String href);
}
