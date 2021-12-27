package de.signWritingEditor.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.signWritingEditor.shared.infrastructure.InitBundle;

// GWT remote asyncronous interface
public interface SignWritingServiceAsync extends FontMetricGenerationServiceAsync, LoggingServiceAsync,
		DictionaryServiceAsync, DocumentServiceAsync, PdfServiceAsync, AuthenticationServiceAsync, SymbolServiceAsync,
		CaptchaValidationServiceAsync, UserServiceAsync, VideoServiceAsync, MediaUrlServiceAsync, SessionServiceAsync,
		BadgeServiceAsync, ContentReportServiceAsync, NotificationServiceAsync {
	void getInitBundle(AsyncCallback<InitBundle> callback);

}
