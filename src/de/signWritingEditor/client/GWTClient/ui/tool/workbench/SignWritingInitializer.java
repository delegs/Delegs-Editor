package de.signWritingEditor.client.GWTClient.ui.tool.workbench;

import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.ui.RootPanel;

import de.signWritingEditor.client.GWTClient.ui.tool.subtools.fileManagement.PasswordForgottenDialogBox;
import de.signWritingEditor.client.badge.gwtClient.service.BadgeServiceClient;
import de.signWritingEditor.client.service.AuthenticationServiceAsync;
import de.signWritingEditor.client.service.BrowserHistoryService;
import de.signWritingEditor.client.service.CaptchaValidationServiceAsync;
import de.signWritingEditor.client.service.ContentReportServiceAsync;
import de.signWritingEditor.client.service.DictionaryServiceAsync;
import de.signWritingEditor.client.service.DocumentServiceAsync;
import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.client.service.LocalSessionService;
import de.signWritingEditor.client.service.LoggingServiceAsync;
import de.signWritingEditor.client.service.MediaUrlServiceAsync;
import de.signWritingEditor.client.service.NotificationServiceAsync;
import de.signWritingEditor.client.service.PdfServiceAsync;
import de.signWritingEditor.client.service.SymbolServiceAsync;
import de.signWritingEditor.client.service.UserServiceAsync;
import de.signWritingEditor.client.service.VideoServiceAsync;
import de.signWritingEditor.shared.infrastructure.InitBundle;
import de.signWritingEditor.shared.infrastructure.URLConverter;
import de.signWritingEditor.shared.layout.GWTFontMetric;
import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.VersionNumber;
import de.signWritingEditor.shared.model.material.DocumentItem;
import de.signWritingEditor.shared.model.material.FolderItem;
import de.signWritingEditor.shared.model.material.RoomItem;

public final class SignWritingInitializer {

    private final SignLocale defaultSignLocale;
    private final AuthenticationServiceAsync authenticationService;
    private final DocumentServiceAsync documentService;
    private final DictionaryServiceAsync dictionaryService;
    private final PdfServiceAsync pdfService;
    private final VideoServiceAsync videoService;
    private final MediaUrlServiceAsync mediaUrlService;
    private final SymbolServiceAsync symbolService;
    private final CaptchaValidationServiceAsync captchaValidationService;
    private final UserServiceAsync userService;
    private final LoggingServiceAsync loggingService;
    private final BrowserHistoryService browserHistoryService;
    private final LocalSessionService localSessionService;
    private final URLConverter urlConverter;
    private final FontSizeService fontSizeService;
    private final PasswordForgottenDialogBox passwordForgottenDialogBox;
    private final BadgeServiceClient badgeService;
    private final NotificationServiceAsync notificationService;
    private ContentReportServiceAsync contentReportService;

