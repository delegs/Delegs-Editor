
package de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentManager;

import static de.signWritingEditor.client.GWTClient.ui.tool.general.imageHandling.Resources.RESOURCE;
import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

import de.signWritingEditor.client.GWTClient.ui.general.widget.CloseButton.CloseListener;
import de.signWritingEditor.client.GWTClient.ui.general.widget.OrientedFlowPanel;
import de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.MessageDialogBox;
import de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.YesNoDialogBox;
import de.signWritingEditor.client.GWTClient.ui.tool.general.tool.ButtonBar;
import de.signWritingEditor.client.GWTClient.ui.tool.general.tool.SignWritingCallback;
import de.signWritingEditor.client.GWTClient.ui.tool.general.tool.Tool;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentManager.DocumentManagerButtonBar.DocumentManagerButtonBarListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentManager.RoomInfoPanel.UserManagementListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentManager.RoomInfoPanel.UserManagementMethod;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentManager.SearchItemWidget.SearchItemWidgetListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.fileManagement.LazyLoadingFileBrowser;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.fileManagement.LazyLoadingFileBrowser.LazyLoadingFileBrowserListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.fileManagement.NewFolderDialogBox;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.fileManagement.NewRoomDialogBox;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.fileManagement.RenameFileDialogBox;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.fileManagement.SelectFolderDialogBox;
import de.signWritingEditor.client.service.DocumentServiceAsync;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.client.service.InvalidSessionException;
import de.signWritingEditor.client.service.InvalidUsernameException;
import de.signWritingEditor.client.service.LocalSessionService;
import de.signWritingEditor.client.service.RoomnameCollisionException;
import de.signWritingEditor.shared.exceptions.AccessDeniedException;
import de.signWritingEditor.shared.exceptions.MissingAuthorizationException;
import de.signWritingEditor.shared.model.domainValue.FileItemColorLabel;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.FolderContentAndPath;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.Orientation;
import de.signWritingEditor.shared.model.domainValue.PageFormat;
import de.signWritingEditor.shared.model.domainValue.SortCriteria;
import de.signWritingEditor.shared.model.material.DocumentItem;
import de.signWritingEditor.shared.model.material.FileItem;
import de.signWritingEditor.shared.model.material.FolderItem;
import de.signWritingEditor.shared.model.material.RoomItem;
import de.signWritingEditor.shared.model.material.RoomPolicy;
import de.signWritingEditor.shared.model.material.SessionKey;
import de.signWritingEditor.shared.model.material.User;

public class DocumentManager implements Tool {
	private static final int FILE_BROWSER_MIN_HEIGHT = 150;
	private static final int FILE_BROWSER_SPACING = 200;
	private static final int FILE_BROWSER_WIDTH = 700;

	private final DocumentServiceAsync documentService;
	private final LocalSessionService localSessionService;

	private final DocumentManagerListener listener;

	private DocumentManagerButtonBar buttonBar;

	private SimplePanel documentManagerPanel;

	private OrientedFlowPanel contentPanel;
	private LazyLoadingFileBrowser fileBrowser;
	private RoomInfoPanel roomInfoPanel;
	private HomeInfoPanel homeInfoPanel;
	private SearchPanel searchPanel;

	private RoomItem rootRoomItem;
	private FolderItem startFolderItem;
	private FontSizeService fontSizeService;

