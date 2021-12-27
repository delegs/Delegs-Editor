package de.signWritingEditor.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.signWritingEditor.shared.model.material.SessionKey;
import de.signWritingEditor.shared.model.material.UserSession;

public interface SessionServiceAsync {

	public void createUnknownUserSession(AsyncCallback<UserSession> callback);

	public void isUserSessionValid(SessionKey sessionKey, AsyncCallback<Boolean> callback);
}
