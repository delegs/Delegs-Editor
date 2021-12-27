package de.signWritingEditor.client.service;

import java.util.Arrays;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.rpc.AsyncCallback;

import de.signWritingEditor.client.GWTClient.ui.tool.general.tool.SignWritingCallback;
import de.signWritingEditor.shared.exceptions.AccessDeniedException;
import de.signWritingEditor.shared.exceptions.DirectoryNotFoundException;
import de.signWritingEditor.shared.exceptions.DocumentNotFoundException;
import de.signWritingEditor.shared.exceptions.RecursiveDirectoryException;
import de.signWritingEditor.shared.i18n.I18NAccess;
import de.signWritingEditor.shared.infrastructure.URLConverter;
import de.signWritingEditor.shared.model.material.DocumentItem;
import de.signWritingEditor.shared.model.material.FileItem;
import de.signWritingEditor.shared.model.material.FolderItem;
import de.signWritingEditor.shared.model.material.RoomItem;
import de.signWritingEditor.shared.model.material.SessionKey;

public class BrowserHistoryServiceImpl implements BrowserHistoryService, ValueChangeHandler<String> {
	private static final String FOLDER_MARKER = "/";
	private static final String URL_START_MARKER = "#";
	private static final String ID_MARKER = "&";
	private DocumentServiceAsync documentService;
	private LocalSessionService localSessionService;
	private BrowserHistoryListener listener;
	private URLConverter urlConverter;

	public BrowserHistoryServiceImpl(LocalSessionService localSessionService, DocumentServiceAsync documentService,
			URLConverter urlConverter) {
		this.localSessionService = localSessionService;
		this.documentService = documentService;
		this.urlConverter = urlConverter;
	}

	// initialize handler registration separately for testing purpose
	public void init() {
		History.addValueChangeHandler(this);
	}

	@Override
	public void setBrowserHistoryListener(BrowserHistoryListener listener) {
		this.listener = listener;
	}

	private BrowserHistoryListener getBrowserHistoryListener() {
		assert listener != null : "Precondition failed: listener != null";
		return listener;
	}

	@Override
	public void createHistoryToken(final FileItem fileItem) {
		documentService.getFilePath(fileItem,
				new SignWritingCallback<List<FolderItem>>(I18NAccess.I18N.getFailMessageBrowserHistory()) {

					@Override
					public void onSuccess(List<FolderItem> result) {
						String token = "";
						if (fileItem instanceof RoomItem && result.size() != 0) {
							token += fileItem.getId() + ID_MARKER;
						} else if (result.size() > 1 && result.get(1) instanceof RoomItem) {
							token += result.get(1).getId() + ID_MARKER;
						}

						for (int i = 1; i < result.size(); i++) {
							token += result.get(i).getFileTitle().getTitleString() + FOLDER_MARKER;
						}

						if (fileItem instanceof FolderItem && result.size() != 0) {
							token += fileItem.getFileTitle().getTitleString() + FOLDER_MARKER;
						}
						if (fileItem instanceof DocumentItem) {
							token += fileItem.getFileTitle().getTitleString();
						}
						// Do not fire ValueChangeEvent
						History.newItem(token, false);
					}

				});
	}

	@Override
	public void navigateToUrl(String url) {
		if (url != null) {
			String[] pathSegments = url.split(URL_START_MARKER);
			navigateToUrl(pathSegments);
		}
	}

	public void navigateToUrl(String[] pathSegments) {
		if (pathSegments.length > 1) {
			String pathSegment = pathSegments[1];
			final String unescapedPathSegment = urlConverter.decode(pathSegment);

			String[] fileAndFolderSegments = unescapedPathSegment.split(FOLDER_MARKER);
			String[] roomIdAndTitleSegment = fileAndFolderSegments[0].split(ID_MARKER);

			final String[] roomAndFolderSegments = new String[fileAndFolderSegments.length];
			for (int i = 0; i < roomAndFolderSegments.length; i++) {
				if (i == 0) {
					roomAndFolderSegments[i] = roomIdAndTitleSegment[0];
				} else {
					roomAndFolderSegments[i] = fileAndFolderSegments[i];
				}
			}

			if (localSessionService.hasStoredUserSession()) {
				localSessionService.restoreUserSession(new AsyncCallback<Boolean>() {

					@Override
					public void onFailure(Throwable caught) {
						System.out.println("");
					}

					@Override
					public void onSuccess(Boolean result) {
						navigateToDestination(unescapedPathSegment, roomAndFolderSegments);
					}
				});
			} else {
				navigateToDestination(unescapedPathSegment, roomAndFolderSegments);
			}
		} else {
			getBrowserHistoryListener().onDefaultFileItemRequested();
		}
	}