	public DocumentManager(DocumentServiceAsync documentService, LocalSessionService localSessionService,
			FolderItem startFolderItem, RoomItem rootRoomItem, final DocumentManagerListener listener,
			FontSizeService fontSizeService) {
		assert documentService != null : "Precondition failed: documentService != null";
		assert localSessionService != null : "Precondition failed: localSessionService != null";
		assert rootRoomItem != null : "Precondition failed: rootRoomItem != null";
		assert listener != null : "Precondition failed: listener != null";
		assert startFolderItem != null : "Precondition failed: startFolderItem != null";

		this.documentService = documentService;
		this.localSessionService = localSessionService;

		this.rootRoomItem = rootRoomItem;
		this.listener = listener;
		this.startFolderItem = startFolderItem;
		this.fontSizeService = fontSizeService;

		buttonBar = new DocumentManagerButtonBar(createDocumentManagerButtonBarListener());

		documentManagerPanel = new SimplePanel();
		documentManagerPanel.getElement().setAttribute("align", "center");
		documentManagerPanel.setStyleName("toolPanel");
		documentManagerPanel.addHandler(new MouseDownHandler() {
			@Override
			public void onMouseDown(MouseDownEvent event) {
				fileBrowser.deselectAll();
			}
		}, MouseDownEvent.getType());
		documentManagerPanel.sinkEvents(Event.ONMOUSEDOWN);

		contentPanel = new OrientedFlowPanel(Orientation.HORIZONTAL);
		int contentPanelWidth = PageFormat.A4_PORTRAIT.getPixelWidth();
		contentPanel.setWidth(contentPanelWidth + "px");
		documentManagerPanel.add(contentPanel);

		fileBrowser = GWT.create(LazyLoadingFileBrowser.class);
		int fileBrowserHeight = Math.max(FILE_BROWSER_MIN_HEIGHT, Window.getClientHeight() - FILE_BROWSER_SPACING);

		fileBrowser.initFileBrowserAndDoNotLoadFolder(localSessionService, fontSizeService, documentService,
				startFolderItem, rootRoomItem, false, FILE_BROWSER_WIDTH, fileBrowserHeight,
				new LazyLoadingFileBrowserListener() {
					@Override
					public void onActivateDocument(DocumentItem activatedDocument, FolderItem folderItem,
							RoomItem currentRoom) {
						DocumentManager.this.listener.onOpenDocument(activatedDocument, folderItem, currentRoom);
					}

					@Override
					public void onSelectFilesChanged(List<FileItem> selectedFileItems) {
						handleSelectFiles(selectedFileItems);
					}

					@Override
					public void onOpenFolder(FolderItem folder) {
						handleOpenFolder(folder);
					}

					@Override
					public void onDeletePressed() {
						handleDeleteDocuments();
					}

					@Override
					public void onAccessDenied(String message) {
						handleAccessDenied(message);
					}

					@Override
					public void onInvalidSessionExceptionCaught() {
						listener.onInvalidSessionExceptionCaught();
					}
				});

		fileBrowser.addStyleDependentName("documentManager");
		fileBrowser.setWidth(FILE_BROWSER_WIDTH + "px");

		Window.addResizeHandler(new ResizeHandler() {
			@Override
			public void onResize(ResizeEvent event) {
				int newFileBrowserHeight = Window.getClientHeight() - FILE_BROWSER_SPACING;
				if (newFileBrowserHeight > 0) {
					fileBrowser.setHeight(newFileBrowserHeight + "px");
				}
			}
		});

		contentPanel.add(fileBrowser);

		int spacing = 20;

		roomInfoPanel = new RoomInfoPanel(listener);
		roomInfoPanel.getElement().getStyle().setMarginLeft(spacing, Unit.PX);
		roomInfoPanel.setWidth((contentPanelWidth - FILE_BROWSER_WIDTH - spacing) + "px");

		homeInfoPanel = new HomeInfoPanel();
		homeInfoPanel.getElement().getStyle().setMarginLeft(spacing, Unit.PX);
		homeInfoPanel.setWidth((contentPanelWidth - FILE_BROWSER_WIDTH - spacing) + "px");

		CloseListener closeListener = new CloseListener() {
			@Override
			public void onClose() {
				handleToggleSearchWindow();
			}
		};

		searchPanel = new SearchPanel(closeListener);
		searchPanel.ensureDebugId("searchPanel");
		SearchItemWidgetListener searchItemWidgetListener = new SearchItemWidgetListener() {

			@Override
			public void onDoubleClick(FileItem fileItem) {
				if (!(fileItem instanceof FolderItem)) {
					handleOpenSearchItem(fileItem);
				}
			}

			@Override
			public void onClick(final FileItem fileItem) {

				if (searchPanel.hasSelectedSearchItemWidget()) {
					searchPanel.getSelectedSearchItemWidget().setSelected(false);
				}
				SearchItemWidget selectedSearchItemWidget = searchPanel.getSearchItemWidgetForFileItem(fileItem);
				selectedSearchItemWidget.setSelected(true);
				searchPanel.setSelectedSearchItemWidget(selectedSearchItemWidget);

				if (fileItem instanceof FolderItem) {
					fileBrowser.loadFolder((FolderItem) fileItem);
				} else {

					DocumentManager.this.documentService.getParentFolder(fileItem, new AsyncCallback<FolderItem>() {

						@Override
						public void onSuccess(FolderItem result) {
							fileBrowser.loadFolder(result, fileItem);
						}

						@Override
						public void onFailure(Throwable caught) {
							handleFailure(caught);
						}
					});
				}
			}

		};

		searchPanel.init(documentService, localSessionService, searchItemWidgetListener, fileBrowser);
		searchPanel.getElement().getStyle().setMarginLeft(spacing, Unit.PX);
		searchPanel.setWidth((contentPanelWidth - FILE_BROWSER_WIDTH - spacing) + "px");

		addInfoPanel(homeInfoPanel);
	}

	public void onLogin() {
		fileBrowser.onLogin();
		searchPanel.onLogin();
		updateButtonStates();
	}

	private void handleOpenSearchItem(final FileItem fileItem) {

		DocumentManager.this.documentService.getParentFolder(fileItem, new AsyncCallback<FolderItem>() {

			@Override
			public void onSuccess(FolderItem result) {

				final FolderItem parentFolder = result;
				fileBrowser.loadFolder(parentFolder);
				DocumentManager.this.documentService.getParentRoomForFileItem(fileItem, new AsyncCallback<RoomItem>() {

					@Override
					public void onSuccess(RoomItem parentRoom) {
						listener.onOpenDocument((DocumentItem) fileItem, parentFolder, parentRoom);
					}

					@Override
					public void onFailure(Throwable caught) {
						handleFailure(caught);
					}
				});
			}

			@Override
			public void onFailure(Throwable caught) {
				handleFailure(caught);
			}
		});
	}

