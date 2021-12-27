package de.signWritingEditor.client.GWTClient.ui.tool.subtools.fileManagement;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;

import de.signWritingEditor.client.GWTClient.ui.general.animation.UiUtil;
import de.signWritingEditor.client.GWTClient.ui.general.lazyload.LazyLoadList;
import de.signWritingEditor.client.GWTClient.ui.general.lazyload.LazyLoadedRow;
import de.signWritingEditor.client.GWTClient.ui.general.lazyload.LazyLoadedRowContainer;
import de.signWritingEditor.client.GWTClient.ui.general.widget.OrientedFlowPanel;
import de.signWritingEditor.client.GWTClient.ui.tool.general.imageHandling.Resources;
import de.signWritingEditor.client.GWTClient.ui.tool.general.tool.SignWritingCallback;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.fileManagement.FileItemWidget.FileItemWidgetListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.fileManagement.FilePathWidget.FilePathWidgetListener;
import de.signWritingEditor.client.service.DocumentServiceAsync;
import de.signWritingEditor.client.service.FileItemComparator;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.client.service.InvalidSessionException;
import de.signWritingEditor.client.service.LocalSessionService;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.FolderContentAndPath;
import de.signWritingEditor.shared.model.domainValue.Orientation;
import de.signWritingEditor.shared.model.domainValue.SortCriteria;
import de.signWritingEditor.shared.model.material.DocumentItem;
import de.signWritingEditor.shared.model.material.FileItem;
import de.signWritingEditor.shared.model.material.FolderItem;
import de.signWritingEditor.shared.model.material.PdfFileItem;
import de.signWritingEditor.shared.model.material.RecycleBinItem;
import de.signWritingEditor.shared.model.material.RoomItem;
import de.signWritingEditor.shared.model.material.TemplateItem;

public class LazyLoadingFileBrowser extends Composite {

	private static final String SIGN_WRITING_EDITOR_PATH = "signwritingeditor/";

	private int width;
	private final int TITLE_BAR_HEIGHT = FileItemWidget.HEIGHT;

	private DocumentServiceAsync documentService;
	private LocalSessionService localSessionService;

	private List<FileItem> fileItems;

	private List<FileItemWidget> unusedFileItemWidgets;
	private Map<FileItem, FileItemWidget> fileItemToWidget;

	private List<FileItem> selectedFileItems;
	// Index of last selected fileItem, except for shift select:
	private int selectionAnchor;

	private SortCriteria currentSortCriteria;
	private int lastSelectedIndex;

	private boolean onlyFolders;

	private LazyLoadingFileBrowserListener listener;

	private FolderItem currentFolder;
	private RoomItem currentRoom;

	private LazyLoadList fileItemPanel;
	private FilePathWidget filePathWidget;
	private RoomItem rootRoomItem;
	private FontSizeService fontSizeService;

	private Storage localStorage;

	/**
	 * Initialize the filebrowser but does not load the folder from the server
	 * directly Reason for this is the need to allow for an delayed loading by
	 * the documentmanager. See: Documentmanager constructor,
	 * DocumentManager.open() and DocumentManager.setUsersession()
	 */
	public void initFileBrowserAndDoNotLoadFolder(LocalSessionService localSessionService,
			FontSizeService fontSizeService, DocumentServiceAsync documentService, FolderItem startFolder,
			RoomItem rootRoomItem, boolean onlyFolders, int width, int height,
			final LazyLoadingFileBrowserListener listener) {
		initializeContent(localSessionService, rootRoomItem, documentService, fontSizeService, onlyFolders, width,
				height, listener);
		if (Storage.isLocalStorageSupported()) {
			localStorage = Storage.getLocalStorageIfSupported();
		}
		currentFolder = startFolder;
	}

	/**
	 * Initialize the filebrowser and directly loads the folder from the server
	 * When using this, be sure to have a valid environment (Valid user session
	 * etc.)
	 */
	public void initFileBrowserAndLoadFolder(LocalSessionService localSessionService, FolderItem startFolder,
			RoomItem rootRoomItem, DocumentServiceAsync documentService, FontSizeService fontSizeService,
			boolean onlyFolders, int width, int height, final LazyLoadingFileBrowserListener listener) {
		initializeContent(localSessionService, rootRoomItem, documentService, fontSizeService, onlyFolders, width,
				height, listener);
		if (Storage.isLocalStorageSupported()) {
			localStorage = Storage.getLocalStorageIfSupported();
		}
		initializeStartFolder(startFolder);
	}

