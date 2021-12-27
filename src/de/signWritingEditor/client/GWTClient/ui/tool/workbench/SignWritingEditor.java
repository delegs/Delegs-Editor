package de.signWritingEditor.client.GWTClient.ui.tool.workbench;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.rpc.AsyncCallback;

import de.signWritingEditor.client.GWTClient.infrastructure.URLConverterClientImpl;
import de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.LoginDialogBox;
import de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.LoginDialogBox.LoginDialogBoxListener;
import de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.MessageDialogBox;
import de.signWritingEditor.client.GWTClient.ui.tool.general.tool.SignWritingCallback;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.fileManagement.PasswordForgottenDialogBox;
import de.signWritingEditor.client.GWTClient.ui.tool.subtools.fileManagement.PasswordForgottenValidator;
import de.signWritingEditor.client.badge.gwtClient.service.BadgeServiceClient;
import de.signWritingEditor.client.badge.gwtClient.service.BadgeServiceClientImpl;
import de.signWritingEditor.client.service.AuthenticationServiceAsync;
import de.signWritingEditor.client.service.BadgeServiceAsync;
import de.signWritingEditor.client.service.BrowserHistoryService;
import de.signWritingEditor.client.service.BrowserHistoryServiceImpl;
import de.signWritingEditor.client.service.CaptchaValidationServiceAsync;
import de.signWritingEditor.client.service.ContentReportServiceAsync;
import de.signWritingEditor.client.service.DictionaryServiceAsync;
import de.signWritingEditor.client.service.DocumentServiceAsync;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.client.service.FontSizeServiceImpl;
import de.signWritingEditor.client.service.LocalSessionService;
import de.signWritingEditor.client.service.LocalSessionServiceImpl;
import de.signWritingEditor.client.service.LoggingServiceAsync;
import de.signWritingEditor.client.service.LogonListener;
import de.signWritingEditor.client.service.MediaUrlServiceAsync;
import de.signWritingEditor.client.service.NotificationServiceAsync;
import de.signWritingEditor.client.service.PdfServiceAsync;
import de.signWritingEditor.client.service.SignWritingService;
import de.signWritingEditor.client.service.SignWritingServiceAsync;
import de.signWritingEditor.client.service.SymbolServiceAsync;
import de.signWritingEditor.client.service.UserServiceAsync;
import de.signWritingEditor.client.service.VideoServiceAsync;
import de.signWritingEditor.shared.badge.model.domainValue.DelegsBadgeType;
import de.signWritingEditor.shared.i18n.I18N;
import de.signWritingEditor.shared.i18n.I18NAccess;
import de.signWritingEditor.shared.i18n.I18NLocale;
import de.signWritingEditor.shared.infrastructure.InitBundle;
import de.signWritingEditor.shared.infrastructure.URLConverter;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.material.DocumentItem;
import de.signWritingEditor.shared.model.material.FolderItem;

public class SignWritingEditor implements EntryPoint {

	private SignWritingServiceAsync signWritingService;
	private BrowserHistoryService browserHistoryService;
	private LocalSessionService localSessionService;
	private SignWritingInitializer signWritingInitializationService;
	private UserServiceAsync userService;
	private InitBundle initBundle;
	private boolean hasJustEstablishedValidSession;

