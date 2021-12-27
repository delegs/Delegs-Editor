
package de.signWritingEditor.client.GWTClient.ui.tool.workbench;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.event.dom.client.HasNativeEvent;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.Event.NativePreviewHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.ClosingEvent;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.Window.Navigator;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

import de.signWritingEditor.client.GWTClient.ui.general.animation.Animation;
import de.signWritingEditor.client.GWTClient.ui.general.animation.Animator;
import de.signWritingEditor.client.GWTClient.ui.general.animation.FadeWidgetAnimation;
import de.signWritingEditor.client.GWTClient.ui.general.animation.SlideWidgetAnimation;
import de.signWritingEditor.client.GWTClient.ui.general.animation.UiUtil;
import de.signWritingEditor.client.GWTClient.ui.general.eventHandling.EventTranslatorMacImpl;
import de.signWritingEditor.client.GWTClient.ui.general.eventHandling.EventTranslatorStandardImpl;
import de.signWritingEditor.client.GWTClient.ui.general.eventHandling.EventTranslatorStandardImpl.Interaction;
import de.signWritingEditor.client.GWTClient.ui.general.widget.CloseButton;
import de.signWritingEditor.client.GWTClient.ui.general.widget.CloseButton.CloseListener;
import de.signWritingEditor.client.GWTClient.ui.general.widget.OrientedFlowPanel;
import de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.LoadingDialog;
import de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.LoginDialogBox;
import de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.LoginDialogBox.LoginDialogBoxListener;
import de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.MessageDialogBox;
import de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.PrivacyPolicyUpdateDialogBox;
import de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.YesNoDialogBox;
import de.signWritingEditor.client.GWTClient.ui.tool.general.tool.SignWritingCallback;
import de.signWritingEditor.client.GWTClient.ui.tool.general.tool.Tool;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentEditor;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.DocumentEditor.DocumentEditorListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentEditor.GWTDocumentEditor;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentManager.DocumentManager;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentManager.DocumentManager.DocumentManagerListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.documentManager.RoomInfoPanel.UserManagementMethod;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.fileManagement.NewDocumentDialogBox;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.fileManagement.PasswordForgottenDialogBox;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.pdfViewer.PdfViewer;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.signEditor.SignEditor;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.signEditor.SignEditor.SignEditorListener;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.signEditor.SignEditor.SignModifiedListener;
import de.signWritingEditor.client.GWTClient.ui.tool.workbench.ToolBar.ToolBarListener;
import de.signWritingEditor.client.GWTClient.ui.tool.workbench.UnsavedChangesPopupPanel.UnsavedChangesPanelListener;
import de.signWritingEditor.client.badge.gwtClient.service.BadgeServiceClient;
import de.signWritingEditor.client.service.AuthenticationServiceAsync;
import de.signWritingEditor.client.service.BrowserHistoryService;
import de.signWritingEditor.client.service.BrowserHistoryService.BrowserHistoryListener;
import de.signWritingEditor.client.service.CaptchaValidationServiceAsync;
import de.signWritingEditor.client.service.ContentReportServiceAsync;
import de.signWritingEditor.client.service.DictionaryServiceAsync;
import de.signWritingEditor.client.service.DocumentServiceAsync;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.client.service.HistoryService;
import de.signWritingEditor.client.service.HistoryService.HistoryListener;
import de.signWritingEditor.client.service.HistoryState;
import de.signWritingEditor.client.service.InvalidSessionException;
import de.signWritingEditor.client.service.LocalSessionService;
import de.signWritingEditor.client.service.LoggingServiceAsync;
import de.signWritingEditor.client.service.LogonListener;
import de.signWritingEditor.client.service.MediaUrlServiceAsync;
import de.signWritingEditor.client.service.NotificationServiceAsync;
import de.signWritingEditor.client.service.PdfServiceAsync;
import de.signWritingEditor.client.service.SignEditorHistoryState;
import de.signWritingEditor.client.service.SymbolServiceAsync;
import de.signWritingEditor.client.service.UserServiceAsync;
import de.signWritingEditor.client.service.VideoServiceAsync;
import de.signWritingEditor.shared.exceptions.MissingAuthorizationException;
import de.signWritingEditor.shared.i18n.I18NAccess;
import de.signWritingEditor.shared.i18n.I18NLocale;
import de.signWritingEditor.shared.infrastructure.OperatingSystemChecker;
import de.signWritingEditor.shared.infrastructure.URLConverter;
import de.signWritingEditor.shared.layout.TokenBoxFactory;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.IdFactory;
import de.signWritingEditor.shared.model.domainValue.OperatingSystem;
import de.signWritingEditor.shared.model.domainValue.Orientation;
import de.signWritingEditor.shared.model.domainValue.PageFormat;
import de.signWritingEditor.shared.model.domainValue.SignItemEditor;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.VersionNumber;
import de.signWritingEditor.shared.model.material.DocumentItem;
import de.signWritingEditor.shared.model.material.FileItem;
import de.signWritingEditor.shared.model.material.FolderItem;
import de.signWritingEditor.shared.model.material.Notification;
import de.signWritingEditor.shared.model.material.PdfFileItem;
import de.signWritingEditor.shared.model.material.RoomItem;
import de.signWritingEditor.shared.model.material.RoomPolicy;
import de.signWritingEditor.shared.model.material.SimpleSign;
import de.signWritingEditor.shared.model.material.TextbasedTokenStyleFactory;

public class Workbench extends Composite {
	private static final int NOTIFICATION_PANEL_Z_INDEX = 1000;

	private final DocumentServiceAsync documentService;
	private final UserServiceAsync userService;

	private ToolBar toolBar;

	private UnsavedChangesPopupPanel unsavedChangesPopupForChangeTool;
	private UnsavedChangesPopupPanel unsavedChangesPopupForLogout;

	private Stack<Tool> toolStack;
	private GWTDocumentEditor documentEditor;
	private DocumentManager documentManager;
	private SignEditor signEditor;

	private AbsolutePanel mainPanel;
	private SimplePanel shadowPanel;

	private EventTranslatorStandardImpl eventTranslator = GWT.create(EventTranslatorStandardImpl.class);

	private boolean runsInInternetExplorer;
	private final String applicationTitle;
	private Notification notification;

	private LocalSessionService localSessionService;

	private final HistoryService historyService;
	private BrowserHistoryService browserHistoryService;
	private LoadingDialog documentLoadingDialog;
	private FontSizeService fontSizeService;
	private ToolBarListener toolBarListener;
	private PasswordForgottenDialogBox passwordForgottenDialogBox;
	private BadgeServiceClient badgeService;
	private NotificationServiceAsync notificationService;

	private int privacyPolicyVersionNumber;

	// needed for lazy initialization of SignEditor
	private DictionaryServiceAsync dictionaryService;
	private SymbolServiceAsync symbolService;
	private PdfViewer pdfViewer;

