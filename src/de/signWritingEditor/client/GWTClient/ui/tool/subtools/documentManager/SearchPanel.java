package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentManager;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

import de.signWritingEditor.client.GWTClient.ui.general.lazyload.LazyLoadList;
import de.signWritingEditor.client.GWTClient.ui.general.lazyload.LazyLoadedRow;
import de.signWritingEditor.client.GWTClient.ui.general.lazyload.LazyLoadedRowContainer;
import de.signWritingEditor.client.GWTClient.ui.general.widget.CloseButton;
import de.signWritingEditor.client.GWTClient.ui.general.widget.CloseButton.CloseListener;
import de.signWritingEditor.client.GWTClient.ui.general.widget.OrientedFlowPanel;
import de.signWritingEditor.client.GWTClient.ui.tool.general.imageHandling.Resources;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentManager.SearchItemWidget.SearchItemWidgetListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentManager.SearchWidget.SearchWidgetListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.fileManagement.LazyLoadingFileBrowser;
import de.signWritingEditor.client.service.DocumentServiceAsync;
import de.signWritingEditor.client.service.LocalSessionService;
import de.signWritingEditor.shared.model.domainValue.Orientation;
import de.signWritingEditor.shared.model.material.FileItem;
import de.signWritingEditor.shared.model.material.FolderItem;

public class SearchPanel extends Composite {

	private SearchWidget searchWidget;
	private DocumentServiceAsync documentService;
	private LocalSessionService localSessionService;
	private LazyLoadList lazyLoadList;
	private List<FileItem> resultFileItems;
	private Map<FileItem, SearchItemWidget> fileItemToSearchItemWidget;
	private SearchItemWidgetListener searchItemWidgetListener;
	private SearchItemWidget selectedSearchItemWidget;
	private boolean documentSearchIsActive = false;

	private static final int FILE_BROWSER_SPACING = 200;
	private static final int SEARCH_PANEL_MIN_HEIGHT = 150;
	public static final int WIDTH_OF_SEARCHBOX = 220;
	private Image loadingImage;
	private long currentSearchID;
	private Label noDocumentsFound;
	private LazyLoadingFileBrowser fileBrowser;

	public void init(DocumentServiceAsync documentService, LocalSessionService localSessionService,
			SearchItemWidgetListener searchItemWidgetListener, LazyLoadingFileBrowser fileBrowser) {
		init(documentService, localSessionService, searchItemWidgetListener);
		this.fileBrowser = fileBrowser;
	}

	public void init(DocumentServiceAsync documentService, LocalSessionService localSessionService,
			SearchItemWidgetListener searchItemWidgetListener) {
		assert localSessionService != null : "Precondition failed: localSessionService != null";
		assert documentService != null : "Precondition failed: documentService != null";

		this.documentService = documentService;
		this.localSessionService = localSessionService;
		this.searchItemWidgetListener = searchItemWidgetListener;
	}