	public FolderItem getCurrentFolder() {
		return currentFolder;
	}

	public RoomItem getCurrentRoom() {
		return currentRoom;
	}

	public boolean hasSelectedFileItems() {
		return selectedFileItems.size() > 0;
	}

	public boolean containsDocumentWithName(String fileName) {
		assert fileName != null : "Precondition failed: fileName != null";

		boolean result = false;

		for (int i = 0, l = fileItems.size(); i < l && !result; i++) {
			FileItem fileItem = fileItems.get(i);
			result = fileItem instanceof DocumentItem && fileItem.getFileTitle().getTitleString().equals(fileName);
		}

		return result;
	}

	public void sortAndShowFiles() {
		Comparator<FileItem> comparator = new FileItemComparator(currentSortCriteria);
		if (!currentSortCriteria.isCurrentlyAscending()) {
			comparator = Collections.reverseOrder(comparator);
		}
		Collections.sort(fileItems, comparator);
		// Keep Type as default order
		Collections.sort(fileItems, new FileItemComparator(SortCriteria.TYPE));
		showFiles();
	}

	public boolean isCurrentFolderInRecycleBin() {
		boolean result = isRecycleBin(currentFolder);
		List<FolderItem> currentPath = filePathWidget.getPath();
		for (FolderItem folderItem : currentPath) {
			result |= isRecycleBin(folderItem);
		}

		return result;
	}

	public boolean areOnlyDocumentsOrFoldersSelected() {
		boolean result = hasSelectedFileItems();

		List<FileItem> selectedFileItems = getSelectedFileItems();

		for (int i = 0, l = selectedFileItems.size(); i < l && result; i++) {
			FileItem fileItem = selectedFileItems.get(i);

			result = !(fileItem instanceof RoomItem || fileItem instanceof RecycleBinItem);
		}

		return result;
	}

	public boolean isSystemFolderSelected() {
		boolean result = false;

		for (FileItem fileItem : getSelectedFileItems()) {
			if (fileItem instanceof FolderItem) {
				FolderItem folderItem = (FolderItem) fileItem;

				result |= isRecycleBin(folderItem) || isRootFolder(folderItem);

				if (result) {
					break;
				}
			}
		}

		return result;
	}

	public boolean isInRootRoom() {
		return isRootFolder(getCurrentFolder());
	}

	public List<FileItem> getSelectedFileItems() {
		return selectedFileItems;
	}