	private boolean isNewDocument;

	public Workbench(AuthenticationServiceAsync authenticationService, final DocumentServiceAsync documentService,
			final DictionaryServiceAsync dictionaryService, final SymbolServiceAsync symbolService,
			final PdfServiceAsync pdfService, final VideoServiceAsync videoService,
			final MediaUrlServiceAsync mediaUrlService, CaptchaValidationServiceAsync captchaValidationService,
			UserServiceAsync userService, final LoggingServiceAsync loggingService,
			final BrowserHistoryService browserHistoryService, final LocalSessionService localSessionService,
			final URLConverter urlConverter, final Long uniqueNumber, final String applicationTitle,
			final FolderItem parentFolderOfDocumentItem, final DocumentItem documentItem, final RoomItem rootRoomItem,
			String backgroundImageName, final SignLocale defaultSignLocale, VersionNumber versionNumber,
			int privacyPolicyVersionNumber, final FontSizeService fontSizeService,
			final PasswordForgottenDialogBox passwordForgottenDialogBox, final BadgeServiceClient badgeService,
			final ContentReportServiceAsync contentReportService, NotificationServiceAsync notificationService,
			boolean hasJustEstablishedValidSession) {

		assert uniqueNumber != null : "Precondition failed: uniqueNumber != null";
		assert pdfService != null : "Precondition failed: pdfService != null";
		assert videoService != null : "Precondition failed: videoService != null";
		assert mediaUrlService != null : "Precondition failed: mediaUrlService != null";
		assert dictionaryService != null : "Precondition failed: dictionaryService != null";
		assert symbolService != null : "Precondition failed: symbolService != null";
		assert documentService != null : "Precondition failed: documentService != null";
		assert authenticationService != null : "Precondition failed: authenticationService != null";
		assert captchaValidationService != null : "Precondition failed: captchaValidationService != null";
		assert userService != null : "Precondition failed: userService != null";
		assert loggingService != null : "Precondition failed: loggingService != null";
		assert applicationTitle != null : "Precondition failed: applicationTitle != null";
		assert rootRoomItem != null : "Precondition failed: rootRoomItem != null";
		assert backgroundImageName != null : "Precondition failed: backgroundImageName != null";
		assert defaultSignLocale != null : "Precondition failed: defaultSignLocale != null";
		assert versionNumber != null : "Precondition failed: versionNumber != null";
		assert privacyPolicyVersionNumber >= 0 : "Precondition failed: privacyPolicyVersionNumber>=0";
		assert browserHistoryService != null : "Precondition failed: browserHistoryService != null";
		assert localSessionService != null : "Precondition failed: localSessionService != null";
		assert fontSizeService != null : "Precondition failed: fontSizeService != null";
		assert passwordForgottenDialogBox != null : "Precondition failed: passwordForgottenDialogBox != null";
		assert badgeService != null : "Precondition failed: badgeService != null";
		assert notificationService != null : "Precondition failed: notificationService != null";

		this.badgeService = badgeService;
		this.documentService = documentService;
		this.userService = userService;
		this.applicationTitle = applicationTitle;
		this.runsInInternetExplorer = Navigator.getUserAgent().toLowerCase().contains("msie");
		this.browserHistoryService = browserHistoryService;
		this.localSessionService = localSessionService;
		this.fontSizeService = fontSizeService;
		this.notificationService = notificationService;
		this.passwordForgottenDialogBox = passwordForgottenDialogBox;

		this.privacyPolicyVersionNumber = privacyPolicyVersionNumber;

		if (OperatingSystemChecker.getOperatingSystemType().equals(OperatingSystem.MacOS)) {
			eventTranslator = GWT.create(EventTranslatorMacImpl.class);
		}

		HistoryListener historyListener = createHistoryListener();
		this.historyService = new HistoryService(historyListener);

		mainPanel = new AbsolutePanel();
		mainPanel.setStylePrimaryName("workbench");
		mainPanel.getElement().getStyle().setPosition(Position.ABSOLUTE);
		mainPanel.getElement().getStyle().setBackgroundImage("url(images/" + backgroundImageName + ")");
		mainPanel.sinkEvents(Event.ONMOUSEDOWN);
		initWidget(mainPanel);

		Event.addNativePreviewHandler(new NativePreviewHandler() {
			@Override
			public void onPreviewNativeEvent(NativePreviewEvent event) {
				handleKeyDownEvent(event);
			}
		});

		toolBarListener = createToolBarListener();
		toolBar = new ToolBar(badgeService, toolBarListener, captchaValidationService, versionNumber,
				privacyPolicyVersionNumber, I18NAccess.I18N.getLocale());
		unsavedChangesPopupForChangeTool = new UnsavedChangesPopupPanel(new UnsavedChangesPanelListener() {
			@Override
			public void onSaveUnsavedChanges() {
				getCurrentTool().handleSave(new Tool.SavingFinishedListener() {
					@Override
					public void onSavingFinished() {
						isNewDocument = false;
						closeCurrentTool();
					}
				});
			}

			@Override
			public void onDiscardUnsavedChanges() {
				getCurrentTool().discardChanges();
				closeCurrentTool();
			}
		});

		updateNotificationCount();

		unsavedChangesPopupForLogout = new UnsavedChangesPopupPanel(new UnsavedChangesPanelListener() {
			@Override
			public void onSaveUnsavedChanges() {
				getCurrentTool().handleSave(new Tool.SavingFinishedListener() {
					@Override
					public void onSavingFinished() {
						logoutUser();
						createLoginDialogBox();
					}
				});
			}

			@Override
			public void onDiscardUnsavedChanges() {
				logoutUser();
				createLoginDialogBox();
			}
		});

		// prevent events from reaching rootpanel
		mainPanel.addHandler(new KeyDownHandler() {

			@Override
			public void onKeyDown(KeyDownEvent event) {
				event.stopPropagation();
			}
		}, KeyDownEvent.getType());
		mainPanel.sinkEvents(Event.ONKEYDOWN);

		mainPanel.add(toolBar, 0, 0);

		if (hasJustEstablishedValidSession) {
			localSessionService.restoreUserSession(new AsyncCallback<Boolean>() {

				@Override
				public void onSuccess(Boolean result) {
					startEditor(documentService, dictionaryService, symbolService, pdfService, videoService,
							mediaUrlService, loggingService, browserHistoryService, localSessionService, urlConverter,
							uniqueNumber, applicationTitle, parentFolderOfDocumentItem, documentItem, rootRoomItem,
							defaultSignLocale, fontSizeService, badgeService, contentReportService);
				}

				@Override
				public void onFailure(Throwable caught) {
				}
			});
		} else {
			localSessionService.setUserSessionToUnknownUserSession();
			startEditor(documentService, dictionaryService, symbolService, pdfService, videoService, mediaUrlService,
					loggingService, browserHistoryService, localSessionService, urlConverter, uniqueNumber,
					applicationTitle, parentFolderOfDocumentItem, documentItem, rootRoomItem, defaultSignLocale,
					fontSizeService, badgeService, contentReportService);
		}
	}

