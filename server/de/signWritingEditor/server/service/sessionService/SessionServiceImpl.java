package de.signWritingEditor.server.service.sessionService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import de.signWritingEditor.client.service.InvalidSessionException;
import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.shared.model.material.ExpiryDate;
import de.signWritingEditor.shared.model.material.SessionKey;
import de.signWritingEditor.shared.model.material.User;
import de.signWritingEditor.shared.model.material.UserSession;

public class SessionServiceImpl implements SystemSessionService {
	private Map<SessionKey, UserSession> sessionKeyUserSessionMap;
	private SessionKeyFactory sessionKeyFactory;
	private final String SESSION_VALIDITY_KEY = "esf.session.expiryTimeMillis";
	private final long SESSION_VALIDITY_IN_MILLISECONDS;
	private UserSession systemUserSession;

	public SessionServiceImpl(ConfigurationService configurationService) {
		SESSION_VALIDITY_IN_MILLISECONDS = Long.valueOf(configurationService.getProperty(SESSION_VALIDITY_KEY));
		this.sessionKeyUserSessionMap = new HashMap<SessionKey, UserSession>();
		this.sessionKeyFactory = new SessionKeyFactory();

		SessionKey systemUserSessionKey = sessionKeyFactory.getSystemUserSessionKey();
		systemUserSession = new UserSession(User.getSystemUser(), systemUserSessionKey, ExpiryDate.endless());
		sessionKeyUserSessionMap.put(systemUserSession.getSessionKey(), systemUserSession);
	}

	@Override
	public User getUser(SessionKey sessionKey) throws InvalidSessionException {
		UserSession userSession = sessionKeyUserSessionMap.get(sessionKey);
		if (userSession == null) {
			throw new InvalidSessionException();
		}
		return userSession.getUser();
	}

	@Override
	public UserSession createUnknownUserSession() {
		UserSession unknownUserSession = new UserSession(User.getUnknownUser(), sessionKeyFactory.createSessionKey(),
				ExpiryDate.now().plusMilliseconds(SESSION_VALIDITY_IN_MILLISECONDS));

		sessionKeyUserSessionMap.put(unknownUserSession.getSessionKey(), unknownUserSession);

		return unknownUserSession;
	}

	@Override
	public UserSession getSystemUserSession() {
		return systemUserSession;
	}

	@Override
	public UserSession createStandardUserSession(User user) {
		assert user != null : "Precondition failed: userSession != null";

		UserSession userSession = new UserSession(user, sessionKeyFactory.createSessionKey(),
				ExpiryDate.now().plusMilliseconds(SESSION_VALIDITY_IN_MILLISECONDS));

		sessionKeyUserSessionMap.put(userSession.getSessionKey(), userSession);

		return userSession;
	}

	@Override
	public boolean isUserSessionValid(SessionKey sessionKey) {
		assert sessionKey != null : "Precondition failed: sessionKey != null";

		return sessionKeyUserSessionMap.containsKey(sessionKey)
				&& isNotExpired(sessionKeyUserSessionMap.get(sessionKey));
	}

	private boolean isNotExpired(UserSession userSession) {
		return userSession.getExpiryTime().isInFuture();
	}

	@Override
	public void invalidateSession(SessionKey sessionKey) {
		assert !isSystemUserSessionKey(sessionKey) : "Precondition failed: !isSystemUserSessionKey(sessionKey)";

		sessionKeyFactory.removeFromAssignedKeys(sessionKey);
		sessionKeyUserSessionMap.remove(sessionKey);
	}

	private boolean isSystemUserSessionKey(SessionKey sessionKey) {
		return sessionKey.equals(systemUserSession.getSessionKey());
	}

	private boolean isUnknownUserSessionKey(SessionKey sessionKey) {
		return sessionKeyUserSessionMap.get(sessionKey).getUser().isUnknown();
	}

	public void removeExpiredUserSessions() {
		Set<SessionKey> sessionKeysToRemoveSet = new HashSet<>();
		for (Entry<SessionKey, UserSession> entry : sessionKeyUserSessionMap.entrySet()) {
			if (!isNotExpired(entry.getValue())) {
				sessionKeysToRemoveSet.add(entry.getKey());
			}
		}

		for (SessionKey sessionKey : sessionKeysToRemoveSet) {
			sessionKeyUserSessionMap.remove(sessionKey);
			sessionKeyFactory.removeFromAssignedKeys(sessionKey);
		}
	}
}