	public List<FileTitle> getFileTitlesInCurrentFolder() {
		List<FileTitle> result = new ArrayList<FileTitle>();

		for (FileItem fileItem : fileItems) {
			result.add(fileItem.getFileTitle());
		}

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	public List<FileTitle> getDocumentTitlesInCurrentFolder() {
		List<FileTitle> result = new ArrayList<FileTitle>();

		for (FileItem fileItem : fileItems) {
			if (fileItem instanceof DocumentItem) {
				result.add(fileItem.getFileTitle());
			}
		}

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	public List<FileTitle> getFolderTitlesInCurrentFolder() {
		List<FileTitle> result = new ArrayList<FileTitle>();

		for (FileItem fileItem : fileItems) {
			if (fileItem instanceof FolderItem) {
				result.add(fileItem.getFileTitle());
			}
		}

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	public void initializeStartFolder(final FolderItem startFolder) {
		assert startFolder != null : "Precondition failed: startFolder != null";

		if (startFolder.getId().equals(RoomItem.ROOT_FOLDER_ID)) {
			currentRoom = (RoomItem) startFolder;
			loadFolder(startFolder);
		} else {
			currentFolder = startFolder;
			loadFolder(startFolder);
		}
	}

	public void loadFolder(final FolderItem folderItem, FileItem... fileItemsToSelect) {
		assert folderItem != null : "Precondition failed: folderItem != null";
		assert fileItemsToSelect != null : "Precondition failed: fileItemsToSelect != null";
		currentFolder = folderItem;

		updateFolderContents(folderItem, fileItemsToSelect);
	}

	private void updateFolderContents(final FolderItem folderItem, final FileItem... fileItemsToSelect) {
		assert folderItem != null : "Precondition failed: folderItem != null";
		assert fileItemsToSelect != null : "Precondition failed: fileItemsToSelect != null";
		documentService.getRoomForFileItem(folderItem,
				new SignWritingCallback<RoomItem>(I18N.getErrorOnLoadingDocumentNames()) {

					@Override
					public void onSuccess(RoomItem result) {
						currentRoom = result;
						if (result.isRoomAccessPermitted(localSessionService.getCurrentUser().getUsername())) {
							showLoadingImage();

							documentService.getFolderContentAndPath(localSessionService.getSessionKey(), folderItem,
									new SignWritingCallback<FolderContentAndPath>(
											I18N.getErrorOnLoadingDocumentNames()) {
										@Override
										public void onSuccess(FolderContentAndPath result) {
											openFolder(folderItem, result, fileItemsToSelect);
										}

										public void onFailure(Throwable caught) {
											if (caught instanceof InvalidSessionException) {
												handleInvalidSessionException();
											} else {
												super.onFailure(caught);
											}
										};
									});
						} else {
							accessDenied();
						}
					}
				});
	}

	private void accessDenied() {
		listener.onAccessDenied(I18N.getAccessDeniedOnEnteringRoom());

		// Go to root folder if access to folderItem is denied
		if (!currentRoom.getId().equals(RoomItem.ROOT_FOLDER_ID)) {
			loadRootFolder();
		}
	}

	protected void handleInvalidSessionException() {
		listener.onInvalidSessionExceptionCaught();
	}

	private void loadRootFolder() {
		showLoadingImage();
		documentService.getFolderContentAndPath(localSessionService.getSessionKey(), rootRoomItem,
				new SignWritingCallback<FolderContentAndPath>(I18N.getErrorOnLoadingDocumentNames()) {
					@Override
					public void onSuccess(FolderContentAndPath result) {
						openFolder(rootRoomItem, result);
					}

					@Override
					public void onFailure(Throwable caught) {
						if (caught instanceof InvalidSessionException) {
							handleInvalidSessionException();
						} else {
							super.onFailure(caught);
						}
					}
				});
	}

	public void refresh(FileItem... fileItems) {
		filePathWidget.refreshPathButtons();

		if (getCurrentFolder() != null) {
			loadFolder(getCurrentFolder(), fileItems);
		}
	}

	public void deselectAll() {
		clearSelection();

		listener.onSelectFilesChanged(getSelectedFileItems());
	}

	public boolean isModifySelectedFilesPermitted() {
		boolean result = !isSystemFolderSelected();

		if (result) {
			for (FileItem fileItem : getSelectedFileItems()) {
				result &= getCurrentRoom().isModifyFilePermitted(localSessionService.getCurrentUser().getUsername(),
						fileItem);
			}
		}

		return result;
	}

	public boolean isModifyDocumentPermitted(String documentName) {
		assert documentName != null : "Precondition failed: documentName != null";
		assert containsDocumentWithName(documentName) : "Precondition failed: containsDocumentWithName(documentName)";

		return getCurrentRoom().isModifyFilePermitted(localSessionService.getCurrentUser().getUsername(),
				getDocumentItemWithName(documentName));
	}

	public DocumentItem getDocumentItemWithName(String documentName) {
		assert documentName != null : "Precondition failed: documentName != null";
		assert containsDocumentWithName(documentName) : "Precondition failed: containsDocumentWithName(documentName)";

		DocumentItem result = null;

		for (int i = 0, l = fileItems.size(); i < l && result == null; i++) {
			FileItem fileItem = fileItems.get(i);
			if (fileItem instanceof DocumentItem && fileItem.getFileTitle().getTitleString().equals(documentName)) {
				result = (DocumentItem) fileItem;
			}
		}

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	public boolean isCreateFilePermitted() {
		return !isCurrentFolderInRecycleBin()
				&& currentRoom.isCreateFilePermitted(localSessionService.getCurrentUser());
	}

	public boolean isReadFilePermitted(FileItem fileItem) {
		return currentRoom.isReadFilePermitted(localSessionService.getCurrentUser().getUsername(), fileItem);
	}

	@Override
	public void setHeight(String height) {
		assert height.endsWith("px") : "Precondition failed: height.endsWith(\"px\")";

		Integer newScrollPanelHeight = Integer.valueOf(height.split("px")[0]) - TITLE_BAR_HEIGHT
				- FilePathWidget.FILE_PATH_WIDGET_HEIGHT;
		if (newScrollPanelHeight > 0) {
			fileItemPanel.setHeight(newScrollPanelHeight + "px");
		}

	}

	public void showLoadingImage() {
		clearFileBrowser();

		Image loadingResourceWidget = new Image(Resources.RESOURCE.getLoadingImage());
		SimplePanel wrapperPanel = new SimplePanel(loadingResourceWidget);
		wrapperPanel.setPixelSize(fileItemPanel.getOffsetWidth(), fileItemPanel.getOffsetHeight());
		loadingResourceWidget.getElement().getStyle()
				.setMarginTop((fileItemPanel.getOffsetHeight() / 2) - loadingResourceWidget.getHeight(), Unit.PX);
		wrapperPanel.getElement().setAttribute("align", "center");
		wrapperPanel.getElement().setAttribute("verticalAlign", "center");
		fileItemPanel.addRow(0, 0, wrapperPanel);
	}

	protected void initializeContent(LocalSessionService localSessionService, RoomItem rootRoomItem,
			DocumentServiceAsync documentService, FontSizeService fontSizeService, boolean onlyFolders, int width,
			int height, final LazyLoadingFileBrowserListener listener) {
		assert localSessionService != null : "Precondition failed: localSessionService != null";
		assert listener != null : "Precondition failed: listener != null";
		assert documentService != null : "Precondition failed: documentService != null";
		assert width > (FileItemWidget.LEFT_OFFSET + FileItemWidget.DATE_COLUMN_WIDTH
				+ FileItemWidget.CHANGE_DATE_COLUMN_WIDTH + FileItemWidget.AUTHOR_COLUMN_WIDTH
				+ FileItemWidget.COLOR_COLUMN_WIDTH
				+ FileItemWidget.ICON_COLUMN_WIDTH) : "Precondition failed: width > (FileItemWidget.LEFT_OFFSET + FileItemWidget.DATE_COLUMN_WIDTH\r\n"
						+ "				+ FileItemWidget.CHANGE_DATE_COLUMN_WIDTH + FileItemWidget.AUTHOR_COLUMN_WIDTH\r\n"
						+ "				+ FileItemWidget.COLOR_COLUMN_WIDTH\r\n"
						+ "				+ FileItemWidget.ICON_COLUMN_WIDTH)";
		assert height >= 0 : "Precondition failed: height > 0";
		assert fontSizeService != null : "Precondition failed: fontSizeService != null";

		this.localSessionService = localSessionService;
		this.documentService = documentService;
		this.rootRoomItem = rootRoomItem;
		this.listener = listener;
		this.onlyFolders = onlyFolders;
		this.selectedFileItems = new ArrayList<FileItem>();
		this.unusedFileItemWidgets = new ArrayList<FileItemWidget>();
		this.fileItemToWidget = new HashMap<FileItem, FileItemWidget>();
		this.fileItems = new ArrayList<FileItem>();
		this.width = width;
		this.selectionAnchor = -1;
		this.lastSelectedIndex = -1;
		this.fontSizeService = fontSizeService;

		// make sure currentFolder is set even before server calls
		this.currentFolder = rootRoomItem;
		this.currentRoom = rootRoomItem;

		OrientedFlowPanel mainPanel = new OrientedFlowPanel(Orientation.VERTICAL);
		initWidget(mainPanel);
		filePathWidget = new FilePathWidget(new ArrayList<FolderItem>(), new FilePathWidgetListener() {
			@Override
			public void onClickFolderItem(FolderItem clickedFolderItem) {
				loadFolder(clickedFolderItem);
			}
		});
		mainPanel.add(filePathWidget);

		mainPanel.add(createTitleBar());

		UiUtil.disableTextSelectInternal(mainPanel.getElement());

		fileItemPanel = new LazyLoadList(0, 0, null);
		fileItemPanel.setHeight((height - TITLE_BAR_HEIGHT - FilePathWidget.FILE_PATH_WIDGET_HEIGHT) + "px");
		mainPanel.add(fileItemPanel);

		currentSortCriteria = currentFolder.getCurrentSortCriteria();
		currentSortCriteria.setIsCurrentlyAscending(true);

		setStyleName("fileBrowser");

		mainPanel.addHandler(new MouseDownHandler() {
			@Override
			public void onMouseDown(MouseDownEvent event) {
				// To stop DocumentMananager from deselecting current selection
				event.stopPropagation();
			}
		}, MouseDownEvent.getType());
		mainPanel.sinkEvents(Event.ONMOUSEDOWN);
	}

	private boolean isRootFolder(FolderItem folderItem) {
		assert folderItem != null : "Precondition failed: folderItem != null";

		return folderItem.getId().equals(FolderItem.ROOT_FOLDER_ID);
	}

	private boolean isRecycleBin(FileItem fileItem) {
		assert fileItem != null : "Precondition failed: fileItem != null";

		return fileItem instanceof RecycleBinItem;
	}

	private void clearSelection() {
		for (FileItemWidget fileItemWidget : fileItemToWidget.values()) {
			fileItemWidget.setSelected(false);
		}
		selectedFileItems.clear();
		selectionAnchor = -1;
		lastSelectedIndex = -1;
	}

	private AbsolutePanel createTitleBar() {
		AbsolutePanel titleBar = new AbsolutePanel();
		int nameColumnWidth = width
				- (FileItemWidget.LEFT_OFFSET + FileItemWidget.DATE_COLUMN_WIDTH + FileItemWidget.AUTHOR_COLUMN_WIDTH
						+ FileItemWidget.ICON_COLUMN_WIDTH + FileItemWidget.CHANGE_DATE_COLUMN_WIDTH
						+ FileItemWidget.COLOR_COLUMN_WIDTH + FileItemWidget.RIGHT_OFFSET);

		titleBar.setHeight(FileItemWidget.HEIGHT + "px");

		Label typeLabel = new Label(I18N.getTypeName());
		typeLabel.setStyleName("label");
		typeLabel.addClickHandler(new SortButtonClickHandler(SortCriteria.TYPE));
		titleBar.add(typeLabel, FileItemWidget.LEFT_OFFSET, FileItemWidget.TOP_OFFSET);

		Label fileTitleLabel = new Label(I18N.getName());
		fileTitleLabel.setStyleName("label");
		fileTitleLabel.addClickHandler(new SortButtonClickHandler(SortCriteria.FILE_TITLE));
		titleBar.add(fileTitleLabel, FileItemWidget.LEFT_OFFSET + FileItemWidget.ICON_COLUMN_WIDTH,
				FileItemWidget.TOP_OFFSET);

		Label authorLabel = new Label(I18N.getOwner());
		authorLabel.setStyleName("label");
		authorLabel.addClickHandler(new SortButtonClickHandler(SortCriteria.AUTHOR));
		titleBar.add(authorLabel, FileItemWidget.LEFT_OFFSET + FileItemWidget.ICON_COLUMN_WIDTH + nameColumnWidth,
				FileItemWidget.TOP_OFFSET);

		Label creationDateLabel = new Label(I18N.getCreationDate());
		creationDateLabel.setStyleName("label");
		creationDateLabel.addClickHandler(new SortButtonClickHandler(SortCriteria.CREATION_DATE));
		titleBar.add(creationDateLabel, FileItemWidget.LEFT_OFFSET + FileItemWidget.ICON_COLUMN_WIDTH + nameColumnWidth
				+ FileItemWidget.AUTHOR_COLUMN_WIDTH, FileItemWidget.TOP_OFFSET);

		Label changeDateLabel = new Label(I18N.getModificationDate());
		changeDateLabel.setStyleName("label");
		changeDateLabel.addClickHandler(new SortButtonClickHandler(SortCriteria.CHANGE_DATE));
		titleBar.add(changeDateLabel,
				FileItemWidget.LEFT_OFFSET + FileItemWidget.ICON_COLUMN_WIDTH + nameColumnWidth
						+ FileItemWidget.AUTHOR_COLUMN_WIDTH + FileItemWidget.DATE_COLUMN_WIDTH,
				FileItemWidget.TOP_OFFSET);

		Label colorLabel = new Label(I18N.getColorLabel());
		colorLabel.setStyleName("label");
		colorLabel.addClickHandler(new SortButtonClickHandler(SortCriteria.COLOR));
		titleBar.add(colorLabel,
				FileItemWidget.LEFT_OFFSET + FileItemWidget.ICON_COLUMN_WIDTH + nameColumnWidth
						+ FileItemWidget.AUTHOR_COLUMN_WIDTH + FileItemWidget.DATE_COLUMN_WIDTH
						+ FileItemWidget.DATE_COLUMN_WIDTH,
				FileItemWidget.TOP_OFFSET);

		titleBar.setStyleName("titleBar");

		return titleBar;
	}

	public void openFolder(final FolderItem folderItem, FolderContentAndPath folderContentAndPath,
			FileItem... fileItemsToSelect) {
		assert folderItem != null : "Precondition failed: folderItem != null";
		assert folderContentAndPath != null : "Precondition failed: folderContentAndPath != null";
		assert fileItemsToSelect != null : "Precondition failed: fileItemsToSelect != null";

		List<FolderItem> folderPath = folderContentAndPath.getFolderPath();
		folderPath.add(folderItem);
		filePathWidget.setPath(folderPath);
		filePathWidget.refreshPathButtons();

		List<FileItem> fileItemsInFolder = folderContentAndPath.getFileItemsInFolder();

		if (onlyFolders) {
			this.fileItems = new ArrayList<FileItem>();
			for (FileItem fileItem : fileItemsInFolder) {
				if (fileItem instanceof FolderItem) {
					this.fileItems.add(fileItem);
				}
			}
		} else {
			this.fileItems = fileItemsInFolder;
		}
		currentFolder = folderItem;

		if (folderItem instanceof RoomItem) {
			currentRoom = (RoomItem) folderItem;
		} else {
			for (FolderItem pathElement : folderContentAndPath.getFolderPath()) {
				if (pathElement instanceof RoomItem && !pathElement.getId().equals(RoomItem.ROOT_FOLDER_ID)) {
					currentRoom = (RoomItem) pathElement;
				}
			}
		}
		if (localStorage != null) {
			loadSortCriteriaFromLocalStorage();
		} else {
			currentSortCriteria = folderItem.getCurrentSortCriteria();
		}
		sortAndShowFiles();
		clearSelection();

		selectFileItems(fileItemsToSelect);
		if (fileItemsToSelect.length > 0) {
			fileItemPanel.scrollTo(fileItemsToSelect[0].getId());
		}

		listener.onOpenFolder(folderItem);
	}

	private void loadSortCriteriaFromLocalStorage() {
		String localStorageSortCriteria = localStorage.getItem(currentFolder.getId().toString());
		if (localStorageSortCriteria != null) {
			if (localStorageSortCriteria.endsWith("ASC")) {
				currentSortCriteria = SortCriteria
						.valueOf(localStorageSortCriteria.substring(0, localStorageSortCriteria.length() - 3));
				currentSortCriteria.setIsCurrentlyAscending(true);
			} else {
				currentSortCriteria = SortCriteria.valueOf(localStorageSortCriteria);
				currentSortCriteria.setIsCurrentlyAscending(false);
			}
		} else {
			currentSortCriteria = SortCriteria.TYPE;
		}
	}

	private void showFiles() {
		fileItemPanel.getElement().setAttribute("align", "left");
		clearFileBrowser();

		for (int fileItemIndex = 0; fileItemIndex < this.fileItems.size(); fileItemIndex++) {
			final FileItem fileItem = fileItems.get(fileItemIndex);
			LazyLoadedRow lazyRow = new LazyLoadedRow() {

				@Override
				public void lazyLoad(int rowIndex, Object userObject, LazyLoadedRowContainer container) {
					FileItemWidget fileItemWidget = getUnusedFileItemWidget(fileItem);
					fileItemWidget.setColored(rowIndex % 2 == 0);
					fileItemWidget.setSelected(selectedFileItems.contains(fileItem));
					fileItemToWidget.put(fileItem, fileItemWidget);
					container.onLazyLoadSuccess(rowIndex, 0, fileItemWidget);
				}
			};
			fileItemPanel.addLazyLoadedRow(FileItemWidget.HEIGHT, lazyRow, fileItem.getId());
		}
		fileItemPanel.lazyLoadVisible();
	}

	private FileItemWidget getUnusedFileItemWidget(FileItem fileItem) {
		assert fileItem != null : "Precondition failed: fileItem != null";

		ImageResource fileItemImageResource;
		if (fileItem instanceof PdfFileItem) {
			fileItemImageResource = Resources.RESOURCE.getIconPDF();
		} else if (fileItem instanceof TemplateItem) {
			if (((TemplateItem) fileItem).isValid()) {
				fileItemImageResource = Resources.RESOURCE.getTemplateIcon();
			} else {
				fileItemImageResource = Resources.RESOURCE.getTemplateInvalidIcon();
			}
		} else if (fileItem instanceof DocumentItem) {
			fileItemImageResource = Resources.RESOURCE.getFileIcon();
		} else if (isRecycleBin(fileItem)) {
			// Change icon and name for the recycle bin:
			fileItemImageResource = Resources.RESOURCE.getRecycleBinIcon();
		} else if (fileItem instanceof RoomItem) {
			RoomItem roomItem = (RoomItem) fileItem;
			if (roomItem.isRoomAccessPermitted(localSessionService.getCurrentUser().getUsername())) {
				fileItemImageResource = Resources.RESOURCE.getRoomIcon();
			} else {
				fileItemImageResource = Resources.RESOURCE.getRoomIconLocked();
			}
		} else {
			fileItemImageResource = Resources.RESOURCE.getFolderIcon();
		}

		final Image fileItemIcon = new Image(fileItemImageResource);
		FileItemWidget result;
		if (unusedFileItemWidgets.isEmpty()) {
			result = GWT.create(FileItemWidget.class);
			result.init(fileItem, width, fileItemIcon, fontSizeService);
		} else {
			result = unusedFileItemWidgets.remove(0);
			result.updateWithFileItem(fileItem, fileItemIcon);
		}
		FileItemWidgetListener fileItemWidgetListener = createFileItemWidgetListener(fileItem);
		result.setListener(fileItemWidgetListener);
		result.setWidth("100%");

		return result;
	}

	protected void activateFileItem(final FileItem fileItem) {
		if (fileItem instanceof DocumentItem) {
			if (!isReadFilePermitted(fileItem)) {
				listener.onAccessDenied(I18N.getAccessDeniedOnOpeningDocument());
			} else {
				listener.onActivateDocument((DocumentItem) fileItem, currentFolder, currentRoom);
			}
		} else if (fileItem instanceof FolderItem) {
			loadFolder((FolderItem) fileItem);
		}
	}

	protected FileItemWidgetListener createFileItemWidgetListener(final FileItem fileItem) {
		assert fileItem != null : "Precondition failed: fileItem != null";

		return new FileItemWidgetListener() {

			@Override
			public void onDoubleClick() {
				activateFileItem(fileItem);
			}

			@Override
			public void onClick(boolean isShiftKeyDown, boolean isCtrlKeyDown, boolean isMetaKeyDown) {
				handleFileItemSelected(fileItem, isShiftKeyDown, isCtrlKeyDown, isMetaKeyDown);
			}

			@Override
			public void onKeyDown(boolean isShiftKeyDown) {
				if (lastSelectedIndex + 1 < fileItems.size()) {
					handleFileItemSelected(fileItems.get(lastSelectedIndex + 1), isShiftKeyDown, false, false);
				}
			}

			@Override
			public void onKeyUp(boolean isShiftKeyDown) {
				if (lastSelectedIndex > 0) {
					handleFileItemSelected(fileItems.get(lastSelectedIndex - 1), isShiftKeyDown, false, false);
				}
			}

			@Override
			public void onKeyHome(boolean isShiftKeyDown) {
				handleFileItemSelected(fileItems.get(0), isShiftKeyDown, false, false);
			}

			@Override
			public void onKeyEnd(boolean isShiftKeyDown) {
				handleFileItemSelected(fileItems.get(fileItems.size() - 1), isShiftKeyDown, false, false);
			}

			@Override
			public void onKeyEnter() {
				if (selectedFileItems.size() == 1) {
					activateFileItem(selectedFileItems.get(0));
				}
			}

			@Override
			public void onSelectAll() {
				handleFileItemSelected(fileItems.get(0), false, false, false);
				handleFileItemSelected(fileItems.get(fileItems.size() - 1), true, false, false);
			}

			@Override
			public void onKeyDelete() {
				listener.onDeletePressed();
			}

			@Override
			public void onTouchStart() {
			}

			@Override
			public void onTouchEnd() {
			}
		};
	}

	protected int getLastSelectedIndex() {
		return lastSelectedIndex;
	}

	public List<FileItem> getFileItems() {
		return fileItems;
	}

	protected LazyLoadingFileBrowserListener getFileBrowserListener() {
		return listener;
	}

	private void clearFileBrowser() {
		clearSelection();
		unusedFileItemWidgets.addAll(fileItemToWidget.values());
		fileItemToWidget.clear();
		fileItemPanel.clearRows();
	}

	protected void handleFileItemSelected(final FileItem fileItem, boolean isShiftKeyDown, boolean isCtrlKeyDown,
			boolean isMetaKeyDown) {
		assert fileItem != null : "Precondition failed: fileItem != null";

		if (!(isCtrlKeyDown || isMetaKeyDown || isShiftKeyDown)) {
			clearSelection();
		}

		if (isShiftKeyDown) {
			if (selectionAnchor < 0) {
				selectionAnchor = LazyLoadingFileBrowser.this.fileItems.indexOf(fileItem);
			}
			int oldAnchor = selectionAnchor;
			int from = Math.min(selectionAnchor, LazyLoadingFileBrowser.this.fileItems.indexOf(fileItem));
			int to = Math.max(selectionAnchor, LazyLoadingFileBrowser.this.fileItems.indexOf(fileItem));
			clearSelection();
			selectionAnchor = oldAnchor;
			for (int i = from; i <= to; i++) {
				selectFileItem(LazyLoadingFileBrowser.this.fileItems.get(i));
			}
		} else if (isCtrlKeyDown || isMetaKeyDown) {
			toggleFileItemSelection(fileItem);
		} else {
			selectionAnchor = LazyLoadingFileBrowser.this.fileItems.indexOf(fileItem);
			selectFileItem(fileItem);
		}

		lastSelectedIndex = fileItems.indexOf(fileItem);
	}

	public void selectFileItems(FileItem... fileItems) {
		if (fileItems != null) {
			for (FileItem item : fileItems) {
				selectFileItem(item);
			}
		}

	}

	private void selectFileItem(final FileItem fileItem) {
		assert fileItem != null : "Precondition failed: fileItem != null";

		selectedFileItems.add(fileItem);
		if (fileItemToWidget.containsKey(fileItem)) {
			fileItemToWidget.get(fileItem).setSelected(true);
		}

		listener.onSelectFilesChanged(getSelectedFileItems());
	}

	private void toggleFileItemSelection(final FileItem fileItem) {
		assert fileItem != null : "Precondition failed: fileItem != null";

		if (selectedFileItems.contains(fileItem)) {
			deselectFileItem(fileItem);
		} else {
			selectFileItem(fileItem);
		}
	}

	private void deselectFileItem(FileItem fileItem) {
		assert fileItem != null : "Precondition failed: fileItem != null";

		selectedFileItems.remove(fileItem);
		fileItemToWidget.get(fileItem).setSelected(false);

		listener.onSelectFilesChanged(getSelectedFileItems());
	}

	public void onLogin() {
		if (!currentRoom.isRoomAccessPermitted(localSessionService.getCurrentUser().getUsername())) {
			documentService.getRootRoomItem(new SignWritingCallback<RoomItem>(I18N.getErrorOnLoadingRootFolderItem()) {
				public void onSuccess(RoomItem result) {
					activateFileItem(result);
				}
			});
		} else {
			refresh();
		}
	}

	public interface LazyLoadingFileBrowserListener {
		void onActivateDocument(DocumentItem activatedDocument, FolderItem currentFolder, RoomItem currentRoom);

		void onSelectFilesChanged(List<FileItem> selectedFileItems);

		void onOpenFolder(FolderItem folder);

		void onDeletePressed();

		void onAccessDenied(String message);

		void onInvalidSessionExceptionCaught();
	}

	private final class SortButtonClickHandler implements ClickHandler {
		private final SortCriteria sortCriteria;

		public SortButtonClickHandler(SortCriteria sortCriteria) {
			assert sortCriteria != null : "Precondition failed: sortCriteria != null";

			this.sortCriteria = sortCriteria;
		}

		@Override
		public void onClick(ClickEvent event) {
			if (currentSortCriteria != sortCriteria) {
				currentSortCriteria = sortCriteria;
				currentFolder.setCurrentSortCriteria(currentSortCriteria);
				currentSortCriteria.setIsCurrentlyAscending(true);
				if (Storage.isLocalStorageSupported()) {
					localStorage.setItem(currentFolder.getId().toString(),
							currentSortCriteria.getCriteriaNameForLocalStorage());
				}
			} else {
				currentSortCriteria.setIsCurrentlyAscending(!currentSortCriteria.isCurrentlyAscending());
				if (Storage.isLocalStorageSupported()) {
					localStorage.setItem(currentFolder.getId().toString(),
							currentSortCriteria.getCriteriaNameForLocalStorage());
				}
			}
			sortAndShowFiles();
		}
	}
}
