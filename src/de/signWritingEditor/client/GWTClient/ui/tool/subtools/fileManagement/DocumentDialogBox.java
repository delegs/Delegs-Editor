package de.signWritingEditor.client.GWTClient.ui.tool.subtools.fileManagement;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Float;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.signWritingEditor.client.GWTClient.ui.general.widget.OrientedFlowPanel;
import de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.MessageDialogBox;
import de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.ModalDialogBox;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.fileManagement.LazyLoadingFileBrowser.LazyLoadingFileBrowserListener;
import de.signWritingEditor.client.service.DocumentServiceAsync;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.client.service.LocalSessionService;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.Orientation;
import de.signWritingEditor.shared.model.material.DocumentItem;
import de.signWritingEditor.shared.model.material.FileItem;
import de.signWritingEditor.shared.model.material.FolderItem;
import de.signWritingEditor.shared.model.material.RoomItem;

public abstract class DocumentDialogBox extends ModalDialogBox {

	private static final int FILE_BROWSER_HEIGHT = 400;
	private static final int FILE_BROWSER_WIDTH = 800;

	private Button confirmButton;

	private TextBox fileNameTextBox;
	private LazyLoadingFileBrowser fileBrowser;

	public DocumentDialogBox(LocalSessionService localSessionService, FontSizeService fontSizeService, DocumentServiceAsync documentService,
			FolderItem startFolder, RoomItem rootRoomItem, String title,
			String confirmButtonCaption, String closeButtonCaption, FileTitle fileTitle, final boolean isMultipleSelect,
			boolean onlyFolders) {
		assert closeButtonCaption != null : "Precondition failed: closeButtonCaption != null";
		assert confirmButtonCaption != null : "Precondition failed: confirmButtonCaption != null";
		assert title != null : "Precondition failed: title != null";

		setText(title);

		VerticalPanel dialogPanel = new VerticalPanel();
		dialogPanel.setSpacing(5);

		dialogPanel.addHandler(new KeyDownHandler() {

			@Override
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_BACKSPACE) {
					event.stopPropagation();
				}
			}
		}, KeyDownEvent.getType());

		dialogPanel.sinkEvents(Event.ONKEYDOWN);

		fileBrowser = GWT.create(LazyLoadingFileBrowser.class);
		fileBrowser.initFileBrowserAndLoadFolder(localSessionService, startFolder, rootRoomItem, documentService,
				fontSizeService, onlyFolders, FILE_BROWSER_WIDTH, FILE_BROWSER_HEIGHT,
				new LazyLoadingFileBrowserListener() {
					@Override
					public void onActivateDocument(DocumentItem activatedDocument, FolderItem currentFolder,
							RoomItem currentRoom) {
						DocumentDialogBox.this.onActivateDocument();
					}

					@Override
					public void onSelectFilesChanged(List<FileItem> selectedDocumentItems) {
						handleSelectFilesChanged(selectedDocumentItems);
					}

					@Override
					public void onOpenFolder(FolderItem folder) {
						handleOpenFolder(folder);
					}

					@Override
					public void onDeletePressed() {
						// not used
					}

					@Override
					public void onAccessDenied(String message) {
						handleAccessDenied(message);
					}

					@Override
					public void onInvalidSessionExceptionCaught() {

					}
				});
		dialogPanel.add(fileBrowser);

		FlowPanel bottomPanel = new OrientedFlowPanel(Orientation.HORIZONTAL);
		bottomPanel.setWidth(FILE_BROWSER_WIDTH + "px");
		dialogPanel.add(bottomPanel);

		if (!onlyFolders) {
			String bottomLabelText = I18N.getDocumentName() + ":";
			Label fileNameLabel = new Label(bottomLabelText);
			fileNameLabel.setWidth(17.5 + "%");
			bottomPanel.add(fileNameLabel);

			// TextBox to enter file name:
			fileNameTextBox = new TextBox();
			fileNameTextBox.setWidth(54 + "%");
			fileNameTextBox.getElement().getStyle().setMarginLeft(8, Unit.PX);
			bottomPanel.add(fileNameTextBox);

			String fileNameString = "";
			if (fileTitle != null) {
				fileNameString = fileTitle.getTitleString();
			}
			fileNameTextBox.setText(fileNameString);

			fileNameTextBox.addKeyUpHandler(new KeyUpHandler() {
				@Override
				public void onKeyUp(KeyUpEvent event) {
					onFileNameChanged(fileNameTextBox.getText());
				}
			});
		}

		// Abort button
		Button closeButton = new Button(closeButtonCaption);
		closeButton.getElement().getStyle().setFloat(Float.RIGHT);
		closeButton.setWidth(12.5 + "%");
		bottomPanel.add(closeButton);

		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				hide();
			}
		});

		confirmButton = new Button(confirmButtonCaption);
		confirmButton.getElement().getStyle().setFloat(Float.RIGHT);
		confirmButton.setWidth(12.5 + "%");
		bottomPanel.add(confirmButton);

		confirmButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				onActivateDocument();
			}
		});

		setWidget(dialogPanel);
	}

	protected LazyLoadingFileBrowser getFileBrowser() {
		return fileBrowser;
	}

	protected TextBox getFileNameTextBox() {
		return fileNameTextBox;
	}

	protected Button getConfirmButton() {
		return confirmButton;
	}

	protected boolean containsDocumentName(String documentName) {
		assert documentName != null : "Precondition failed: documentName != null";

		return fileBrowser.containsDocumentWithName(documentName);
	}

	protected abstract void onActivateDocument();

	protected abstract void onOpenFolder(FolderItem folderItem);

	protected abstract void onSelectFilesChanged(List<FileItem> selectedFileItems);

	protected abstract void onFileNameChanged(String typedFileName);

	protected abstract void onInvalidSessionExceptionCaught();

	private void handleAccessDenied(String message) {
		new MessageDialogBox(I18N.getAccessDeniedTitle(), message).center();
	}

	private void handleSelectFilesChanged(List<FileItem> selectedFileItems) {
		assert selectedFileItems != null : "Precondition failed: selectedFileItems != null";

		// File name text box is null for folder selection dialogs
		if (fileNameTextBox != null && selectedFileItems.size() > 0) {
			FileItem fileItem = selectedFileItems.get(0);
			if (fileItem instanceof DocumentItem) {
				fileNameTextBox.setText(fileItem.getFileTitle().getTitleString());
			}
		}

		onSelectFilesChanged(selectedFileItems);
	}

	private void handleOpenFolder(FolderItem folderItem) {
		assert folderItem != null : "Precondition failed: folderItem != null";
		onOpenFolder(folderItem);
	}
}