	private void startEditor(DocumentServiceAsync documentService, DictionaryServiceAsync dictionaryService,
			SymbolServiceAsync symbolService, PdfServiceAsync pdfService, VideoServiceAsync videoService,
			MediaUrlServiceAsync mediaUrlService, LoggingServiceAsync loggingService,
			final BrowserHistoryService browserHistoryService, final LocalSessionService localSessionService,
			URLConverter urlConverter, Long uniqueNumber, String applicationTitle,
			final FolderItem parentFolderOfDocumentItem, final DocumentItem documentItem, final RoomItem rootRoomItem,
			SignLocale defaultSignLocale, FontSizeService fontSizeService, BadgeServiceClient badgeService,
			ContentReportServiceAsync contentReportService) {
		if (!runsInInternetExplorer) {
			shadowPanel = new SimplePanel();
			shadowPanel.setStylePrimaryName("shadow");
			shadowPanel.setWidth("100%");
			shadowPanel.getElement().getStyle().setZIndex(100);
			mainPanel.add(shadowPanel);
		}

		Window.addResizeHandler(new ResizeHandler() {
			@Override
			public void onResize(ResizeEvent event) {
				rearrangeWidgets();
			}
		});

		Window.addWindowClosingHandler(new Window.ClosingHandler() {
			@Override
			public void onWindowClosing(ClosingEvent event) {
				handleWindowClosing(event);
			}
		});

		toolStack = new Stack<Tool>();

		// needed for lazy initialization of SignEditor
		this.dictionaryService = dictionaryService;
		this.symbolService = symbolService;

		FolderItem startFolderItem = null;
		if (parentFolderOfDocumentItem != null) {
			startFolderItem = parentFolderOfDocumentItem;
		} else {
			startFolderItem = rootRoomItem;
		}

		final boolean createEmptyDocument = documentItem == null;

		LogonListener localSessionServiceListener = createLocalSessionListener();
		localSessionService.setLocalSessionServiceListener(localSessionServiceListener);

		BrowserHistoryListener listener = createBrowserHistoryListener(rootRoomItem);
		browserHistoryService.setBrowserHistoryListener(listener);

		DocumentEditorListener documentEditorListener = createDocumentEditorListener();
		documentEditor = new GWTDocumentEditor(userService, dictionaryService, documentService, pdfService,
				videoService, mediaUrlService, loggingService, this.browserHistoryService, badgeService,
				contentReportService, urlConverter, new IdFactory(uniqueNumber), new TextbasedTokenStyleFactory(),
				applicationTitle, localSessionService, rootRoomItem, createEmptyDocument, defaultSignLocale,
				documentEditorListener, new TokenBoxFactory(fontSizeService), this.fontSizeService);

		documentManager = new DocumentManager(documentService, localSessionService, startFolderItem, rootRoomItem,
				createDocumentManagerListener(), fontSizeService);

		// Set initial tool state
		toolStack.push(documentManager);

		if (startFolderItem == rootRoomItem) {
			// Wenn man im Browser die Root-URL z.B.
			// https://apps.delegs.de/delegseditor/?locale=DE aufruft,
			// dann sollte sich automatisch ein leeres Dokument öffnen.

			// Falls man sich allerdings im DocumentManager im Root-Ordner
			// befindet und dann die Sprache wechselt, soll KEIN leeres Dokument
			// geöffnet werden. Da diese Information nicht in der URL selber
			// abzulesen ist, wird diese Information vor dem Neuladen der Seite
			// in einem Cookie abgelegt.
			String cookie = Cookies.getCookie("In_Documentmanager");
			if (cookie != null && cookie.equals("true")) {
				Cookies.removeCookie("In_Documentmanager");
			} else {
				toolStack.push(documentEditor);
			}
		}

		initToolView(parentFolderOfDocumentItem, documentItem, createEmptyDocument);

		if (localSessionService.hasStoredUserSession()) {
			AsyncCallback<Boolean> callback = new AsyncCallback<Boolean>() {

				@Override
				public void onSuccess(Boolean isValid) {
					if (isValid) {
						if (!localSessionService.isCurrentUserUnknown()) {
							loginUserSession();
							informToolsAboutLogin();
						}
						openInitialTool(parentFolderOfDocumentItem, documentItem, createEmptyDocument);
					} else {
						handleInvalidSession(parentFolderOfDocumentItem, documentItem, createEmptyDocument);
					}
				}

				@Override
				public void onFailure(Throwable caught) {
					handleInvalidSession(parentFolderOfDocumentItem, documentItem, createEmptyDocument);
				}

				private void handleInvalidSession(final FolderItem parentFolderOfDocumentItem,
						final DocumentItem documentItem, final boolean createEmptyDocument) {
					openInitialTool(parentFolderOfDocumentItem, documentItem, createEmptyDocument);
					createLoginDialogBox(I18N.getInvalidSessionLoginMessage());
				}
			};
			localSessionService.restoreUserSession(callback);
		} else {
			openInitialTool(parentFolderOfDocumentItem, documentItem, createEmptyDocument);
		}
		this.pdfViewer = new PdfViewer();
	}

	private void informToolsAboutLogin() {
		if (signEditor != null) {
			signEditor.onLogin();
		}
		documentManager.onLogin();
		documentEditor.onLogin();
		toolBar.switchToLoggedInMode(localSessionService.getCurrentUser());
		toolBar.informAboutLoggedInUser(localSessionService.getCurrentUser());
	}

	private void initToolView(FolderItem parentFolderOfDocumentItem, DocumentItem documentItem,
			boolean createEmptyDocument) {
		Tool firstToolToDisplay = toolStack.peek();
		firstToolToDisplay.getPanel().addStyleName("pdfTable");
		mainPanel.add(firstToolToDisplay.getPanel(), 0, 0);
		toolBar.setButtonBar(firstToolToDisplay.getButtonBar(), firstToolToDisplay.getButtonBarPosition());
		toolBar.setUndoRedoButtonsVisibility(firstToolToDisplay.hasHistorySupport());
		updateChangeToolButton();
		updateToolbarForHistory();
	}

	private void openInitialTool(FolderItem parentFolderOfDocumentItem, DocumentItem documentItem,
			boolean createEmptyDocument) {
		Tool firstToolToDisplay = toolStack.peek();
		firstToolToDisplay.open();
		if (!createEmptyDocument) {
			openDocument(parentFolderOfDocumentItem, documentItem);
		}
	}

