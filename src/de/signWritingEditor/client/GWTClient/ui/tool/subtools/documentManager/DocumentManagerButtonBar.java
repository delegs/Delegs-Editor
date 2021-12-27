package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentManager;

import static de.signWritingEditor.client.GWTClient.ui.tool.general.imageHandling.Resources.RESOURCE;
import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Image;

import de.signWritingEditor.client.GWTClient.ui.general.widget.ArrowPopupPanel;
import de.signWritingEditor.client.GWTClient.ui.tool.general.tool.ButtonBar;
import de.signWritingEditor.client.GWTClient.ui.tool.general.tool.ToolBarButton;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentManager.ColorLabelChooser.ColorLabelChooserListener;
import de.signWritingEditor.shared.model.domainValue.FileItemColorLabel;

public class DocumentManagerButtonBar extends ButtonBar {
	private final DocumentManagerButtonBarListener listener;

	private ToolBarButton deleteButton;
	private ToolBarButton newFolderButton;
	private ToolBarButton moveFileButton;
	private ToolBarButton renameFileButton;
	private ToolBarButton openButton;
	private ToolBarButton colorLabelButton;
	private ToolBarButton searchButton;
	private ToolBarButton copyFileButton;

	private ToolBarButton newRoomButton;

	private ArrowPopupPanel colorChooserPopup;

	public DocumentManagerButtonBar(DocumentManagerButtonBarListener listener) {
		super();

		assert listener != null : "Precondition failed: listener != null";

		this.listener = listener;

		init();
	}

	public void enableOpenButton(boolean enabled) {
		openButton.setEnabled(enabled);
	}

	public void enableDeleteButton(boolean enabled) {
		deleteButton.setEnabled(enabled);
	}

	public void enableMoveButton(boolean enabled) {
		moveFileButton.setEnabled(enabled);
	}

	public void enableCopyButton(boolean enabled) {
		copyFileButton.setEnabled(enabled);
	}

	public void enableRenameButton(boolean enabled) {
		renameFileButton.setEnabled(enabled);
	}

	public void enableNewFolderButton(boolean enabled) {
		newFolderButton.setEnabled(enabled);
	}

	public void enableColorLableButton(boolean enabled) {
		colorLabelButton.setEnabled(enabled);
	}

	public void enableNewRoomButton(boolean enabled) {
		newRoomButton.setEnabled(enabled);
	}

	public void setNewRoomButtonVisible(boolean visible) {
		newRoomButton.setVisible(visible);
	}

	public void setSearchButtonPressed(boolean pressed) {
		searchButton.setPressed(pressed);
	}

	public void init() {
		ToolBarButton newButton = new ToolBarButton(new Image(RESOURCE.getToolBarIconNewDocument()),
				I18N.getNewDocument(), new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						listener.onOpenNewDocument();
					}
				});
		newButton.ensureDebugId("documentManagerButtonBar-newButton");
		addWidget(newButton);

		newFolderButton = new ToolBarButton(new Image(RESOURCE.getToolBarIconNewFolder()),
				new Image(RESOURCE.getToolBarIconNewFolderDis()), I18N.getNewFolder(), new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						listener.onCreateNewFolder();
					}
				});
		newFolderButton.ensureDebugId("documentManagerButtonBar-newFolderButton");
		addWidget(newFolderButton);

		openButton = new ToolBarButton(new Image(RESOURCE.getToolBarIconOpen()),
				new Image(RESOURCE.getToolBarIconOpenDis()), I18N.getDoOpenDocument(), new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						listener.onOpen();
					}
				});
		openButton.ensureDebugId("documentManagerButtonBar-openButton");
		addWidget(openButton);

		deleteButton = new ToolBarButton(new Image(RESOURCE.getToolBarIconDeleteDocument()),
				new Image(RESOURCE.getToolBarIconDeleteDocumentDis()), I18N.getDoDeleteDocument(), new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						listener.onDeleteFile();
					}
				});
		deleteButton.ensureDebugId("documentManagerButtonBar-deleteButton");
		addWidget(deleteButton);

		moveFileButton = new ToolBarButton(new Image(RESOURCE.getToolBarIconMove()),
				new Image(RESOURCE.getToolBarIconMoveDis()), I18N.getMoveFile(), new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						listener.onMoveFiles();
					}
				});
		moveFileButton.ensureDebugId("documentManagerButtonBar-moveFileButton");
		addWidget(moveFileButton);

		copyFileButton = new ToolBarButton(new Image(RESOURCE.getToolBarIconCopy()),
				new Image(RESOURCE.getToolBarIconCopyDis()), I18N.getCopyFile(), new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						listener.onCopyFiles();
					}
				});
		addWidget(copyFileButton);

		renameFileButton = new ToolBarButton(new Image(RESOURCE.getToolBarIconRename()),
				new Image(RESOURCE.getToolBarIconRenameDis()), I18N.getRenameFile(), new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						listener.onRenameFile();
					}
				});
		renameFileButton.ensureDebugId("documentManagerButtonBar-renameFileButton");
		addWidget(renameFileButton);

		colorLabelButton = new ToolBarButton(new Image(RESOURCE.getToolBarIconColorLabel()),
				new Image(RESOURCE.getToolBarIconColorLabelDis()), I18N.getColorLabel(), new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						handleColorLabelButtonClicked(event);
					}
				});
		colorLabelButton.ensureDebugId("colorLabelButton");
		addWidget(colorLabelButton);

		colorChooserPopup = new ArrowPopupPanel();

		ColorLabelChooser colorLabelChooser = new ColorLabelChooser(new ColorLabelChooserListener() {
			@Override
			public void onColorLabelChosen(FileItemColorLabel colorLabel) {
				listener.onSetFileItemColorLabel(colorLabel);
			}
		});
		colorChooserPopup.add(colorLabelChooser);

		newRoomButton = new ToolBarButton(new Image(RESOURCE.getToolBarIconNewRoom()),
				new Image(RESOURCE.getToolBarIconNewRoomDis()), I18N.getNewRoom(), new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						listener.onCreateNewRoom();
					}
				});
		addWidget(newRoomButton);

		searchButton = new ToolBarButton(new Image(RESOURCE.getToolBarIconSearch()),
				new Image(RESOURCE.getToolBarIconSearchDis()), I18N.getSearchButtonText(), new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						listener.onOpenSearchWindow();
					}
				});
		searchButton.ensureDebugId("searchButton");
		addWidget(searchButton);

	}

	private void handleColorLabelButtonClicked(ClickEvent event) {
		assert event != null : "Precondition failed: event != null";

		if (!colorChooserPopup.isAttached()) {
			colorChooserPopup.displayBelow(colorLabelButton);

			// There is another click handler that removes the
			// colorChooserPopup, so prevent it from getting the event
			event.stopPropagation();
		}
	}

	public interface DocumentManagerButtonBarListener {
		void onSetFileItemColorLabel(FileItemColorLabel colorLabel);

		void onOpen();

		void onMoveFiles();

		void onCopyFiles();

		void onDeleteFile();

		void onCreateNewFolder();

		void onRenameFile();

		void onOpenNewDocument();

		void onCreateNewRoom();

		void onOpenSearchWindow();
	}
}
