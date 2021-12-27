package de.signWritingEditor.infrastructure;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.signWritingEditor.client.service.LoggingServiceAsync;

public class LoggingServiceAsyncMock implements LoggingServiceAsync {

	@Override
	public void logMissingCharacter(char c, String documentName, AsyncCallback<Void> callback) {
	}
}
