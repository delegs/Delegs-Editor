package de.signWritingEditor.server.service.sessionService;

import de.signWritingEditor.client.service.InvalidSessionException;
import de.signWritingEditor.client.service.SessionService;
import de.signWritingEditor.shared.model.material.SessionKey;
import de.signWritingEditor.shared.model.material.User;
import de.signWritingEditor.shared.model.material.UserSession;

public interface SystemSessionService extends SessionService {

	UserSession getSystemUserSession();

	UserSession createStandardUserSession(User user);

	void invalidateSession(SessionKey sessionKey);

	User getUser(SessionKey sessionKey) throws InvalidSessionException;
}