	private HistoryListener createHistoryListener() {
		return new HistoryListener() {
			@Override
			public void onOpenSystemState(HistoryState historyState) {
				handleOpenSystemState(historyState);
			}

			@Override
			public void onHistoryChange() {
				updateToolbarForHistory();
			}
		};
	}

	private void handleOpenSystemState(HistoryState historyState) {
		if (historyState instanceof SignEditorHistoryState) {
			signEditor.openSignFromHistory((SignEditorHistoryState) historyState);
		}
	}

	private DocumentEditorListener createDocumentEditorListener() {
		return new DocumentEditorListener() {

			public void onPdfLoaded(PdfFileItem document) {
				handleLoadPdf(document);
			}

			private void handleLoadPdf(PdfFileItem document) {
				pdfViewer.loadPdf(document);
				openTool(pdfViewer);
				documentLoadingDialog.hide();
			}

			@Override
			public void onEditSign(SignItemEditor signItem, SignLocale signLocale, String searchWord,
					SignModifiedListener signModifiedListener) {
				handleEditSign(signItem, signLocale, searchWord, signModifiedListener);
			}

			@Override
			public void onInvalidSessionExceptionCaught() {
				handleInvalidSessionExceptionCaught();
			}

			@Override
			public void onDocumentLoaded() {
				handleDocumentLoaded();
			}

			@Override
			public void onExceptionDuringDocumentLoaded() {
				handleExceptionDuringDocumentLoaded();
			}

			@Override
			public void onDocumentSavedAs(FolderItem folder) {
				handleDocumentSavedAs(folder);
			}

		};
	}

	private LogonListener createLocalSessionListener() {
		return new LogonListener() {

			@Override
			public void onLogin() {
				loginUserSession();
				informToolsAboutLogin();
			}

			@Override
			public void onLoginFailed(String errorMessage) {
				createLoginDialogBox(errorMessage);
			}
		};
	}

	private void loginUserSession() {
		badgeService.userLoggedIn();

		checkAcceptedPrivacyPolicyVersion();

		updateNotificationCount();

		String href = Location.getHref();
		if (!(getCurrentTool() instanceof SignEditor) && !browserHistoryService.isInNewDocument(href)) {
			browserHistoryService.navigateToUrl(href);
		}
	}

	private void checkAcceptedPrivacyPolicyVersion() {
		if (localSessionService.getCurrentUser().getAcceptedPrivacyPolicyVersion() < this.privacyPolicyVersionNumber) {
			createUpdatedPrivacyPolicyDialogBox();
		}
	}

	private void createUpdatedPrivacyPolicyDialogBox() {
		PrivacyPolicyUpdateDialogBox dialogBox = new PrivacyPolicyUpdateDialogBox() {

			@Override
			public void onAccept() {
				localSessionService.updateAcceptedPrivacyPolicyVersion(privacyPolicyVersionNumber);
			}

			@Override
			public void onDecline() {
				handleLogout();
			}
		};

		dialogBox.center();
	}

	private void updateNotificationCount() {
		if (localSessionService.getUserSession() != null) {
			notificationService.getNotificationCount(localSessionService.getCurrentUser().getUsername(),
					new AsyncCallback<Integer>() {

						@Override
						public void onFailure(Throwable caught) {
							toolBar.setNotificationCount(0);
						}

						@Override
						public void onSuccess(Integer result) {
							toolBar.setNotificationCount(result);
						}
					});
		} else {
			toolBar.setNotificationCount(0);
		}
	}

	private BrowserHistoryListener createBrowserHistoryListener(final RoomItem rootRoomItem) {
		return new BrowserHistoryListener() {

			@Override
			public void onDocumentItemRequested(FolderItem parentFolderOfDocument, DocumentItem documentItem) {
				openDocument(parentFolderOfDocument, documentItem);
			}

			@Override
			public void onFolderItemRequested(FolderItem folderItem) {
				handleFolderItemRequested(folderItem);
			}

			@Override
			public void onDefaultFileItemRequested() {
				handleEmptyFileItemRequested(rootRoomItem);
			}

			@Override
			public void onFileItemAccessDenied() {
				createBrowserHistoryLoginDialogBox();
			}

			@Override
			public void onSessionInvalid() {
				handleInvalidSessionExceptionCaught();
				handleEmptyFileItemRequested(rootRoomItem);
			}
		};
	}

	// also invoked if file can not be accessed by user due to missing access
	// rights
	private void createLoginDialogBox() {
		LoginDialogBoxListener loginDialogListener = createLoginDialogBoxListener(
				!browserHistoryService.isInPublicFolder());
		LoginDialogBox loginDialogBox = new LoginDialogBox(I18N.getLoginRequired(), loginDialogListener);
		loginDialogBox.center();
		loginDialogBox.setFocusUsernameTextBox();
	}

	private void createBrowserHistoryLoginDialogBox() {
		LoginDialogBoxListener loginDialogListener = createLoginDialogBoxListener(true);
		LoginDialogBox loginDialogBox = new LoginDialogBox(I18N.getLoginRequired(), loginDialogListener);
		loginDialogBox.center();
		loginDialogBox.setFocusUsernameTextBox();
	}

	protected void createLoginDialogBox(String errorMessage) {
		LoginDialogBoxListener loginDialogListener = createLoginDialogBoxListener(
				!browserHistoryService.isInPublicFolder());
		final LoginDialogBox loginDialogBox = new LoginDialogBox(I18N.getLoginRequired(), loginDialogListener,
				errorMessage);
		loginDialogBox.center();
		loginDialogBox.setFocusUsernameTextBox();
	}

	private void createInvalidSessionLoginDialogBox() {
		LoginDialogBoxListener loginDialogListener = createInvalidSessionDialogBoxListener();
		final LoginDialogBox loginDialogBox = new LoginDialogBox(I18N.getLoginRequired(), loginDialogListener,
				I18N.getInvalidSessionLoginDialogMessage());
		loginDialogBox.center();
		loginDialogBox.setFocusUsernameTextBox();
	}

	private LoginDialogBoxListener createInvalidSessionDialogBoxListener() {
		return new LoginDialogBoxListener() {

			@Override
			public void onLogin(String username, String password) {
				assert username != null : "Precondition failed: username != null";
				assert password != null : "Precondition failed: password != null";

				localSessionService.login(username, password);
			}

			@Override
			public void onClose() {
				badgeService.userLoggedOut();
				toolBar.switchToLoggedOutMode();
				toolBar.informAboutLoggedOutUser();
				getCurrentTool().logout();

				boolean isInSignOrDocumentEditor = getCurrentTool() instanceof SignEditor
						|| getCurrentTool() instanceof DocumentEditor;
				if (!browserHistoryService.isInPublicFolder() && isInSignOrDocumentEditor) {
					browserHistoryService.openEmptyDocument();
				}
			}

			@Override
			public void onPasswordForgotten() {
				passwordForgottenDialogBox.center();
				passwordForgottenDialogBox.focusUsernameOrEmailAddressTextBox();
			}
		};
	}

