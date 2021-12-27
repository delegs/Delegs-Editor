package de.signWritingEditor.client.GWTClient.ui.tool.subtools.fileManagement;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import java.util.List;

import com.google.gwt.user.client.ui.TextBox;

import de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.MessageDialogBox;
import de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.YesNoDialogBox;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.material.DocumentItem;
import de.signWritingEditor.shared.model.material.FileItem;
import de.signWritingEditor.shared.model.material.FolderItem;
import de.signWritingEditor.shared.model.material.RoomItem;

public abstract class RenameFileDialogBox extends FormDialogBox {
	private TextBox fileTitleTextBox;
	private FileItem fileItem;
	private final List<FileTitle> takenFileTitles;

	public RenameFileDialogBox(FileItem fileItem, List<FileTitle> takenFileTitles) {
		super(I18N.getRenameFile(), I18N.getDoChangeTitle());

		assert takenFileTitles != null : "Precondition failed: takenFileTitles != null";
		assert fileItem != null : "Precondition failed: fileItem != null";

		this.fileItem = fileItem;
		this.takenFileTitles = takenFileTitles;

		// TextBox to enter document name:
		fileTitleTextBox = new TextBox();
		fileTitleTextBox.setText(fileItem.getFileTitle().getTitleString());
		addInputField(I18N.getNewFileTitle() + ":", fileTitleTextBox);
	}

	@Override
	public void center() {
		super.center();

		fileTitleTextBox.setSelectionRange(0, fileTitleTextBox.getText().length());
		fileTitleTextBox.setFocus(true);
	}

	@Override
	protected void handleSubmit() {
		String fileTitleInput = fileTitleTextBox.getText();
		if ((fileItem instanceof FolderItem && FileTitle.isValidUserTitle(fileTitleInput))
				|| (fileItem instanceof DocumentItem && FileTitle.isValidTitle(fileTitleInput))) {
			final FileTitle fileTitle = new FileTitle(fileTitleInput);
			if (!takenFileTitles.contains(fileTitle)) {
				handleRenameFile(fileTitle);
				hide();
			} else if (fileItem instanceof RoomItem) {
				new YesNoDialogBox(I18N.getNote(), I18N.getRoomNameDuplicateWarning()) {

					@Override
					public void onYes() {
						handleRenameFile(fileTitle);
						RenameFileDialogBox.this.hide();
					}

					@Override
					public void onNo() {
					}
				}.center();
			} else {
				new MessageDialogBox(I18N.getNote(), I18N.getFileNameAlreadyTaken()).center();
			}
		} else {
			new MessageDialogBox(I18N.getNote(), I18N.getPleaseEnterValidFileName()).center();
		}
	}

	protected abstract void handleRenameFile(FileTitle newFileTitle);
}
