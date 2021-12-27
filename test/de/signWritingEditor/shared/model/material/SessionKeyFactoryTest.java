package de.signWritingEditor.shared.model.material;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.server.service.sessionService.SessionKeyFactory;

public class SessionKeyFactoryTest {

	private SessionKeyFactory _keyFactory;

	@Before
	public void setUp() throws Exception {
		_keyFactory = new SessionKeyFactory();
	}

	@Test
	public void testCreateSessionKey_isNotNull() {
		// Action
		SessionKey sessionKey = _keyFactory.createSessionKey();

		// Check
		assertNotNull(sessionKey);
	}

	@Test
	public void testCreateSessionKey_multipleKeysCreated_KeysAreUnique() {
		// Prepare
		int numberOfKeys = 1000;

		// Action
		Set<SessionKey> sessionKeys = createSessionKeySet(numberOfKeys);

		// Check
		assertEquals(numberOfKeys, sessionKeys.size());
	}

	@Test
	public void testIsKeyAssigned_multipleKeysCreated_KeysAssigned() {
		// Prepare
		SessionKey sessionKey1 = _keyFactory.createSessionKey();
		SessionKey sessionKey2 = _keyFactory.createSessionKey();
		SessionKey sessionKey3 = _keyFactory.createSessionKey();

		// Action
		boolean isSessionKey1Assigned = _keyFactory.isKeyAssigned(sessionKey1);
		boolean isSessionKey2Assigned = _keyFactory.isKeyAssigned(sessionKey2);
		boolean isSessionKey3Assigned = _keyFactory.isKeyAssigned(sessionKey3);

		// Check
		assertTrue(isSessionKey1Assigned);
		assertTrue(isSessionKey2Assigned);
		assertTrue(isSessionKey3Assigned);
	}

	@Test
	public void testIsKeyAssigned_defaultSessionKeysAssigned() {
		// Check
		assertTrue(_keyFactory.isKeyAssigned(_keyFactory.getSystemUserSessionKey()));
		assertTrue(_keyFactory.isKeyAssigned(_keyFactory.getUnknownUserSessionKey()));
	}

	@Test
	public void testRemoveFromAssignedKeys_multipleKeysCreated_KeyRemoved() {
		// Prepare
		SessionKey sessionKey1 = _keyFactory.createSessionKey();
		SessionKey sessionKey2 = _keyFactory.createSessionKey();
		SessionKey sessionKeyToBeRemoved = _keyFactory.createSessionKey();
		_keyFactory.removeFromAssignedKeys(sessionKeyToBeRemoved);
		assertFalse(_keyFactory.isKeyAssigned(sessionKeyToBeRemoved));

		// Action
		_keyFactory.removeFromAssignedKeys(sessionKeyToBeRemoved);

		// Check
		assertFalse(_keyFactory.isKeyAssigned(sessionKeyToBeRemoved));
		assertTrue(_keyFactory.isKeyAssigned(sessionKey1));
		assertTrue(_keyFactory.isKeyAssigned(sessionKey2));
	}

	@Test
	public void testRemoveFromAssignedKeys_removeAllKeys_NoExceptionThrown() {
		// Prepare
		int numberOfKeys = 10;
		Set<SessionKey> sessionKeys = createSessionKeySet(numberOfKeys);

		// Action, Check
		for (SessionKey sessionKey : sessionKeys) {
			_keyFactory.removeFromAssignedKeys(sessionKey);
		}
	}

	@Test
	public void testRemoveFromAssignedKeys_UnassignedKeyRemoved_OtherKeysStillAssigned() {
		// Prepare
		int numberOfKeys = 10;
		Set<SessionKey> sessionKeys = createSessionKeySet(numberOfKeys);
		SessionKey sessionKey = _keyFactory.createSessionKey();

		// Action
		_keyFactory.removeFromAssignedKeys(sessionKey);

		// Check
		assertEquals(numberOfKeys, sessionKeys.size());
		assertFalse(_keyFactory.isKeyAssigned(sessionKey));
	}

	private Set<SessionKey> createSessionKeySet(int numberOfKeys) {
		Set<SessionKey> sessionKeys = new HashSet<SessionKey>();
		for (int i = 0; i < numberOfKeys; i++) {
			sessionKeys.add(_keyFactory.createSessionKey());
		}
		return sessionKeys;
	}
}