	protected void handleFailure(Throwable caught) {
		String message = "Caught Error:" + "<br>" + caught.getMessage();
		new MessageDialogBox("Fehler", message).center();
	}

	public List<FileItem> getSelectedFileItems() {
		return fileBrowser.getSelectedFileItems();
	}

	public List<FileItem> getSortedFileItems() {
		return fileBrowser.getFileItems();
	}

	@Override
	public Widget getPanel() {
		assert documentManagerPanel != null : "Postcondition failed: result != null";
		return documentManagerPanel;
	}

	@Override
	public ButtonBar getButtonBar() {
		return buttonBar;
	}

	@Override
	public int getButtonBarPosition() {
		return 3; // standard position is 3 = after changeTool, undo and redo
	}

	@Override
	public String getTitle() {
		return I18N.getDocumentManager();
	}

	public void showLoadingImage() {
		fileBrowser.showLoadingImage();
	}

	@Override
	public boolean hasUnsavedChanges() {
		// DocumentManager never has unsaved changes
		return false;
	}

	@Override
	public void open() {

		if (fileBrowser.getCurrentFolder() == null) {
			fileBrowser.initializeStartFolder(startFolderItem);
		}

		fileBrowser.refresh();

	}

	public void selectLastClosedDocumentItem(DocumentItem lastOpenedDocument) {
		if (lastOpenedDocument == null) {
			fileBrowser.refresh();
		} else {
			fileBrowser.refresh(lastOpenedDocument);
		}
	}

	public void openFolder(FolderItem folderItem) {
		assert folderItem != null : "Precondition failed: folderItem != null";
		assert fileBrowser.getCurrentFolder() != null : "Precondition failed: fileBrowser.getCurrentFolder() != null";

		if (!fileBrowser.getCurrentFolder().equals(folderItem)) {
			fileBrowser.loadFolder(folderItem);
		}
	}

	public void openRootRoom() {
		openFolder(rootRoomItem);
	}

	public void updateRoomInfoPanel(RoomItem room, UserManagementMethod method) {
		roomInfoPanel.setRoom(room, getCurrentUser());
		roomInfoPanel.clearTextArea(method);
	}

	private User getCurrentUser() {
		return localSessionService.getCurrentUser();
	}

	@Override
	public void close() {
		// Nothing to do here..
	}

	@Override
	public void handleSave(SavingFinishedListener listener) {
		assert listener != null : "Precondition failed: listener != null";

		listener.onSavingFinished();
	}

	@Override
	public Image getIcon() {
		return new Image(RESOURCE.getToolBarIconDocumentManager());
	}

	@Override
	public boolean hasHistorySupport() {
		return false;
	}

	private void handleOpenFolder(FolderItem folderItem) {
		assert folderItem != null : "Precondition failed: folderItem != null";

		updateButtonStates();

		if (!isSearchPanelActive()) {
			updateInfoPanels(folderItem);
		}

		listener.onOpenFolder(folderItem);
	}

	private void updateInfoPanels(FolderItem folderItem) {
		Id folderId = folderItem.getId();
		if (folderId.equals(FolderItem.ROOT_FOLDER_ID)) {
			clearInfoPanels();
			addInfoPanel(homeInfoPanel);
		} else if (!folderId.equals(FolderItem.ROOT_FOLDER_ID)) {
			clearInfoPanels();
			addInfoPanel(roomInfoPanel);
			roomInfoPanel.setRoom(fileBrowser.getCurrentRoom(), getCurrentUser());
		} else {
			roomInfoPanel.setRoom(fileBrowser.getCurrentRoom(), getCurrentUser());
		}
	}

	private void clearInfoPanels() {
		contentPanel.remove(roomInfoPanel);
		roomInfoPanel.clearRoom();
		contentPanel.remove(homeInfoPanel);
	}

	private void handleDeleteDocuments() {
		if (!fileBrowser.isModifySelectedFilesPermitted()) {
			handleAccessDenied(I18N.getAccessDeniedOnDeletingFiles());
		} else {
			List<FileItem> selectedFileItems = getSelectedFileItems();
			int size = selectedFileItems.size();

			if (size > 0) {
				final boolean deletePermanantly = fileBrowser.isCurrentFolderInRecycleBin()
						|| !fileBrowser.getCurrentRoom().hasRecycleBinItem();

				String confirmDeleteDocument;
				if (deletePermanantly) {
					confirmDeleteDocument = I18N.getConfirmDeleteItem();
				} else {
					confirmDeleteDocument = I18N.getConfirmMoveItemToRecycleBin();
				}

				if (size > 1) {
					if (deletePermanantly) {
						confirmDeleteDocument = I18N.getConfirmDeleteItems();
					} else {
						confirmDeleteDocument = I18N.getConfirmMoveItemsToRecycleBin();
					}
					for (FileItem documentItem : selectedFileItems) {
						confirmDeleteDocument += "<br>" + documentItem.getFileTitle().getTitleString();
					}
				} else {
					confirmDeleteDocument += "<br>"
							+ selectedFileItems.iterator().next().getFileTitle().getTitleString();
				}

				String confirmationTitle = I18N.getConfirmDeletionTitle();

				new YesNoDialogBox(confirmationTitle, confirmDeleteDocument) {
					@Override
					public void onYes() {
						handleDeleteConfirmed(deletePermanantly);
					}

					@Override
					public void onNo() {
					}
				}.center();
			}
		}
	}

