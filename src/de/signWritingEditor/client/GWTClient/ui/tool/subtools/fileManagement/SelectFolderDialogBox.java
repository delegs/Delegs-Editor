package de.signWritingEditor.client.GWTClient.ui.tool.subtools.fileManagement;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import java.util.List;

import de.signWritingEditor.client.service.DocumentServiceAsync;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.client.service.LocalSessionService;
import de.signWritingEditor.shared.model.material.FileItem;
import de.signWritingEditor.shared.model.material.FolderItem;
import de.signWritingEditor.shared.model.material.RoomItem;

public abstract class SelectFolderDialogBox extends DocumentDialogBox {

	public SelectFolderDialogBox(LocalSessionService localSessionService, FontSizeService fontSizeService,
			DocumentServiceAsync documentService, FolderItem startFolder, RoomItem rootRoomItem) {
		super(localSessionService, fontSizeService, documentService, startFolder, rootRoomItem, I18N.getMoveFile(),
				I18N.getMoveFile(), I18N.getClose(), startFolder.getFileTitle(), false, true);
	}

	public SelectFolderDialogBox(LocalSessionService localSessionService, FontSizeService fontSizeService,
			DocumentServiceAsync documentService, FolderItem startFolder, RoomItem rootRoomItem, String action) {
		super(localSessionService, fontSizeService, documentService, startFolder, rootRoomItem, action, action,
				I18N.getClose(), startFolder.getFileTitle(), false, true);
	}

	protected abstract void onFolderSelected(FolderItem targetFolderItem);

	@Override
	protected void onActivateDocument() {
		onFolderSelected(this.getFileBrowser().getCurrentFolder());
	}

	@Override
	protected void onOpenFolder(FolderItem folderItem) {
		getConfirmButton().setEnabled(getFileBrowser().isCreateFilePermitted());
	}

	@Override
	protected void onSelectFilesChanged(List<FileItem> selectedFileItems) {
		// Not needed here
	}

	@Override
	protected void onFileNameChanged(String typedFileName) {
		// Not needed here
	}
}
