package de.signWritingEditor.client.service;

import de.signWritingEditor.shared.model.material.SessionKey;
import de.signWritingEditor.shared.model.material.UserSession;

public interface SessionService {

	public UserSession createUnknownUserSession();

	public boolean isUserSessionValid(SessionKey sessionKey);
}
