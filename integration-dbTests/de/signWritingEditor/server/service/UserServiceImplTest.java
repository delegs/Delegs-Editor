package de.signWritingEditor.server.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.server.persistence.DbConnector;
import de.signWritingEditor.server.persistence.PasswordHashUtil;
import de.signWritingEditor.server.persistence.UserDb;
import de.signWritingEditor.shared.model.domainValue.UserRole;
import de.signWritingEditor.shared.model.material.EmailAddress;
import de.signWritingEditor.shared.model.material.User;

public class UserServiceImplTest {

	private DbConnector connector;
	private UserDb userDB;
	private UserServiceImpl userService;
	private String userName = "delegsTestChangePW";
	private String userNameWithoutPassword = "delegsTestWithoutPassword";

	private String oldPassword = "oldPassword";
	private String newPassword = "newPassword";
	private EmailAddress mailAddress = new EmailAddress("testChangePWMail@delegs.de");
	private User user = new User(userName, "delegs", "", mailAddress, Arrays.asList(new UserRole[] { UserRole.USER }),
			1);
	private User userWithoutEmailAddress = new User(userNameWithoutPassword, "delegs", "", null,
			Arrays.asList(new UserRole[] { UserRole.USER }), 1);

	@Before
	public void setUp() throws IOException {
		ConfigurationService configurationService = new ConfigurationService("/ESFConfig_Junit.properties");
		connector = new DbConnector(configurationService);
		userDB = new UserDb(connector);
		userService = new UserServiceImpl(userDB, new SendEmailService(configurationService));
	}

	@After
	public void tearDown() throws IOException {

		if (userDB.existsUsername(userName)) {
			userDB.delete(user);
		}

		if (userDB.existsUsername(userNameWithoutPassword)) {
			userDB.delete(userWithoutEmailAddress);
		}

		connector = null;

	}

	@Test
	public void testChangePasswordByUserName() {

		userDB.saveUser(user, PasswordHashUtil.hash(oldPassword));
		userDB.activateUser(user);
		assertTrue(userService.changePassword(userName, newPassword));
		assertTrue(userDB.isValidCredential(userName, newPassword));

	}

	@Test
	public void testChangePasswordByUserNameNotActivated() {

		userDB.saveUser(user, PasswordHashUtil.hash(oldPassword));

		assertTrue(userService.changePassword(userName, newPassword));
		assertTrue(userDB.isValidCredential(userName, newPassword));

	}

	@Test
	public void testChangePasswordByMailAddress() {

		userDB.saveUser(user, PasswordHashUtil.hash(oldPassword));
		userDB.activateUser(user);
		assertTrue(userService.changePassword(mailAddress.asString(), newPassword));
		assertTrue(userDB.isValidCredential(userName, newPassword));

	}

	@Test
	public void testChangePasswordByUnknownUsername() {

		assertFalse(userService.changePassword(userName, newPassword));
		assertFalse(userDB.isValidCredential(userName, newPassword));
	}

	@Test
	public void testGetUserByUsername() {
		userDB.saveUser(user, "testPasswor");
		userDB.activateUser(user);

		assertEquals(user, userService.getUserByUsernameOrMail(userName));
	}

	@Test
	public void testGetUserByMailAddress() {
		userDB.saveUser(user, "testPassword");
		userDB.activateUser(user);

		assertEquals(user, userService.getUserByUsernameOrMail(mailAddress.asString()));
	}

	@Test
	public void testGetUserNotActivated() {
		userDB.saveUser(user, "testPassword");

		assertEquals(user, userService.getUserByUsernameOrMail(userName));
		assertEquals(user, userService.getUserByUsernameOrMail(mailAddress.asString()));
	}

	@Test
	public void testGetUserByUnknownUsername() {
		assertNull(userService.getUserByUsernameOrMail("DasIstEinUserNameDenEsNichtGebenSollte.123456"));
	}

	@Test
	public void testGetUserByUnknownMailAddress() {
		assertNull(userService.getUserByUsernameOrMail("DasIstEineEmailAddresseDieEsNichtGebenSollte@delegs.de"));
	}

	@Test
	public void testGetUserFromUserWithoutMailAddress() {
		userDB.saveUser(userWithoutEmailAddress, "password");
		userDB.activateUser(userWithoutEmailAddress);

		assertEquals(userWithoutEmailAddress, userService.getUserByUsernameOrMail(userNameWithoutPassword));
	}

	@Test
	public void testExistsUsername() {
		userDB.saveUser(user, "test");

		assertTrue(userService.existsUsername(userName));
		assertFalse(userService.existsUsername("EinAndererUsername"));
	}

	@Test
	public void testExistsEmailAddress() {
		userDB.saveUser(user, newPassword);

		assertTrue(userService.existsEmailAddress(mailAddress.asString()));
		assertFalse(userService.existsEmailAddress("EIneAndereNichtExistenteEmailAddresse@beidelegs.de"));
	}

	@Test
	public void testExistsUserByUserNameOrMail() {
		assertFalse(userService.existsUserByUserNameOrMail(user.getUsername()));
		assertFalse(userService.existsUserByUserNameOrMail(user.getEmailAddress().asString()));

		userDB.saveUser(user, newPassword);

		assertTrue(userService.existsUserByUserNameOrMail(user.getUsername()));
		assertTrue(userService.existsUserByUserNameOrMail(user.getEmailAddress().asString()));

	}
}