	/**
	 * This is the entry point method. It can be seen as an init or main method.
	 * GWT calls it when starting the application.
	 */
	@Override
	public void onModuleLoad() {
		// Attributes
		I18NAccess.I18N = readLocaleParameter();
		final SignLocale defaultSignLocale = readDefaultSignLocale(I18NAccess.I18N.getLocale());

		signWritingService = (SignWritingServiceAsync) GWT.create(SignWritingService.class);
		final AuthenticationServiceAsync authenticationService = signWritingService;
		final DocumentServiceAsync documentService = signWritingService;
		final DictionaryServiceAsync dictionaryService = signWritingService;
		final PdfServiceAsync pdfService = signWritingService;
		final VideoServiceAsync videoService = signWritingService;
		final MediaUrlServiceAsync mediaUrlService = signWritingService;
		final SymbolServiceAsync symbolService = signWritingService;
		final CaptchaValidationServiceAsync captchaValidationService = signWritingService;
		final LoggingServiceAsync loggingService = signWritingService;
		userService = (UserServiceAsync) signWritingService;
		localSessionService = new LocalSessionServiceImpl(signWritingService, authenticationService);
		final BadgeServiceAsync badgeService = signWritingService;
		final ContentReportServiceAsync contentReportService = signWritingService;
		final NotificationServiceAsync notificationService = signWritingService;

		// Components
		final URLConverter urlConverter = new URLConverterClientImpl();
		final FontSizeService fontSizeService = new FontSizeServiceImpl();
		final BadgeServiceClient badgeServiceClient = new BadgeServiceClientImpl(badgeService, localSessionService);
		DelegsBadgeType.initialize();
		hasJustEstablishedValidSession = false;

		browserHistoryService = new BrowserHistoryServiceImpl(localSessionService, documentService, urlConverter);
		localSessionService.setLocalSessionServiceListener(createLocalSessionServiceListener());

		signWritingInitializationService = new SignWritingInitializer(defaultSignLocale, authenticationService,
				documentService, dictionaryService, pdfService, videoService, mediaUrlService, symbolService,
				captchaValidationService, userService, loggingService, browserHistoryService, localSessionService,
				urlConverter, fontSizeService, createPasswordForgottenDialogBox(), badgeServiceClient,
				contentReportService, notificationService);

		initBundle();
	}

	private I18N readLocaleParameter() {
		I18N result = I18NAccess.I18N_DE;
		String localeParameter = Location.getParameter("locale");

		for (I18N i18nOption : I18NAccess.I18N_OPTIONS) {
			if (i18nOption.getLocale().name().equalsIgnoreCase(localeParameter)) {
				result = i18nOption;
				break;
			}
		}
		return result;
	}

