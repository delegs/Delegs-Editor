package de.signWritingEditor.client.GWTClient.ui.tool.subtools.fileManagement;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import java.util.List;

import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;

import de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.MessageDialogBox;
import de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.YesNoDialogBox;
import de.signWritingEditor.client.service.DocumentServiceAsync;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.client.service.LocalSessionService;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.material.FileItem;
import de.signWritingEditor.shared.model.material.FolderItem;
import de.signWritingEditor.shared.model.material.RoomItem;

public abstract class SaveDocumentDialogBox extends DocumentDialogBox {
	public SaveDocumentDialogBox(LocalSessionService localSessionService, FontSizeService fontSizeService,
			DocumentServiceAsync documentService, FolderItem startFolder, RoomItem rootRoomItem, FileTitle fileTitle) {
		super(localSessionService, fontSizeService, documentService, startFolder, rootRoomItem, I18N.getSaveAs(),
				I18N.getSave(), I18N.getCancel(), fileTitle, false, false);

		getFileNameTextBox().addKeyPressHandler(new KeyPressHandler() {

			@Override
			public void onKeyPress(KeyPressEvent event) {
				if (event.getNativeEvent().getKeyCode() == KeyCodes.KEY_ENTER && getConfirmButton().isEnabled()) {
					onActivateDocument();
				}
			}
		});
	}

	protected abstract void save(FileTitle fileTitle, FolderItem fileLocation, RoomItem roomContainingFolder);

	@Override
	protected void onOpenFolder(FolderItem folderItem) {
		getConfirmButton().setEnabled(getFileBrowser().isCreateFilePermitted());
	}

	@Override
	protected void onSelectFilesChanged(List<FileItem> selectedFileItems) {
		getConfirmButton().setEnabled(
				!getFileBrowser().isCurrentFolderInRecycleBin() && getFileBrowser().isModifySelectedFilesPermitted());
	}

	@Override
	protected void onFileNameChanged(String typedFileName) {
		handleFileNameChanged(typedFileName);
	}

	private void handleFileNameChanged(String typedFileName) {
		assert typedFileName != null : "Precondition failed: typedFileName != null";

		LazyLoadingFileBrowser fileBrowser = getFileBrowser();

		boolean saveButtonEnabled = !fileBrowser.isCurrentFolderInRecycleBin()
				&& (!fileBrowser.containsDocumentWithName(typedFileName)
						|| fileBrowser.isModifyDocumentPermitted(typedFileName));

		getConfirmButton().setEnabled(saveButtonEnabled);
	}

	/**
	 * Called when confirmButton is clicked.
	 */
	@Override
	protected void onActivateDocument() {
		final String documentTitleInput = getFileNameTextBox().getText().trim();

		if (FileTitle.isValidTitle(documentTitleInput)) {
			if (containsDocumentName(documentTitleInput)) {
				if (getFileBrowser().isModifyDocumentPermitted(documentTitleInput)) {
					new YesNoDialogBox(I18N.getDocumentAlreadyExists(), I18N.getOverwriteQuestion()) {
						@Override
						public void onYes() {
							save(new FileTitle(documentTitleInput), getFileBrowser().getCurrentFolder(),
									getFileBrowser().getCurrentRoom());
							SaveDocumentDialogBox.this.hide();
							SaveDocumentDialogBox.this.removeFromParent();
						}

						@Override
						public void onNo() {
						}
					}.center();
				} else {
					new MessageDialogBox(I18N.getAccessDeniedTitle(), I18N.getAccessDeniedOnOverwritingDocument())
							.center();
				}
			} else {
				save(new FileTitle(documentTitleInput), getFileBrowser().getCurrentFolder(),
						getFileBrowser().getCurrentRoom());
				hide();
			}

		} else {
			new MessageDialogBox(I18N.getNote(), I18N.getPleaseEnterValidFileName()).center();
		}
	}
}
