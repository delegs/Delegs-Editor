package de.signWritingEditor.server.service.sessionService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;

import org.junit.Test;

import de.signWritingEditor.client.service.InvalidSessionException;
import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.shared.model.domainValue.UserRole;
import de.signWritingEditor.shared.model.material.EmailAddress;
import de.signWritingEditor.shared.model.material.SessionKey;
import de.signWritingEditor.shared.model.material.User;
import de.signWritingEditor.shared.model.material.UserSession;

public class SessionServiceImplTest {

	private static final String SESSION_TIMEOUT_MILLIS = "1";
	private SessionServiceImpl sessionService;
	private SessionServiceImpl sessionServiceWithMinimalTimeout;

	public SessionServiceImplTest() throws IOException {
		sessionService = new SessionServiceImpl(new ConfigurationService("/ESFConfig_Junit.properties"));
		sessionServiceWithMinimalTimeout = new SessionServiceImpl(new ConfigurationServiceTimeoutMock());
	}

	@Test
	public void testGetUnknownUserSession() {
		assertTrue(sessionService.createUnknownUserSession().getUser().isUnknown());
	}

	@Test
	public void testGetSystemUserSession() {
		User system = sessionService.getSystemUserSession().getUser();
		assertEquals("system", system.getUsername());
	}

	@Test
	public void testCreatedSessionContainsCorrectUser() {
		User system = sessionService.getSystemUserSession().getUser();
		UserSession session = sessionService.createStandardUserSession(system);
		try {
			User user = sessionService.getUser(session.getSessionKey());
			assertSame(system, user);
		} catch (InvalidSessionException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testInvalidateSession() {
		User user = new User("Testi", "Test", "Testmann", new EmailAddress("testmann@test.de"),
				Arrays.asList(UserRole.USER), 1);
		UserSession session = sessionService.createStandardUserSession(user);
		SessionKey key = session.getSessionKey();

		assertTrue(sessionService.isUserSessionValid(key));
		sessionService.invalidateSession(key);
		assertFalse(sessionService.isUserSessionValid(key));
	}

	@Test
	public void testRemoveExpiredUserSessions() {
		// Prepare
		User user = new User("Testi", "Test", "Testmann", new EmailAddress("testmann@test.de"),
				Arrays.asList(UserRole.USER), 1);
		UserSession userSession = sessionServiceWithMinimalTimeout.createStandardUserSession(user);
		SessionKey sessionKey = userSession.getSessionKey();

		// Action
		try {
			Thread.sleep(5);
		} catch (InterruptedException e1) {
			fail(e1.getMessage());
		}

		sessionServiceWithMinimalTimeout.removeExpiredUserSessions();

		// Check
		try {
			Field mapField = sessionServiceWithMinimalTimeout.getClass().getDeclaredField("sessionKeyUserSessionMap");
			mapField.setAccessible(true);
			@SuppressWarnings("unchecked")
			Map<SessionKey, UserSession> sessionKeyUserSessionMap = (Map<SessionKey, UserSession>) mapField
					.get(sessionServiceWithMinimalTimeout);

			assertFalse(sessionKeyUserSessionMap.containsValue(userSession));
			assertFalse(sessionKeyUserSessionMap.containsKey(sessionKey));

		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			fail(e.getMessage());
		}
	}

	private class ConfigurationServiceTimeoutMock extends ConfigurationService {

		public ConfigurationServiceTimeoutMock() throws IOException {
		}

		@Override
		public String getProperty(String key) {
			if (key == "esf.session.expiryTimeMillis") {
				return SESSION_TIMEOUT_MILLIS;
			}
			return super.getProperty(key);
		}

	}
}
