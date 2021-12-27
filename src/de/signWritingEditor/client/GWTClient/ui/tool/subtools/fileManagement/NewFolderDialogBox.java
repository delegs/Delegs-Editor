package de.signWritingEditor.client.GWTClient.ui.tool.subtools.fileManagement;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import java.util.List;

import com.google.gwt.user.client.ui.TextBox;

import de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.MessageDialogBox;
import de.signWritingEditor.shared.model.domainValue.FileTitle;

public abstract class NewFolderDialogBox extends FormDialogBox {
	private TextBox folderTitleTextBox;
	private final List<FileTitle> takenFileTitles;

	public NewFolderDialogBox(List<FileTitle> takenFolderTitles) {
		super(I18N.getNewFolder(), I18N.getNewFile());

		assert takenFolderTitles != null : "Precondition failed: takenFolderTitles != null";

		this.takenFileTitles = takenFolderTitles;

		folderTitleTextBox = new TextBox();
		folderTitleTextBox.setText(new FileTitle(I18N.getNewFolder()).getTitleString());
		addInputField(I18N.getFolderName() + ":", folderTitleTextBox);
	}

	@Override
	public void center() {
		super.center();

		folderTitleTextBox.setSelectionRange(0, folderTitleTextBox.getText().length());
		folderTitleTextBox.setFocus(true);
	}

	@Override
	protected void handleSubmit() {
		String folderTitleInput = folderTitleTextBox.getText();

		if (FileTitle.isValidUserTitle(folderTitleInput)) {
			FileTitle folderTitle = new FileTitle(folderTitleInput);

			if (!takenFileTitles.contains(folderTitle)) {
				handleCreateFolder(folderTitle);
				hide();
			} else {
				new MessageDialogBox(I18N.getNote(), I18N.getFileNameAlreadyTaken()).center();
			}
		} else {
			new MessageDialogBox(I18N.getNote(), I18N.getPleaseEnterValidFileName()).center();
		}
	}

	protected abstract void handleCreateFolder(FileTitle fileTitle);
}