	private LoginDialogBoxListener createLoginDialogBoxListener(final boolean createEmptyDocumentOnClose) {
		return new LoginDialogBoxListener() {

			@Override
			public void onLogin(String username, String password) {
				assert username != null : "Precondition failed: username != null";
				assert password != null : "Precondition failed: password != null";

				localSessionService.login(username, password);
			}

			@Override
			public void onClose() {
				if (createEmptyDocumentOnClose) {
					browserHistoryService.openEmptyDocument();
				}
			}

			@Override
			public void onPasswordForgotten() {
				passwordForgottenDialogBox.center();
				passwordForgottenDialogBox.focusUsernameOrEmailAddressTextBox();
			}
		};
	}

	private void handleFolderItemRequested(FolderItem folderItem) {
		documentManager.openFolder(folderItem);
	}

	private void handleEmptyFileItemRequested(final RoomItem rootRoomItem) {
		documentEditor.createNewDocument();
		documentManager.openFolder(rootRoomItem);
		if (getCurrentTool() != documentEditor) {
			closeCurrentTool();
			openTool(documentEditor);
		}
	}

	private void openDocument(final FolderItem parentFolderOfDocument, final DocumentItem document) {

		documentManager.openFolder(parentFolderOfDocument);

		if (toolStack.peek() instanceof SignEditor) {
			closeCurrentTool();
		}

		if (!(parentFolderOfDocument instanceof RoomItem)) {

			documentService.getParentRoomForFileItem(parentFolderOfDocument,
					new SignWritingCallback<RoomItem>(I18N.getErrorOnLoadingFolder()) {

						public void onSuccess(RoomItem room) {
							openDocument(document, parentFolderOfDocument, room);
						};
					});
		} else {
			openDocument(document, parentFolderOfDocument, (RoomItem) parentFolderOfDocument);
		}

	}

	private void handleExceptionDuringDocumentLoaded() {
		documentLoadingDialog.hide();
	}

	private void handleEditSign(final SignItemEditor signItem, final SignLocale signLocale, String searchWord,
			final SignModifiedListener signModifiedListener) {
		if (signEditor == null) {
			signEditor = GWT.create(SignEditor.class);

			signEditor.init(dictionaryService, symbolService, historyService, badgeService, localSessionService,
					createSignEditorListener());
		}
		signEditor.openSign(signItem, signLocale, searchWord, signModifiedListener);
		openTool(signEditor);
	}

	private void handleDocumentLoaded() {
		openTool(documentEditor);
		documentLoadingDialog.hide();
	}

	private void handleDocumentSavedAs(FolderItem folder) {
		isNewDocument = false;
		documentManager.openFolder(folder);
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);

