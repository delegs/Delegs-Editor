package de.signWritingEditor.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import de.signWritingEditor.shared.infrastructure.InitBundle;

// GWT remote interface
@RemoteServiceRelativePath("signwritingservice")
public interface SignWritingService
		extends RemoteService, LoggingService, FontMetricGenerationService, DictionaryService, DocumentService,
		PdfService, AuthenticationService, SymbolService, CaptchaValidationService, UserService, VideoService,
		MediaUrlService, SessionService, BadgeService, ContentReportService, NotificationService {
	InitBundle getInitBundle();

}