    public SignWritingInitializer(final SignLocale defaultSignLocale,
                                  final AuthenticationServiceAsync authenticationService, final DocumentServiceAsync documentService,
                                  final DictionaryServiceAsync dictionaryService, final PdfServiceAsync pdfService,
                                  final VideoServiceAsync videoService, final MediaUrlServiceAsync mediaUrlService,
                                  final SymbolServiceAsync symbolService, final CaptchaValidationServiceAsync captchaValidationService,
                                  final UserServiceAsync userService, final LoggingServiceAsync loggingService,
                                  BrowserHistoryService browserHistoryService, LocalSessionService localSessionService,
                                  URLConverter urlConverter, FontSizeService fontSizeService,
                                  PasswordForgottenDialogBox passwordForgottenDialogBox, BadgeServiceClient badgeService,
                                  ContentReportServiceAsync contentReportService, NotificationServiceAsync notificationService) {
        assert pdfService != null : "Precondition failed: pdfService != null";
        assert videoService != null : "Precondition failed: videoService != null";
        assert mediaUrlService != null : "Precondition failed: mediaUrlService != null";
        assert dictionaryService != null : "Precondition failed: dictionaryService != null";
        assert documentService != null : "Precondition failed: documentService != null";
        assert symbolService != null : "Precondition failed: symbolService != null";
        assert authenticationService != null : "Precondition failed: authenticationService != null";
        assert captchaValidationService != null : "Precondition failed: captchaValidationService != null";
        assert userService != null : "Precondition failed: userService != null";
        assert loggingService != null : "Precondition failed: loggingService != null";
        assert defaultSignLocale != null : "Precondition failed: defaultSignLocale != null";
        assert browserHistoryService != null : "Precondition failed: browserHistoryService != null";
        assert localSessionService != null : "Precondition failed: localSessionService != null";
        assert urlConverter != null : "Precondition failed: urlConverter != null";
        assert fontSizeService != null : "Precondition failed: fontSizeService != null";
        assert badgeService != null : "Precondition failed: badgeService != null";
        assert notificationService != null : "Precondition failed: notificationService != null";

        this.defaultSignLocale = defaultSignLocale;
        this.authenticationService = authenticationService;
        this.documentService = documentService;
        this.dictionaryService = dictionaryService;
        this.pdfService = pdfService;
        this.videoService = videoService;
        this.mediaUrlService = mediaUrlService;
        this.symbolService = symbolService;
        this.captchaValidationService = captchaValidationService;
        this.userService = userService;
        this.loggingService = loggingService;
        this.browserHistoryService = browserHistoryService;
        this.localSessionService = localSessionService;
        this.urlConverter = urlConverter;
        this.fontSizeService = fontSizeService;
        this.passwordForgottenDialogBox = passwordForgottenDialogBox;
        this.badgeService = badgeService;
        this.contentReportService = contentReportService;
        this.notificationService = notificationService;
    }

    public void startEditor(InitBundle initBundle, FolderItem parentFolderOfDocumentItem,
                            DocumentItem documentItem, boolean hasJustEstablishedValidSession) {
        fontSizeService.setMetric(new GWTFontMetric());
        fontSizeService.setFontMetrics(initBundle.getFontMetrics());

        initEditor(parentFolderOfDocumentItem, documentItem, initBundle.getIdSeed(), initBundle.getRootRoomItem(),
                initBundle.getBackgroundImageName(), initBundle.getVersionNumber(),
                initBundle.getPrivacyPolicyVersionNumber(), hasJustEstablishedValidSession);

    }

    private void initEditor(FolderItem parentFolderOfDocumentItem, DocumentItem documentItem, Long uniqueNumber,
                            RoomItem rootRoomItem, String backgroundImageName, VersionNumber versionNumber,
                            int privacyPolicyVersionNumber, boolean hasJustEstablishedValidSession) {
        assert uniqueNumber != null : "Precondition failed: uniqueNumber != null";
        assert rootRoomItem != null : "Precondition failed: rootRoomItem != null";
        assert backgroundImageName != null : "Precondition failed: backgroundImageName != null";
        assert versionNumber != null : "Precondition failed: versionNumber != null";

        // Initialize UI
        RootPanel.get().getElement().getStyle().setOverflow(Overflow.HIDDEN);
        RootPanel.get().setSize("100%", "100%");

        // Prevent default for backspace (go back in browser history)
        RootPanel.get().addHandler(new KeyDownHandler() {

            @Override
            public void onKeyDown(KeyDownEvent event) {
                if (event.getNativeKeyCode() == KeyCodes.KEY_BACKSPACE) {
                    event.preventDefault();
                }
            }
        }, KeyDownEvent.getType());
        RootPanel.get().sinkEvents(Event.ONKEYDOWN);

        String applicationTitle = Window.getTitle();

        Workbench workbench = new Workbench(authenticationService, documentService, dictionaryService, symbolService,
                pdfService, videoService, mediaUrlService, captchaValidationService, userService, loggingService,
                browserHistoryService, localSessionService, urlConverter, uniqueNumber, applicationTitle,
                parentFolderOfDocumentItem, documentItem, rootRoomItem, backgroundImageName, defaultSignLocale,
                versionNumber, privacyPolicyVersionNumber, fontSizeService, passwordForgottenDialogBox, badgeService,
                contentReportService, notificationService, hasJustEstablishedValidSession);

        // Remove loading animation from the root panel:
        RootPanel.get("loading").getElement().removeFromParent();
        RootPanel.get().add(workbench);
    }
}