		if (visible) {
			rearrangeWidgets();
		}
	}

	protected void openNewDocumentDialogBox() {
		final NewDocumentDialogBox newDocumentDialogBox = new NewDocumentDialogBox(
				documentEditor.getDefaultSignLocale()) {
			@Override
			protected void handleNewDocument(FileTitle fileTitle, PageFormat pageFormat, SignLocale signLocale) {
				FolderItem currentFolder = documentManager.getCurrentFolder();
				RoomItem currentRoom = documentManager.getCurrentRoom();
				documentEditor.createNewDocument(fileTitle, pageFormat, signLocale, currentFolder, currentRoom);
				openTool(documentEditor);
			}
		};
		newDocumentDialogBox.center();
	}

	@Override
	protected void onLoad() {
		super.onLoad();

		rearrangeWidgets();
	}

	private <E extends HasNativeEvent> void handleKeyDownEvent(E event) {
		assert event != null : "Precondition failed: event != null";

		if (Interaction.UNDO == eventTranslator.get(event)) {
			historyService.undo();
			event.getNativeEvent().stopPropagation();
			event.getNativeEvent().preventDefault();
		} else if (Interaction.REDO == eventTranslator.get(event)) {
			historyService.redo();
			event.getNativeEvent().stopPropagation();
			event.getNativeEvent().preventDefault();
		}
	}

	private void updateToolbarForHistory() {
		toolBar.setUndoButtonEnabled(historyService.hasPreviousHistoryEntry());
		toolBar.setRedoButtonEnabled(historyService.hasNextHistoryEntry());
	}

	private void displayTool(final Tool currentTool, final Tool toolToDisplay, boolean slideToLeft) {
		assert toolToDisplay != null : "Precondition failed: toolToChangeTo != null";
		assert currentTool != null : "Precondition failed: currentTool != null";

		final int fadingStepCount = 4;
		final String animationId = "changeToTool";
		int slidingStepCount = 6;
		int slidingDistance = 100;

		if (runsInInternetExplorer) {
			slidingStepCount = 10;
			slidingDistance = Window.getClientWidth();
		}

		Animator.getInstance().removeAnimations(animationId);
		slidingDistance = slideToLeft ? -slidingDistance : slidingDistance;
		toolToDisplay.getPanel().addStyleName("pdfTable");
		mainPanel.add(toolToDisplay.getPanel(), slidingDistance, toolBar.getOffsetHeight());

		if (!runsInInternetExplorer) {
			UiUtil.setOpacity(toolToDisplay.getPanel(), 0d, true);
			Animator.getInstance().addAnimation(animationId,
					new FadeWidgetAnimation(currentTool.getPanel(), 0d, false, fadingStepCount, 0, null));

			Animator.getInstance().addAnimation(animationId, new FadeWidgetAnimation(toolToDisplay.getPanel(), 1d,
					false, fadingStepCount, slidingStepCount - fadingStepCount, null));
		}

		Animator.getInstance().addAnimation(animationId, new SlideWidgetAnimation(currentTool.getPanel(),
				-slidingDistance, toolBar.getOffsetHeight(), slidingStepCount, 0, new Animation.Listener() {
					@Override
					public void onDone() {
						mainPanel.remove(currentTool.getPanel());

						updateWindowTitle(toolToDisplay.getTitle());

						toolBar.setButtonBar(toolToDisplay.getButtonBar(), toolToDisplay.getButtonBarPosition());

						updateChangeToolButton();

						rearrangeWidgets();

						toolToDisplay.open();

						if (currentTool instanceof DocumentEditor && !isNewDocument) {
							setDocumentItemSelectionInDocumentManager();
						}
					}

					private void setDocumentItemSelectionInDocumentManager() {
						FileTitle documentTitle = documentEditor.getDocument().getDocumentTitle();
						Id currentFolderId = documentManager.getCurrentFolder().getId();

						documentService.setLastClosedDocument(documentTitle, currentFolderId,
								new AsyncCallback<Void>() {

									@Override
									public void onFailure(Throwable caught) {
										if (!hasPreviousTool()) {
											documentManager.open();
										}
									}

									@Override
									public void onSuccess(Void result) {
										documentService.getLastClosedDocumentItem(new AsyncCallback<DocumentItem>() {

											@Override
											public void onSuccess(DocumentItem result) {
												documentManager.selectLastClosedDocumentItem(result);
											}

											@Override
											public void onFailure(Throwable caught) {
												if (!hasPreviousTool()) {
													documentManager.open();
												}
											}

										});
									}
								});
					}
				}));

		Animator.getInstance().addAnimation(animationId, new SlideWidgetAnimation(toolToDisplay.getPanel(), 0,
				toolBar.getOffsetHeight(), slidingStepCount, 0, null));

		toolBar.setUndoRedoButtonsVisibility(toolToDisplay.hasHistorySupport());
	}

	private ToolBarListener createToolBarListener() {
		return new ToolBarListener() {

			@Override
			public void onLogin(String username, String password) {
				handleLogin(username, password);
			}

			@Override
			public void onLogout() {
				handleLogout();
			}

			@Override
			public void onChangeTool() {
				handleChangeTool();
			}

			@Override
			public void onUndo() {
				handleUndo();
			}

			@Override
			public void onRedo() {
				handleRedo();
			}

			@Override
			public void onRegisterUser(final String username, String firstName, String lastName, final String password,
					String emailAddressString, int privacyPolicyVersionNumber) {
				handleRegisterUser(username, firstName, lastName, password, emailAddressString,
						privacyPolicyVersionNumber);
			}

			@Override
			public void onPasswordForgotten() {
				handlePasswordForgotten();
			}

			@Override
			public void onShowMessage() {
				handleShowMessage();
			}

			@Override
			public void onLanguageChanged(I18NLocale locale) {
				handleLanguageChanged(locale);
			}
		};
	}

	private void handleLanguageChanged(I18NLocale locale) {
		if (!I18NAccess.I18N.getLocale().equals(locale)) {
			String preparedUrl = Location.createUrlBuilder().setParameter("locale", locale.name()).buildString();

			if ('#' == Location.getHref().charAt(Location.getHref().length() - 1)) {
				preparedUrl = preparedUrl.concat("#");
			}

			if (toolStack.peek().equals(documentManager)) {
				Cookies.setCookie("In_Documentmanager", "true");
			}

			if (getCurrentTool().hasUnsavedChanges()) {
				createDiscardChangesDialogBox(preparedUrl);
			} else {
				Window.Location.assign(preparedUrl);
			}
		}
	}

	private void createDiscardChangesDialogBox(String url) {
		final String href = url;
		final String dialogTitle = I18N.getNote();
		final String dialogText = I18N.getWhenYouLeavePageUnsavedChangesGetLost() + "<br>"
				+ I18N.getDoYouWantToDiscardTheChanges();
		YesNoDialogBox dialogBox = new YesNoDialogBox(dialogTitle, dialogText) {
			@Override
			public void onYes() {
				Window.Location.assign(href);
			}

			@Override
			public void onNo() {
				hide();
			}
		};
		dialogBox.center();
		dialogBox.show();
	}

	private void handleShowMessage() {
		final PopupPanel popupPanel = new PopupPanel(true);
		popupPanel.getElement().getStyle().setZIndex(NOTIFICATION_PANEL_Z_INDEX);
		OrientedFlowPanel notificationPanel = new OrientedFlowPanel(Orientation.VERTICAL);

		OrientedFlowPanel closePanel = new OrientedFlowPanel(Orientation.HORIZONTAL);
		closePanel.getElement().getStyle().setProperty("marginTop", "10px");

		final SimplePanel messagePanel = new SimplePanel();
		final HTML messageLabel = new HTML();

		if (!localSessionService.isCurrentUserUnknown()) {
			removeNotificationOnClose(popupPanel);
		}

		CloseButton closeButton = new CloseButton(new CloseListener() {
			@Override
			public void onClose() {
				// To prevent a black screen when removing in IE8

				popupPanel.hide();
				popupPanel.removeFromParent();
			}
		});
		closeButton.getElement().getStyle().setProperty("float", "right");

		notificationService.getNotifications(localSessionService.getCurrentUser().getUsername(),
				new AsyncCallback<List<Notification>>() {
					@Override
					public void onSuccess(List<Notification> result) {
						// Momentan soll es nur eine Notification geben. Wird
						// dies geändert muss hier die Darstellung angepasst
						// werden.
						if (result.size() > 0) {
							notification = result.get(0);
							String notificationMessage = notification.getNotification(I18NAccess.I18N.getLocale());
							if (notificationMessage == null) {
								notificationMessage = notification.getNotification(I18NLocale.EN);
							}
							messageLabel.setHTML(notificationMessage);
							popupPanel.center();
							popupPanel.show();
							updateNotificationCount();
						}
					}

					@Override
					public void onFailure(Throwable caught) {
					}
				});

		messagePanel.getElement().getStyle().setProperty("minWidth", "250px");
		messagePanel.getElement().getStyle().setProperty("maxWidth", "500px");
		messagePanel.getElement().getStyle().setProperty("minHeight", "75px");
		messagePanel.getElement().getStyle().setProperty("padding", "25px");
		messageLabel.getElement().getStyle().setProperty("textAlign", "center");

		messagePanel.add(messageLabel);
		closePanel.add(closeButton);

		notificationPanel.add(closePanel);
		notificationPanel.add(messagePanel);

		popupPanel.add(notificationPanel);

		popupPanel.getElement().getStyle().setProperty("boxShadow", "0px 5px 10px #888");
		popupPanel.getElement().getStyle().setProperty("backgroundColor", "#eff3f9");
	}

	private void removeNotificationOnClose(final PopupPanel popupPanel) {
		popupPanel.addCloseHandler(new CloseHandler<PopupPanel>() {
			@Override
			public void onClose(CloseEvent<PopupPanel> event) {
				notificationService.removeNotificationEntry(localSessionService.getCurrentUser().getUsername(),
						new AsyncCallback<Void>() {
							@Override
							public void onFailure(Throwable caught) {
							}

							@Override
							public void onSuccess(Void result) {
								updateNotificationCount();
							}
						});
			}
		});
	}

	private void handleUndo() {
		historyService.undo();
	}

	private void handleRedo() {
		historyService.redo();
	}

	protected void handlePasswordForgotten() {
		passwordForgottenDialogBox.center();
		passwordForgottenDialogBox.focusUsernameOrEmailAddressTextBox();
	}

	protected void handleRegisterUser(String username, String firstName, String lastName, String password,
			String emailAddressString, int privacyPolicyVersionNumber) {
		assert username != null : "Precondition failed: username != null";
		assert firstName != null : "Precondition failed: firstName != null";
		assert lastName != null : "Precondition failed: lastName != null";
		assert password != null : "Precondition failed: password != null";
		assert emailAddressString != null : "Precondition failed: emailAddressString != null";
		assert privacyPolicyVersionNumber >= 0 : "Precondition failed: privacyPolicyVersionNumber>=0";

		localSessionService.registerUser(username, firstName, lastName, password, emailAddressString,
				privacyPolicyVersionNumber);
	}

	protected void handleLogin(String username, String password) {
		assert username != null : "Precondition failed: username != null";
		assert password != null : "Precondition failed: password != null";

		localSessionService.login(username, password);
	}

	private SignEditorListener createSignEditorListener() {
		return new SignEditorListener() {
			@Override
			public void onChangeTool(SimpleSign sign) {
				handleForceChangeTool(sign);
			}

			@Override
			public void onInvalidSessionExceptionCaught() {
				handleInvalidSessionExceptionCaught();
			}

			@Override
			public void onMissingAuthorizationExceptionCaught(String message) {
				handleMissingAuthorizationExceptionCaught(message);
			}
		};
	}

	private DocumentManagerListener createDocumentManagerListener() {
		return new DocumentManagerListener() {
			@Override
			public void onOpenDocument(DocumentItem documentItem, FolderItem folderItem,
					RoomItem roomContainingDocument) {
				handleOpenDocument(documentItem, folderItem, roomContainingDocument);
			}

			@Override
			public void onOpenNewDocument() {
				handleOpenNewDocument();
			}

			@Override
			public void onInvalidSessionExceptionCaught() {
				handleInvalidSessionExceptionCaught();
			}

			@Override
			public void onMissingAuthorizationExceptionCaught() {
				handleMissingAuthorizationExceptionCaught(I18N.getPermissionForActionDenied());
			}

			@Override
			public void onAddUserToRoom(RoomItem room, String userName) {
				handleAddUserToRoom(room, userName);
			}

			@Override
			public void onDeleteUserFromRoom(RoomItem room, String userName) {
				handleDeleteUserFromRoom(room, userName);
			}

			@Override
			public void onPolicyChanged(RoomItem room, RoomPolicy selectedPolicy) {
				handleChangeRoomPolicy(room, selectedPolicy);
			}

			@Override
			public void onDeleteAdminFromRoom(RoomItem room, String name) {
				handleDeleteAdminFromRoom(room, name);
			}

			@Override
			public void onAddAdminToRoom(RoomItem room, String name) {
				handleAddAdminToRoom(room, name);
			}

			@Override
			public void onOpenFolder(FolderItem folder) {
				handleOpenFolder(folder);
			}
		};

	}

	private void handleOpenFolder(FolderItem folder) {
		if (getCurrentTool() instanceof DocumentManager) {
			browserHistoryService.createHistoryToken(folder);
		}
	}

	private void handleLogout() {
		if (!documentManager.getCurrentRoom().isHidden() || getCurrentTool() instanceof DocumentManager) {
			logoutUser();
		} else {
			if (getCurrentTool().hasUnsavedChanges()) {
				if (!unsavedChangesPopupForLogout.isAttached()) {
					unsavedChangesPopupForLogout.setToSaveOrDiscardChangesMode();
					unsavedChangesPopupForLogout.displayBelow(toolBar.getChangeToolButton());
				}
			} else {
				logoutUser();
				createLoginDialogBox();
			}
		}
	}

	private void logoutUser() {
		localSessionService.logout();
		badgeService.userLoggedOut();
		toolBar.switchToLoggedOutMode();
		getCurrentTool().logout();
		updateNotificationCount();
	}

	private void handleAddUserToRoom(final RoomItem room, final String username) {
		userService.addUserToRoom(room, username, localSessionService.getSessionKey(), new AsyncCallback<Boolean>() {

			@Override
			public void onFailure(Throwable caught) {
				if (caught instanceof MissingAuthorizationException) {
					handleMissingAuthorizationExceptionCaught(I18N.getAddUserToRoomNotAllowed());
				} else if (caught instanceof InvalidSessionException) {
					handleInvalidSessionExceptionCaught();
				}
			}

			@Override
			public void onSuccess(Boolean result) {
				if (result == true) {
					room.addUserToRoom(username);
					documentManager.updateRoomInfoPanel(room, UserManagementMethod.ADD_USER);
					Window.alert(I18N.getUserAddedToRoomSuccessfully());
				} else {
					Window.alert(I18N.getFailMessageAddUserToRoom());
				}
			}
		});
	}

	private void handleMissingAuthorizationExceptionCaught(String message) {
		new MessageDialogBox(I18N.getMissingAuthorization(), message).center();
	}

	private void handleDeleteUserFromRoom(final RoomItem room, final String userName) {
		userService.deleteUserFromRoom(room, userName, localSessionService.getSessionKey(),
				new AsyncCallback<Boolean>() {

					@Override
					public void onFailure(Throwable caught) {
						if (caught instanceof InvalidSessionException) {
							handleInvalidSessionExceptionCaught();
						} else if (caught instanceof MissingAuthorizationException) {
							handleMissingAuthorizationExceptionCaught(I18N.getDeleteUserToRoomNotAllowed());
						}
					}

					@Override
					public void onSuccess(Boolean result) {
						if (result == true) {
							room.deleteUserFromRoom(userName);
							documentManager.updateRoomInfoPanel(room, UserManagementMethod.DELETE_USER);
							if (!room.isRoomAccessPermitted(localSessionService.getCurrentUser().getUsername())) {
								documentManager.openRootRoom();
							}
							Window.alert(I18N.getRemovedUserFromRoomSuccessfully());
						} else {
							Window.alert(I18N.getFailMessageRemoveUserFromRoom());
						}
					}
				});

	}

	private void handleAddAdminToRoom(final RoomItem room, final String adminName) {
		userService.addAdminToRoom(room, adminName, localSessionService.getSessionKey(), new AsyncCallback<Boolean>() {

			@Override
			public void onFailure(Throwable caught) {
				if (caught instanceof InvalidSessionException) {
					handleInvalidSessionExceptionCaught();
				} else if (caught instanceof MissingAuthorizationException) {
					handleMissingAuthorizationExceptionCaught(I18N.getAddAdminToRoomNotAllowed());
				}
			}

			@Override
			public void onSuccess(Boolean result) {
				if (result == true) {
					room.addAdminToRoom(adminName);
					documentManager.updateRoomInfoPanel(room, UserManagementMethod.ADD_ADMIN);
					Window.alert(I18N.getAdminAddedToRoomSuccessfully());
				} else {
					Window.alert(I18N.getFailMessageAddAdminToRoom());
				}
			}
		});
	}

	private void handleDeleteAdminFromRoom(final RoomItem room, final String adminName) {
		userService.deleteAdminFromRoom(room, adminName, localSessionService.getSessionKey(),
				new AsyncCallback<Boolean>() {

					@Override
					public void onFailure(Throwable caught) {
						if (caught instanceof InvalidSessionException) {
							handleInvalidSessionExceptionCaught();
						} else if (caught instanceof MissingAuthorizationException) {
							handleMissingAuthorizationExceptionCaught(I18N.getDeleteAdminToRoomNotAllowed());
						}
					}

					@Override
					public void onSuccess(Boolean result) {
						if (result == true) {
							room.deleteAdminFromRoom(adminName);
							documentManager.updateRoomInfoPanel(room, UserManagementMethod.DELETE_ADMIN);
							Window.alert(I18N.getRemovedAdminFromRoomSuccessfully());
						} else {
							Window.alert(I18N.getFailMessageRemoveAdminFromRoom());
						}
					}
				});
	}

	private void handleChangeRoomPolicy(final RoomItem room, final RoomPolicy selectedPolicy) {
		documentService.changeRoomPolicy(room, selectedPolicy, new AsyncCallback<Boolean>() {

			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}

			@Override
			public void onSuccess(Boolean result) {
				if (result == true) {
					room.setRoomPolicy(selectedPolicy);
					documentManager.updateRoomInfoPanel(room, UserManagementMethod.NONE);
				} else {
				}
			}
		});
	}

	private void handleOpenNewDocument() {
		isNewDocument = true;
		openNewDocumentDialogBox();
	}

	private void handleOpenDocument(final DocumentItem documentItem, final FolderItem currentFolderItem,
			final RoomItem roomContainingDocument) {
		assert documentItem != null : "Precondition failed: documentItem != null";
		assert currentFolderItem != null : "Precondition failed: folderItem != null";
		assert roomContainingDocument != null : "Precondition failed: roomContainingDocument != null";
		isNewDocument = false;
		openDocument(documentItem, currentFolderItem, roomContainingDocument);
	}

	private void openDocument(final DocumentItem documentItem, FolderItem currentFolderItem,
			RoomItem roomContainingDocument) {

		List<DocumentItem> documentItemsInFolder = new ArrayList<DocumentItem>();
		List<FileItem> fileItems = new ArrayList<FileItem>();

		List<FileItem> selectedFileItems = documentManager.getSelectedFileItems();
		if (selectedFileItems.size() > 1) {
			for (FileItem fileItem : documentManager.getSortedFileItems()) {
				if (selectedFileItems.contains(fileItem) || fileItem.equals(documentItem)) {
					fileItems.add(fileItem);
				}
			}
		} else {
			fileItems = documentManager.getSortedFileItems();
		}

		for (FileItem fileItem : fileItems) {
			if (fileItem instanceof DocumentItem) {
				if (roomContainingDocument
						.isReadFilePermitted(localSessionService.getCurrentUser().getDisplayUsername(), fileItem)) {
					documentItemsInFolder.add((DocumentItem) fileItem);
				}
			}
		}

		if (!documentItemsInFolder.isEmpty()) {
			documentLoadingDialog = new LoadingDialog(I18N.getPleaseWait(), I18N.getLoadingDocument());
			documentLoadingDialog.ensureDebugId("workbench-documentLoadingDialog");
			documentLoadingDialog.center();
			documentEditor.openDocument(documentItem, currentFolderItem, roomContainingDocument, documentItemsInFolder);
		}
	}

	private void handleInvalidSessionExceptionCaught() {
		localSessionService.setUserSessionToUnknownUserSession();

		createInvalidSessionLoginDialogBox();
	}

	private void handleWindowClosing(ClosingEvent event) {
		assert event != null : "Precondition failed: event != null";

		boolean unsavedChanges = false;

		for (Tool tool : toolStack) {
			unsavedChanges |= tool.hasUnsavedChanges();
		}

		if (unsavedChanges) {
			event.setMessage(I18N.getWhenYouLeavePageUnsavedChangesGetLost());
		}
	}

	private void updateChangeToolButton() {
		boolean hasPreviousTool = hasPreviousTool();
		toolBar.setChangeToolButtonEnabled(hasPreviousTool);
		if (hasPreviousTool) {
			toolBar.setChangeToolButtonIcon(getPreviousTool().getIcon());
		}
	}

	private void closeCurrentTool() {
		Tool previousTool = getPreviousTool();
		Tool currentTool = toolStack.pop();

		currentTool.close();

		displayTool(currentTool, previousTool, true);
	}

	private void handleChangeTool() {
		if (hasPreviousTool()) {
			Tool currentTool = getCurrentTool();

			if (currentTool.hasUnsavedChanges()) {
				if (!unsavedChangesPopupForChangeTool.isAttached()) {
					if (currentTool instanceof DocumentEditor) {
						unsavedChangesPopupForChangeTool.setToSaveOrDiscardChangesMode();
					} else if (currentTool instanceof SignEditor) {
						unsavedChangesPopupForChangeTool.setToStayOrDiscardChangesMode();
					}
					unsavedChangesPopupForChangeTool.displayBelow(toolBar.getChangeToolButton());
				} else {
					unsavedChangesPopupForChangeTool.close();
				}
			} else {
				closeCurrentTool();
			}
		}
	}

	private void handleForceChangeTool(SimpleSign sign) {
		if (hasPreviousTool()) {
			closeCurrentTool();
			documentEditor.updateAllTokensWithWord(sign.getSignId().getLowerIdPart());
		}
	}

	private Tool getCurrentTool() {
		return toolStack.peek();
	}

	private boolean hasPreviousTool() {
		return toolStack.size() > 1;
	}

	private Tool getPreviousTool() {
		assert hasPreviousTool() : "Precondition failed: hasPreviousTool()";

		return toolStack.get(toolStack.size() - 2);
	}

	private void openTool(Tool newTool) {
		assert newTool != null : "Precondition failed: tool != null";

		Tool oldTool = getCurrentTool();
		if (oldTool != newTool) {
			toolStack.push(newTool);

			displayTool(oldTool, newTool, false);
		}
	}

	private void rearrangeWidgets() {
		int toolBarOffsetHeight = toolBar.getOffsetHeight();

		if (shadowPanel != null) {
			mainPanel.setWidgetPosition(shadowPanel, 0, toolBarOffsetHeight);
		}

		Widget toolPanel = getCurrentTool().getPanel();
		int toolPanelHeight = mainPanel.getOffsetHeight() - toolBarOffsetHeight;
		if (toolPanelHeight > 0) {
			mainPanel.setWidgetPosition(toolPanel, 0, toolBarOffsetHeight);
			toolPanel.setHeight(toolPanelHeight + "px");
		}
	}

	private void updateWindowTitle(String toolTitle) {
		assert toolTitle != null : "Precondition failed: toolTitle != null";

		Window.setTitle(toolTitle + " - " + applicationTitle);
	}
}
