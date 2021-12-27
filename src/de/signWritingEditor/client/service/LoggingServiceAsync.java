package de.signWritingEditor.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoggingServiceAsync {

	void logMissingCharacter(char c, String documentName, AsyncCallback<Void> callback);

}
