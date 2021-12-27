package de.signWritingEditor.client.service.infrastructure;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.signWritingEditor.client.service.SessionServiceAsync;
import de.signWritingEditor.shared.model.material.SessionKey;
import de.signWritingEditor.shared.model.material.UserSession;

public class SessionServiceAsyncMock implements SessionServiceAsync {
	@Override
	public void createUnknownUserSession(AsyncCallback<UserSession> callback) {
	}

	@Override
	public void isUserSessionValid(SessionKey sessionKey, AsyncCallback<Boolean> callback) {
	}
}