	private void navigateToDestination(final String unescapedPathSegment, final String[] fileAndFolderSegments) {
		SessionKey sessionKey = localSessionService.getSessionKey();
		if (unescapedPathSegment.endsWith(FOLDER_MARKER)) {
			navigateToFolder(sessionKey, fileAndFolderSegments);
		} else {
			analyzeDocument(sessionKey, fileAndFolderSegments);
		}
	}

	private void navigateToFolder(final SessionKey sessionKey, final String[] folderNames) {
		documentService.getFolderItem(sessionKey, folderNames, new AsyncCallback<FolderItem>() {

			@Override
			public void onSuccess(FolderItem result) {
				getBrowserHistoryListener().onFolderItemRequested(result);
			}

			@Override
			public void onFailure(Throwable caught) {
				if (caught instanceof AccessDeniedException) {
					getBrowserHistoryListener().onFileItemAccessDenied();
				} else if (caught instanceof InvalidSessionException) {
					getBrowserHistoryListener().onSessionInvalid();
				} else if (caught instanceof DirectoryNotFoundException) {
					getBrowserHistoryListener().onDefaultFileItemRequested();
					Window.alert(I18NAccess.I18N.getFailMessageFolderNotFound());
				} else if (caught instanceof RecursiveDirectoryException) {
					getBrowserHistoryListener().onDefaultFileItemRequested();
					Window.alert(I18NAccess.I18N.getErrorOnLoadingDocument());
				}
			}
		});
	}

	private void analyzeDocument(final SessionKey sessionKey, final String[] folderNames) {
		final String[] folders = Arrays.copyOfRange(folderNames, 0, folderNames.length - 1);
		String fileName = folderNames[folderNames.length - 1];

		documentService.getDocumentItem(sessionKey, fileName, folders, new AsyncCallback<DocumentItem>() {

			@Override
			public void onSuccess(final DocumentItem documentItem) {
				assert documentItem != null : "Precondition failed: documentItem != null";
				documentService.getFolderItem(sessionKey, folders, new AsyncCallback<FolderItem>() {

					@Override
					public void onSuccess(FolderItem folderItem) {
						getBrowserHistoryListener().onDocumentItemRequested(folderItem, documentItem);
					}

					@Override
					public void onFailure(Throwable caught) {
						if (caught instanceof AccessDeniedException) {
							getBrowserHistoryListener().onFileItemAccessDenied();
						}
						GWT.log("Unable to get folder item.", caught);
					}
				});
			}

			@Override
			public void onFailure(Throwable caught) {
				if (caught instanceof AccessDeniedException) {
					getBrowserHistoryListener().onFileItemAccessDenied();
				} else if (caught instanceof DirectoryNotFoundException
						|| caught instanceof DocumentNotFoundException) {
					getBrowserHistoryListener().onDefaultFileItemRequested();
					Window.alert(I18NAccess.I18N.getFailMessageDocumentNotFound());
				} else if (caught instanceof RecursiveDirectoryException) {
					getBrowserHistoryListener().onDefaultFileItemRequested();
					Window.alert(I18NAccess.I18N.getErrorOnLoadingDocument());
				}
			}
		});

	}

	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		handleHistoryChanged(event.getValue());
	}

	private void handleHistoryChanged(String value) {
		navigateToUrl(URL_START_MARKER + value);
	}

	@Override
	public void navigateToPreviousUrl() {
		History.back();
	}

	@Override
	public void openEmptyDocument() {
		getBrowserHistoryListener().onDefaultFileItemRequested();
	}

	@Override
	public boolean isInPublicFolder() {
		String location = Location.getHref();
		int beginIndex = location.indexOf('#');
		int endIndex = -2;
		if (beginIndex >= 0) {
			endIndex = location.indexOf('/', beginIndex);
		}
		return !(endIndex > beginIndex && !location.substring(beginIndex, endIndex).endsWith("ffentlich"));
	}

	@Override
	public boolean isInNewDocument(String href) {
		int beginIndex = href.indexOf('#');
		int endIndex = -2;
		if (beginIndex >= 0) {
			endIndex = href.indexOf('/', beginIndex);
		}
		return beginIndex < 0 || endIndex < beginIndex;
	}
}