	public void handleDeleteConfirmed(final boolean deletePermanently) {
		assert deletePermanently || fileBrowser.getCurrentRoom()
				.hasRecycleBinItem() : "Precondition failed: deletePermanently || fileBrowser.getCurrentRoom().hasRecycleBinItem()";

		final Collection<FileItem> selectedFileItems = getSelectedFileItems();
		FileItem[] selectedFileItemsArray = new FileItem[selectedFileItems.size()];
		selectedFileItems.toArray(selectedFileItemsArray);

		documentService.getNonexistentFileItems(selectedFileItemsArray,
				new SignWritingCallback<Set<FileItem>>(I18N.getErrorOnSyncFilesWithServer()) {
					public void onSuccess(Set<FileItem> result) {
						if (!result.isEmpty()) {
							StringBuffer buffer = new StringBuffer();
							for (FileItem fileItem : result) {
								buffer.append(fileItem.getFileTitle().getTitleString() + ", ");
								selectedFileItems.remove(fileItem);
							}
							String names = buffer.substring(0, buffer.length() - 2);
							if (result.size() == 1) {
								new MessageDialogBox(I18N.getErrorOnDeletingDocument(),
										I18N.getTheDocument0CouldNotBeDeleted(names)).center();
							} else {
								new MessageDialogBox(I18N.getErrorOnDeletingDocuments(),
										I18N.getTheDocuments0CouldNotBeDeleted(names)).center();
							}
						}

						final FileItem[] existentFileItemsArray = new FileItem[selectedFileItems.size()];
						selectedFileItems.toArray(existentFileItemsArray);

						if (deletePermanently) {
							documentService.deleteFiles(getCurrentUserSessionKey(), existentFileItemsArray,
									new SignWritingCallback<Void>(I18N.getErrorOnDeletingDocuments()) {
										public void onSuccess(Void result) {
											fileBrowser.refresh();
										}

										@Override
										public void onFailure(Throwable caught) {
											if (caught instanceof InvalidSessionException) {
												handleInvalidSession();
											} else if (caught instanceof AccessDeniedException) {
												handleAccessDenied(I18N.getAccessDeniedOnDeletingFiles());
											} else {
												super.onFailure(caught);
											}
										}
									});
						} else {
							for (FileItem fileItem : existentFileItemsArray) {
								fileItem.setChangeDate(new Date());
							}
							documentService.moveFiles(getCurrentUserSessionKey(),
									fileBrowser.getCurrentRoom().getRecycleBinItem(), existentFileItemsArray,
									new SignWritingCallback<Void>(I18N.getErrorOnDeletingDocuments()) {
										public void onSuccess(Void result) {
											fileBrowser.refresh();
										}

										public void onFailure(Throwable caught) {
											if (caught instanceof InvalidSessionException) {
												handleInvalidSession();
											} else if (caught instanceof AccessDeniedException) {
												handleAccessDenied(I18N.getAccessDeniedOnDeletingFiles());
											} else {
												super.onFailure(caught);
											}
										}
									});
						}

					}
				});
	}

	private void handleOpenFile() {
		FileItem selectedFileItem = getSelectedFileItems().get(getSelectedFileItems().size() - 1);
		handleOpenFileItem(selectedFileItem);
	}

	private void handleOpenFileItem(FileItem fileItem) {
		if (fileItem instanceof DocumentItem) {
			if (!fileBrowser.isReadFilePermitted(fileItem)) {
				handleAccessDenied(I18N.getAccessDeniedOnOpeningDocument());
			}
			listener.onOpenDocument((DocumentItem) fileItem, fileBrowser.getCurrentFolder(),
					fileBrowser.getCurrentRoom());

		} else if (fileItem instanceof FolderItem) {
			FolderItem folderItem = (FolderItem) fileItem;
			fileBrowser.loadFolder(folderItem);
		}
	}