	private SignLocale readDefaultSignLocale(I18NLocale locale) {
		assert locale != null : "Precondition failed: locale != null";

		SignLocale result;

		String signLocaleParameter = Location.getParameter("signlocale");
		switch (locale) {
		case EN:
			result = SignLocale.ASL;
			break;
		case BR:
			result = SignLocale.LIBRAS;
			break;
		case FR:
			result = SignLocale.LSF;
			break;
		case ES:
			result = SignLocale.LSE;
			break;
		case DE:
		default:
			result = SignLocale.DGS;
		}

		if (signLocaleParameter != null) {
			for (SignLocale signLocale : SignLocale.values()) {
				if (signLocaleParameter.equalsIgnoreCase(signLocale.name())) {
					result = signLocale;
					break;
				}
			}
		}

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	private LogonListener createLocalSessionServiceListener() {
		return new LogonListener() {

			@Override
			public void onLoginFailed(String errorMessage) {
				assert initBundle != null : "Precondition failed: initBundle != null -> initBundle needs to be received from the server";
				createLoginDialogBox(initBundle, errorMessage);
			}

			@Override
			public void onLogin() {
				hasJustEstablishedValidSession = true;
				browserHistoryService.navigateToUrl(Location.getHref());
			}
		};
	}

	private void initBundle() {
		signWritingService
				.getInitBundle(new SignWritingCallback<InitBundle>(I18NAccess.I18N.getErrorOnInitialisingIds()) {

					@Override
					public void onSuccess(InitBundle bundle) {
						initBundle = bundle;
						handleSuccessfullInitialization(initBundle);
					}
				});
	}

	protected void handleSuccessfullInitialization(final InitBundle initBundle) {
		BrowserHistoryService.BrowserHistoryListener browserHistoryListener = createBrowserHistoryListener(initBundle);
		browserHistoryService.setBrowserHistoryListener(browserHistoryListener);
		((BrowserHistoryServiceImpl) browserHistoryService).init();
		browserHistoryService.navigateToUrl(Location.getHref());
	}

	private BrowserHistoryService.BrowserHistoryListener createBrowserHistoryListener(final InitBundle initBundle) {
		return new BrowserHistoryService.BrowserHistoryListener() {

			@Override
			public void onFolderItemRequested(FolderItem folderItem) {
				handleFileItemRequested(initBundle, folderItem, null);
			}

			@Override
			public void onDocumentItemRequested(FolderItem parentFolderOfDocumentItem, DocumentItem documentItem) {
				handleFileItemRequested(initBundle, parentFolderOfDocumentItem, documentItem);
			}

			@Override
			public void onDefaultFileItemRequested() {
				handleDefaultFileItemRequested(initBundle);
			}

			@Override
			public void onFileItemAccessDenied() {
				createLoginDialogBox(initBundle);
			}

			@Override
			public void onSessionInvalid() {
				handleDefaultFileItemRequested(initBundle);
			}
		};
	}

	protected void createLoginDialogBox(InitBundle initBundle, String errorMessage) {
		final PasswordForgottenDialogBox passwordForgottenDialogBox = createPasswordForgottenDialogBox();
		LoginDialogBox loginDialogBox = new LoginDialogBox(I18N.getLoginRequired(),
				createLoginDialogBoxListener(initBundle, passwordForgottenDialogBox), errorMessage);
		loginDialogBox.center();
		loginDialogBox.setFocusUsernameTextBox();
	}

	private void createLoginDialogBox(final InitBundle initBundle) {
		final PasswordForgottenDialogBox passwordForgottenDialogBox = createPasswordForgottenDialogBox();
		LoginDialogBoxListener loginDialogListener = createLoginDialogBoxListener(initBundle,
				passwordForgottenDialogBox);
		LoginDialogBox loginDialogBox = new LoginDialogBox(I18N.getLoginRequired(), loginDialogListener);
		loginDialogBox.center();
		loginDialogBox.setFocusUsernameTextBox();
	}

	private LoginDialogBoxListener createLoginDialogBoxListener(final InitBundle initBundle,
			final PasswordForgottenDialogBox passwordForgottenDialogBox) {
		LoginDialogBoxListener loginDialogListener = new LoginDialogBox.LoginDialogBoxListener() {

			@Override
			public void onLogin(String username, String password) {
				localSessionService.login(username, password);
			}

			@Override
			public void onClose() {
				handleDefaultFileItemRequested(initBundle);
			}

			@Override
			public void onPasswordForgotten() {
				passwordForgottenDialogBox.center();
				passwordForgottenDialogBox.focusUsernameOrEmailAddressTextBox();
			}
		};
		return loginDialogListener;
	}

	private void handleFileItemRequested(final InitBundle initBundle, FolderItem parentFolderOfDocumentItem,
			DocumentItem startDocumentItem) {
		signWritingInitializationService.startEditor(initBundle, parentFolderOfDocumentItem,
				startDocumentItem, hasJustEstablishedValidSession);
	}

	private void handleDefaultFileItemRequested(final InitBundle initBundle) {
		signWritingInitializationService.startEditor(initBundle, null, null, hasJustEstablishedValidSession);
	}

	@Deprecated
	private PasswordForgottenDialogBox createPasswordForgottenDialogBox() {
		PasswordForgottenValidator passwordForgottenValidator = new PasswordForgottenValidator();
		return new PasswordForgottenDialogBox(passwordForgottenValidator) {

			@Override
			public void handlePasswordForgotten(String usernameOrEmailAddress) {
				assert usernameOrEmailAddress != null : "Precondition failed: usernameOrEmailAddress != null";

				final PasswordForgottenDialogBox passwordForgottenDialogBox = this;
				AsyncCallback<Boolean> callback = new AsyncCallback<Boolean>() {

					@Override
					public void onSuccess(Boolean result) {
						if (result) {
							passwordForgottenDialogBox.hide();
							new MessageDialogBox(I18N.getPasswordForgotten() + "?", I18N.getPasswordForgottenSentMail())
									.center();
						} else {
							passwordForgottenDialogBox.setErrorMessage(I18N.getPasswordForgottenInputInvalid(), true);
						}
					}

					@Override
					public void onFailure(Throwable caught) {
						passwordForgottenDialogBox.setErrorMessage(I18N.getPasswordForgottenInputInvalid(), true);
					}
				};
				userService.sendPasswordForgottenEmail(usernameOrEmailAddress, callback);
			}
		};
	}
}
