package de.signWritingEditor.server.service.sessionService;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

import de.signWritingEditor.shared.model.material.SessionKey;

public class SessionKeyFactory {

	private Set<SessionKey> assignedKeys;
	private final SessionKey unknownUserSessionKey;
	private final SessionKey systemUserSessionKey;
	private SecureRandom random;

	public SessionKeyFactory() {
		this.random = new SecureRandom();
		assignedKeys = new HashSet<SessionKey>();
		unknownUserSessionKey = createSessionKey();
		systemUserSessionKey = createSessionKey();

		assignedKeys.add(unknownUserSessionKey);
		assignedKeys.add(systemUserSessionKey);
	}

	public SessionKey createSessionKey() {
		SessionKey sessionKey;
		do {
			sessionKey = new SessionKey(createRandomKeyId());

		} while (!assignedKeys.add(sessionKey));

		return sessionKey;
	}

	private long createRandomKeyId() {
		long key;
		key = random.nextLong();

		return key;
	}

	public void removeFromAssignedKeys(SessionKey sessionKey) {
		assignedKeys.remove(sessionKey);
	}

	public boolean isKeyAssigned(SessionKey sessionKey) {
		return assignedKeys.contains(sessionKey);
	}

	public SessionKey getUnknownUserSessionKey() {
		return unknownUserSessionKey;
	}

	public SessionKey getSystemUserSessionKey() {
		return systemUserSessionKey;
	}

}