	private void handleCreateNewRoom() {
		NewRoomDialogBox newRoomDialogBox = new NewRoomDialogBox(getCurrentUser().getUsername(),
				getCurrentUser().isAdmin()) {
			@Override
			protected void handleNewRoom(FileTitle roomName, List<String> roomOwners, List<String> roomUsers,
					RoomPolicy roomPolicy, boolean isHidden, String roomDescription) {
				documentService.createNewRoom(getCurrentUserSessionKey(), roomName, roomOwners, roomUsers, roomPolicy,
						isHidden, roomDescription, new SignWritingCallback<Void>(I18N.getErrorOnCreatingNewRoom()) {
							@Override
							public void onSuccess(Void result) {
								fileBrowser.refresh();
							}

							@Override
							public void onFailure(Throwable caught) {
								if (caught instanceof InvalidSessionException) {
									handleInvalidSession();
								} else if (caught instanceof MissingAuthorizationException) {
									listener.onMissingAuthorizationExceptionCaught();
								}
							}
						});
			}

			@Override
			protected void checkForRoomnameDuplications(final String roomName, final RoomPolicy roomPolicy,
					final List<String> roomOwnersNames, final List<String> roomUserNames, final boolean isHidden,
					final String roomDescription) {
				documentService.verifyRoomParameters(getCurrentUserSessionKey(), roomName, roomOwnersNames,
						roomUserNames, new SignWritingCallback<Void>(I18N.getErrorOnCreatingNewRoom()) {

							@Override
							public void onFailure(Throwable caught) {
								if (caught instanceof InvalidSessionException) {
									handleInvalidSession();
								} else if (caught instanceof RoomnameCollisionException) {
									handleDuplicateRoomname(roomName, roomPolicy, roomOwnersNames, roomUserNames,
											isHidden, roomDescription);
								} else if (caught instanceof InvalidUsernameException) {
									Window.alert(caught.getMessage());
								} else {
									super.onFailure(caught);
								}
							}

							@Override
							public void onSuccess(Void result) {
								createNewRoom(roomName, roomPolicy, roomOwnersNames, roomUserNames, isHidden,
										roomDescription);
							}
						});

			}

		};
		newRoomDialogBox.center();
	}

	private void handleCreateNewFolder() {
		NewFolderDialogBox newFolderDialogBox = new NewFolderDialogBox(fileBrowser.getFolderTitlesInCurrentFolder()) {
			@Override
			protected void handleCreateFolder(FileTitle fileTitle) {
				documentService.createNewFolder(getCurrentUserSessionKey(), fileTitle, fileBrowser.getCurrentFolder(),
						new SignWritingCallback<Void>(I18N.getErrorOnCreatingNewFolder()) {
							public void onSuccess(Void result) {
								fileBrowser.refresh();
							};

							@Override
							public void onFailure(Throwable caught) {
								if (caught instanceof AccessDeniedException) {
									handleAccessDenied(I18N.getAccessDeniedOnCreatingNewFolder());
								} else {
									super.onFailure(caught);
								}
							}
						});
			}
		};
		newFolderDialogBox.center();
	}

	private void handleSelectFiles(List<FileItem> fileItems) {
		assert fileItems != null : "Precondition failed: fileItems != null";

		updateButtonStates();
	}

	private void handleMoveFiles() {
		assert fileBrowser.hasSelectedFileItems() : "Precondition failed: fileBrowser.hasSelectedFileItems()";

		final Collection<FileItem> selectedFileItems = getSelectedFileItems();

		SelectFolderDialogBox selectFolderDialogBox = new SelectFolderDialogBox(localSessionService, fontSizeService,
				documentService, fileBrowser.getCurrentFolder(), rootRoomItem) {
			@Override
			protected void onFolderSelected(final FolderItem targetFolderItem) {
				if (isMoveAllowed(selectedFileItems, targetFolderItem)) {
					handleMoveTargetSelected(selectedFileItems, targetFolderItem);
					hide();
				} else {
					new MessageDialogBox(I18N.getNote(), I18N.getCantMoveFolderIntoItself()).center();
				}
			}

			@Override
			protected void onInvalidSessionExceptionCaught() {
				handleInvalidSession();
			}
		};
		selectFolderDialogBox.center();
	}

	private void handleCopyFiles() {
		assert fileBrowser.hasSelectedFileItems() : "Precondition failed: fileBrowser.hasSelectedFileItems()";

		final Collection<FileItem> selectedFileItems = getSelectedFileItems();

		SelectFolderDialogBox selectFolderDialogBox = new SelectFolderDialogBox(localSessionService, fontSizeService,
				documentService, fileBrowser.getCurrentFolder(), rootRoomItem, I18N.getInsert()) {

			@Override
			protected void onFolderSelected(FolderItem targetFolderItem) {
				handleCopyTargetSelected(selectedFileItems, targetFolderItem);
				hide();
			}

			@Override
			protected void onInvalidSessionExceptionCaught() {
				handleInvalidSession();
			}

		};
		selectFolderDialogBox.center();
	}

	private void handleSetFileItemColorLabel(FileItemColorLabel newColorLabel) {
		assert newColorLabel != null : "Precondition failed: newColorLabel != null";
		assert fileBrowser
				.areOnlyDocumentsOrFoldersSelected() : "Precondition failed: fileBrowser.areOnlyDocumentsOrFoldersSelected()";

		List<FileItem> selectedFileItems = getSelectedFileItems();

		FileItem[] fileItems = selectedFileItems.toArray(new FileItem[selectedFileItems.size()]);

		documentService.setColorLabel(newColorLabel, fileItems,
				new SignWritingCallback<Void>(I18N.getErrorOnChangingColorLabels()) {
					@Override
					public void onSuccess(Void result) {
						fileBrowser.refresh(fileItems);
					}
				});
	}

