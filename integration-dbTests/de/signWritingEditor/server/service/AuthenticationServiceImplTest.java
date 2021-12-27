package de.signWritingEditor.server.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.client.service.AuthenticationService;
import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.UserDb;
import de.signWritingEditor.server.service.sessionService.SessionServiceImpl;
import de.signWritingEditor.shared.model.domainValue.UserRole;
import de.signWritingEditor.shared.model.material.EmailAddress;
import de.signWritingEditor.shared.model.material.User;

public class AuthenticationServiceImplTest {

	private DbConnector connector;
	private UserDb userDB;
	private SessionServiceImpl sessionService;

	@Before
	public void setUp() throws IOException {
		ConfigurationService configurationService = new ConfigurationService("/ESFConfig_Junit.properties");
		connector = new DbConnector(configurationService);
		userDB = new UserDb(connector);
		sessionService = new SessionServiceImpl(configurationService);
	}

	@After
	public void tearDown() {
		connector = null;
	}

	@Test
	public void testLogin() throws IOException {
		SendEmailService emailService = new SendEmailService(new ConfigurationService("/ESFConfig_Junit.properties"));
		AuthenticationService authenticationService = new AuthenticationServiceImpl(userDB, sessionService,
				emailService);
		User user = new User("delegsTestLogin", "delegs", "", new EmailAddress("testLogin@delegs.de"),
				Arrays.asList(new UserRole[] { UserRole.USER }), 1);

		if (userDB.existsUserWithName(user)) {
			userDB.delete(user);
		}

		// password is defined in de_junit as a sha256 hash
		userDB.registerUser(user, "passwort");
		User notActivatedUserSession = authenticationService.login(user.getUsername(), "passwort").getUser();
		// User 1 is not yet activated so the session he will get is the unknown
		// UserSession
		assertNotEquals(notActivatedUserSession, user);
		assertEquals(User.getUnknownUser(), notActivatedUserSession);

		assertTrue(userDB.activateUser(user));

		// User 1 is activated, so he can do the login now and will get his user
		// back
		assertEquals(user, authenticationService.login(user.getUsername(), "passwort").getUser());

		// User types a wrong password or username and gets the unknown
		// userSession
		assertEquals(User.getUnknownUser(), authenticationService.login(user.getUsername(), "passwort2").getUser());
		assertEquals(User.getUnknownUser(),
				authenticationService.login(user.getUsername() + "1", "passwort").getUser());
	}
}