	public SearchPanel(CloseListener closeListener) {
		assert closeListener != null : "Precondition failed: closeListener != null";

		resultFileItems = new ArrayList<FileItem>();
		fileItemToSearchItemWidget = new HashMap<FileItem, SearchItemWidget>();

		final OrientedFlowPanel mainPanel = new OrientedFlowPanel(Orientation.VERTICAL);
		initWidget(mainPanel);
		setStyleName("searchPanel");
		int searchPanelHeight = Math.max(SEARCH_PANEL_MIN_HEIGHT, Window.getClientHeight() - FILE_BROWSER_SPACING);
		if (searchPanelHeight > 0) {
			mainPanel.setHeight(searchPanelHeight + "px");
		}

		Window.addResizeHandler(new ResizeHandler() {
			@Override
			public void onResize(ResizeEvent event) {
				int newSearchPanelHeight = Window.getClientHeight() - FILE_BROWSER_SPACING;
				if (newSearchPanelHeight > 0) {
					mainPanel.setHeight(newSearchPanelHeight + "px");
				}
			}
		});

		Image searchIcon = new Image(Resources.RESOURCE.getIconSearchBig());
		searchIcon.setStyleName("searchIcon");
		mainPanel.add(searchIcon);

		FlowPanel floatPanel = new OrientedFlowPanel(Orientation.VERTICAL);
		mainPanel.add(floatPanel);

		Label searchLabel = new Label(I18N.getSearchButtonText());
		searchLabel.setStyleName("searchLabel");
		floatPanel.add(searchLabel);

		CloseButton closeButton = new CloseButton(closeListener);
		mainPanel.add(closeButton);

		searchWidget = new SearchWidget(WIDTH_OF_SEARCHBOX, new SearchWidgetListener() {
			@Override
			public void onHitReturn(String searchString) {
				tryToStartDocumentSearch(searchString);
			}
		});
		mainPanel.add(searchWidget);

		Button searchButton = new Button(I18N.getSearchButtonText(), new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				tryToStartDocumentSearch(searchWidget.getSearchText());
			}
		});
		searchButton.setStyleName("searchButton");
		searchButton.ensureDebugId("searchFileButton");
		mainPanel.add(searchButton);

		Button abortButton = new Button(I18N.getCancel(), new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				abortDocumentSearch();
			}
		});
		abortButton.setStyleName("abortButton");
		mainPanel.add(abortButton);

		loadingImage = new Image(Resources.RESOURCE.getLoadingImage());
		loadingImage.setStyleName("loadingImage");
		mainPanel.add(loadingImage);

		noDocumentsFound = new Label(I18N.getNoDocumentsFound());
		noDocumentsFound.setStyleName("noDocumentsFound");
		mainPanel.add(noDocumentsFound);

		this.lazyLoadList = new LazyLoadList(0, 0, null);
		lazyLoadList.setHeight(70 + "%");
		lazyLoadList.addStyleName("searchList");
		mainPanel.add(lazyLoadList);
		showLoadingImage(false);
		showNoDocumentsFoundLabel(false);
		lazyLoadList.setVisible(false);

		ensureDebugId("searchPanel");
	}

	private void showNoDocumentsFoundLabel(boolean visible) {
		noDocumentsFound.setVisible(visible);
		lazyLoadList.setVisible(!visible);
	}

	private void abortDocumentSearch() {
		documentSearchIsActive = false;
		currentSearchID = -1;
		showLoadingImage(false);
	}

	private void tryToStartDocumentSearch(String searchString) {
		if (!documentSearchIsActive && !searchString.isEmpty()) {
			clearFileBrowser();
			showNoDocumentsFoundLabel(false);
			documentSearchIsActive = true;
			showLoadingImage(true);
			currentSearchID = System.currentTimeMillis();
			loadSearchResults(searchString, currentSearchID);
		}
	}

	private void showLoadingImage(boolean visible) {
		loadingImage.setVisible(visible);
		lazyLoadList.setVisible(!visible);
	}

	private void showFiles() {
		lazyLoadList.getElement().setAttribute("align", "left");

		for (final FileItem fileItem : resultFileItems) {

			LazyLoadedRow lazyRow = new LazyLoadedRow() {

				@Override
				public void lazyLoad(int rowIndex, Object userObject, LazyLoadedRowContainer container) {

					final SearchItemWidget searchItemWidget = GWT.create(SearchItemWidget.class);
					searchItemWidget.init(fileItem, searchItemWidgetListener);
					searchItemWidget.setColored(rowIndex % 2 == 0);
					searchItemWidget.ensureDebugId("searchItemWidget" + rowIndex);
					if (fileItem instanceof FolderItem) {
						searchItemWidget.addStyleName("searchListFolders");
					}

					container.onLazyLoadSuccess(rowIndex, 0, searchItemWidget);
					fileItemToSearchItemWidget.put(fileItem, searchItemWidget);
					documentService.getFilePath(fileItem, new AsyncCallback<List<FolderItem>>() {

						@Override
						public void onFailure(Throwable caught) {
							caught.printStackTrace();

						}

						@Override
						public void onSuccess(List<FolderItem> result) {
							String filePath = "";
							for (FolderItem folderItem : result) {
								filePath += folderItem.getFileTitle().getTitleString() + "/";
							}
							if (fileItem instanceof FolderItem) {
								searchItemWidget.setText(filePath + fileItem.getFileTitle().getDisplayTitleString());
							}
						}
					});
				}
			};

			lazyLoadList.addLazyLoadedRow(SearchItemWidget.HEIGHT, lazyRow);

		}
		lazyLoadList.lazyLoad(0, Integer.MAX_VALUE);
		lazyLoadList.setVisible(true);
	}

	private void clearFileBrowser() {
		lazyLoadList.clearRows();
	}

	private void loadSearchResults(String searchString, final long id) {
		documentService.findSortedDocumentsByTitleLike(localSessionService.getSessionKey(), searchString,
				fileBrowser.getCurrentFolder(), new AsyncCallback<List<FileItem>>() {

					@Override
					public void onSuccess(List<FileItem> result) {
						if (id == currentSearchID) {
							resultFileItems.clear();

							resultFileItems = result;
							showLoadingImage(false);
							showFiles();
							documentSearchIsActive = false;
							if (result.size() == 0) {
								showNoDocumentsFoundLabel(true);
							}
						}
					}

					@Override
					public void onFailure(Throwable caught) {
						caught.printStackTrace();
					}
				});
	}

	public void onLogin() {
		refresh();
	}

	public void refresh() {
		if (localSessionService.getCurrentUser().isUnknown()) {
			resultFileItems.clear();
			showFiles();
			searchWidget.clearSearchBox();
		}
	}

	public SearchItemWidget getSearchItemWidgetForFileItem(FileItem fileItem) {
		assert fileItem != null : "Precondition failed: fileItem != null";
		assert fileItemToSearchItemWidget
				.containsKey(fileItem) : "Precondition failed: documentItemToSearchItemWidget.containsKey(fileItem)";

		return fileItemToSearchItemWidget.get(fileItem);
	}

	public void setSelectedSearchItemWidget(SearchItemWidget selectedSearchItemWidget) {
		this.selectedSearchItemWidget = selectedSearchItemWidget;

	}

	public SearchItemWidget getSelectedSearchItemWidget() {
		return selectedSearchItemWidget;
	}

	public boolean hasSelectedSearchItemWidget() {
		return selectedSearchItemWidget != null;
	}

	public void focusTextbox() {
		searchWidget.focusTextbox();
	}
}