	private void handleMoveTargetSelected(final Collection<FileItem> selectedFileItems,
			final FolderItem targetFolderItem) {
		assert selectedFileItems != null : "Precondition failed: selectedFileItems != null";
		assert targetFolderItem != null : "Precondition failed: targetFolderItem != null";

		if (!fileBrowser.getCurrentFolder().equals(targetFolderItem)) {
			documentService.getFolderContentAndPath(getCurrentUserSessionKey(), targetFolderItem,
					new SignWritingCallback<FolderContentAndPath>(I18N.getErrorOnLoadingDocumentNames()) {
						@Override
						public void onSuccess(FolderContentAndPath result) {
							for (FileItem fileItem : selectedFileItems) {
								FileTitle uniqueFileTitle = getUniqueFileTitle(fileItem.getFileTitle(),
										result.getFileItemsInFolder());
								if (!uniqueFileTitle.equals(fileItem.getFileTitle())) {
									documentService.renameFile(getCurrentUserSessionKey(), fileItem, uniqueFileTitle,
											new SignWritingCallback<Void>(I18N.getErrorOnRenamingFile()) {
												@Override
												public void onFailure(Throwable caught) {
													if (caught instanceof InvalidSessionException) {
														handleInvalidSession();
													} else if (caught instanceof AccessDeniedException) {
														handleAccessDenied(I18N.getAccessDeniedOnRenamingFile());
													} else {
														super.onFailure(caught);
													}
												}
											});
								}
							}

							FileItem[] selectedFileItemsArray = new FileItem[selectedFileItems.size()];
							selectedFileItems.toArray(selectedFileItemsArray);
							documentService.moveFiles(getCurrentUserSessionKey(), targetFolderItem,
									selectedFileItemsArray, new SignWritingCallback<Void>(I18N.getErrorOnMoveFiles()) {

										@Override
										public void onSuccess(Void result) {
											DocumentManager.this.fileBrowser.refresh();
										}

										@Override
										public void onFailure(Throwable caught) {
											if (caught instanceof InvalidSessionException) {
												handleInvalidSession();
											} else if (caught instanceof AccessDeniedException) {
												handleAccessDenied(I18N.getAccessDeniedOnMovingFiles());
											} else if (caught instanceof RuntimeException) {
												handleCannotMoveFolderIntoItself(I18N.getCantMoveFolderIntoItself());
											} else {
												super.onFailure(caught);
											}
										}
									});

							super.onSuccess(result);
						}

						@Override
						public void onFailure(Throwable caught) {
							if (caught instanceof InvalidSessionException) {
								handleInvalidSession();
							} else if (caught instanceof AccessDeniedException) {
								handleAccessDenied(I18N.getAccessDeniedOnOpeningFolder());
							} else {
								super.onFailure(caught);
							}
						}

					});

		}
	}

	private void handleRenameFile() {
		assert fileBrowser.hasSelectedFileItems() : "Precondition failed: fileBrowser.hasSelectedFileItems()";

		final Collection<FileItem> selectedFileItems = getSelectedFileItems();
		final FileItem fileItem = selectedFileItems.iterator().next();

		List<FileTitle> takenFileTitlesInCurrentFolder = (fileItem instanceof DocumentItem)
				? fileBrowser.getDocumentTitlesInCurrentFolder()
				: fileBrowser.getFolderTitlesInCurrentFolder();

		RenameFileDialogBox newRenameFileDialogBox = new RenameFileDialogBox(fileItem, takenFileTitlesInCurrentFolder) {
			@Override
			protected void handleRenameFile(FileTitle fileTitle) {
				documentService.renameFile(getCurrentUserSessionKey(), fileItem, fileTitle,
						new SignWritingCallback<Void>(I18N.getErrorOnRenamingFile()) {
							public void onSuccess(Void result) {
								fileBrowser.refresh();
							};

							@Override
							public void onFailure(Throwable caught) {
								if (caught instanceof InvalidSessionException) {
									handleInvalidSession();
								} else if (caught instanceof AccessDeniedException) {
									handleAccessDenied(I18N.getAccessDeniedOnRenamingFile());
								} else {
									super.onFailure(caught);
								}
							}
						});
			}
		};

		newRenameFileDialogBox.center();
	}

	private void handleInvalidSession() {
		new MessageDialogBox(I18N.getInvalidSessionTitle(), I18N.getInvalidSessionLoginMessage()).center();
		listener.onInvalidSessionExceptionCaught();
	}

	private void handleAccessDenied(String message) {
		new MessageDialogBox(I18N.getAccessDeniedTitle(), message).center();
	}

	private void handleCannotMoveFolderIntoItself(String message) {
		new MessageDialogBox(I18N.getOperationInvalid(), message).center();
	}

	private void handleCopyTargetSelected(final Collection<FileItem> selectedFileItems,
			final FolderItem targetFolderItem) {
		assert selectedFileItems != null : "Precondition failed: selectedFileItems != null";
		assert targetFolderItem != null : "Precondition failed: targetFolderItem != null";

		documentService.getFolderContentAndPath(getCurrentUserSessionKey(), targetFolderItem,
				new SignWritingCallback<FolderContentAndPath>(I18N.getErrorOnLoadingDocumentNames()) {
					@Override
					public void onSuccess(FolderContentAndPath result) {

						final List<FileItem> newFileItems = new ArrayList<FileItem>();

						for (FileItem fileItem : selectedFileItems) {
							FileTitle uniqueFileTitle = getUniqueFileTitle(fileItem.getFileTitle(),
									result.getFileItemsInFolder());
							if (fileItem instanceof DocumentItem) {
								newFileItems.add(new DocumentItem(fileItem.getId(), fileItem.getOwner(),
										uniqueFileTitle, fileItem.getCreationDate(), fileItem.getChangeDate(),
										fileItem.getColorLabel()));
							} else if (fileItem instanceof FolderItem) {
								newFileItems.add(new FolderItem(fileItem.getId(), fileItem.getOwner(), uniqueFileTitle,
										fileItem.getCreationDate(), fileItem.getChangeDate(), fileItem.getColorLabel(),
										SortCriteria.TYPE));
							}
						}

						FileItem[] selectedFileItemsArray = new FileItem[newFileItems.size()];
						newFileItems.toArray(selectedFileItemsArray);

						documentService.copyFiles(getCurrentUserSessionKey(), targetFolderItem, selectedFileItemsArray,
								new SignWritingCallback<FileItem[]>(I18N.getErrorOnMoveFiles()) {

									@Override
									public void onSuccess(FileItem[] copiedFiles) {
										fileBrowser.loadFolder(targetFolderItem, copiedFiles);
									}

									@Override
									public void onFailure(Throwable caught) {
										if (caught instanceof InvalidSessionException) {
											handleInvalidSession();
										} else if (caught instanceof AccessDeniedException) {
											handleAccessDenied(I18N.getAccessDeniedOnCopyingFiles());
										} else {
											super.onFailure(caught);
										}
									}
								});

						super.onSuccess(result);

					}

					@Override
					public void onFailure(Throwable caught) {
						if (caught instanceof InvalidSessionException) {
							handleInvalidSession();
						} else if (caught instanceof AccessDeniedException) {
							handleAccessDenied(I18N.getAccessDeniedOnOpeningFolder());
						} else {
							super.onFailure(caught);
						}
					}

				});
	}

	private void handleToggleSearchWindow() {
		if (isSearchPanelActive()) {
			contentPanel.remove(searchPanel);
			buttonBar.setSearchButtonPressed(false);
			updateInfoPanels(getCurrentFolder());
		} else {
			clearInfoPanels();
			buttonBar.setSearchButtonPressed(true);
			addInfoPanel(searchPanel);
			searchPanel.focusTextbox();

		}
	}

	private boolean isSearchPanelActive() {
		return contentPanel.getWidgetIndex(searchPanel) > -1;
	}

	private boolean isMoveAllowed(final Collection<FileItem> fileItems, final FolderItem targetFolderItem) {
		boolean moveAllowed = noRoomItemsSelected(fileItems);
		for (FileItem fileItem : fileItems) {
			if (fileItem instanceof FolderItem) {
				if (((FolderItem) fileItem).equals(targetFolderItem)) {
					moveAllowed = false;
				}
			}
		}
		return moveAllowed;
	}

	private boolean noRoomItemsSelected(final Collection<FileItem> fileItems) {
		boolean moveAllowed = true;
		for (FileItem fileItem : fileItems) {
			if (fileItem instanceof RoomItem) {
				moveAllowed = false;
			}
		}
		return moveAllowed;
	}

	private void addInfoPanel(Widget infoPanel) {
		assert infoPanel != null : "Precondition failed: infoPanel != null";
		assert contentPanel
				.getWidgetIndex(infoPanel) == -1 : "Precondition failed: contentPanel.getWidgetIndex(infoPanel) == -1";

		contentPanel.add(infoPanel);
		// OrientedFlowPanel automatically sets display to Inline-Block, which
		// is not displayed as desired in FF 6.0.2
		infoPanel.getElement().getStyle().setDisplay(Display.INLINE);
	}

	private void updateButtonStates() {
		List<FileItem> selectedFileItems = getSelectedFileItems();

		boolean anyFilesSelected = selectedFileItems.size() > 0;
		boolean isSingleFileSelected = selectedFileItems.size() == 1;
		boolean openFilePermitted = anyFilesSelected;
		boolean modifyFilePermitted = anyFilesSelected && fileBrowser.isModifySelectedFilesPermitted();
		boolean copyFilePermitted = anyFilesSelected;

		for (FileItem fileItem : selectedFileItems) {
			copyFilePermitted = copyFilePermitted && fileBrowser.isReadFilePermitted(fileItem);
			// Performance
			if (!copyFilePermitted) {
				break;
			}
		}

		if (isSingleFileSelected) {
			FileItem firstselectedFileItem = selectedFileItems.get(0);

			if (firstselectedFileItem instanceof DocumentItem) {
				openFilePermitted = (fileBrowser.getCurrentRoom().isReadFilePermitted(getCurrentUser().getUsername(),
						(DocumentItem) firstselectedFileItem));
			} else if (firstselectedFileItem instanceof RoomItem) {
				openFilePermitted = ((RoomItem) firstselectedFileItem)
						.isRoomAccessPermitted(getCurrentUser().getUsername());
			}
		}

		buttonBar.enableDeleteButton(modifyFilePermitted);
		buttonBar.enableMoveButton(modifyFilePermitted && noRoomItemsSelected(selectedFileItems));
		buttonBar.enableCopyButton(copyFilePermitted && noRoomItemsSelected(selectedFileItems));
		buttonBar.enableRenameButton(modifyFilePermitted && isSingleFileSelected);
		buttonBar.enableOpenButton(openFilePermitted);
		buttonBar.enableNewFolderButton(fileBrowser.isCreateFilePermitted());
		buttonBar.enableColorLableButton(fileBrowser.areOnlyDocumentsOrFoldersSelected());
		buttonBar.setNewRoomButtonVisible(!getCurrentUser().isUnknown());
		buttonBar.enableNewRoomButton(fileBrowser.isInRootRoom());
	}

	private SessionKey getCurrentUserSessionKey() {
		return localSessionService.getSessionKey();
	}

	private FileTitle getUniqueFileTitle(FileTitle fileTitle, List<FileItem> fileItems) {
		assert fileTitle != null : "Precondition failed: fileTitle != null";
		assert fileItems != null : "Precondition failed: fileItems != null";

		FileTitle result = fileTitle;

		boolean isUnique = true;
		for (FileItem fileItem : fileItems) {
			if (fileTitle.equals(fileItem.getFileTitle())) {
				isUnique = false;
				break;
			}
		}
		if (!isUnique) {
			result = getUniqueFileTitle(fileTitle, fileItems, 0);
		}

		return result;
	}

	private FileTitle getUniqueFileTitle(FileTitle fileTitle, List<FileItem> fileItems, int count) {
		assert fileTitle != null : "Precondition failed: fileTitle != null";
		assert fileItems != null : "Precondition failed: fileItems != null";
		assert count >= 0 : "Precondition failed: count >= 0";

		FileTitle result = fileTitle;

		for (FileItem fileItem : fileItems) {
			if (count == 0 && (fileTitle.equals(fileItem.getFileTitle()))) {
				result = getUniqueFileTitle(fileTitle, fileItems, count + 1);
				break;
			} else if ((fileTitle.getTitleString() + " (" + count + ")")
					.equals(fileItem.getFileTitle().getTitleString())) {
				result = getUniqueFileTitle(fileTitle, fileItems, count + 1);
				break;
			} else {
				result = new FileTitle(fileTitle.getTitleString() + " (" + count + ")");
			}
		}
		return result;
	}

	private DocumentManagerButtonBarListener createDocumentManagerButtonBarListener() {
		DocumentManagerButtonBarListener result = new DocumentManagerButtonBarListener() {
			@Override
			public void onOpen() {
				handleOpenFile();
			}

			@Override
			public void onDeleteFile() {
				handleDeleteDocuments();
			}

			@Override
			public void onCreateNewFolder() {
				handleCreateNewFolder();
			}

			@Override
			public void onMoveFiles() {
				handleMoveFiles();
			}

			@Override
			public void onCopyFiles() {
				handleCopyFiles();
			}

			@Override
			public void onRenameFile() {
				handleRenameFile();
			}

			@Override
			public void onOpenNewDocument() {
				listener.onOpenNewDocument();
			}

			@Override
			public void onCreateNewRoom() {
				handleCreateNewRoom();
			}

			@Override
			public void onSetFileItemColorLabel(FileItemColorLabel newColorLabel) {
				handleSetFileItemColorLabel(newColorLabel);
			}

			@Override
			public void onOpenSearchWindow() {
				handleToggleSearchWindow();
			}

		};

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	// For tests only
	@Deprecated
	protected LazyLoadingFileBrowser getFileBrowser() {
		return fileBrowser;
	}

	public RoomItem getCurrentRoom() {
		return fileBrowser.getCurrentRoom();
	}

	public FolderItem getCurrentFolder() {
		return fileBrowser.getCurrentFolder();
	}

	public interface DocumentManagerListener extends UserManagementListener {
		void onOpenDocument(DocumentItem documentItem, FolderItem folderContainingDocument,
				RoomItem roomContainingDocument);

		void onOpenFolder(FolderItem folder);

		void onOpenNewDocument();

		void onInvalidSessionExceptionCaught();

		void onMissingAuthorizationExceptionCaught();
	}

	@Override
	public void logout() {
		fileBrowser.refresh();
		searchPanel.refresh();
	}

	@Override
	public void discardChanges() {
		// No changes to discard
	}
}
