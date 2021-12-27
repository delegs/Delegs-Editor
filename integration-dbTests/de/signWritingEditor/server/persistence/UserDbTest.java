package de.signWritingEditor.server.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.signWritingEditor.server.service.ConfigurationService;
import de.signWritingEditor.shared.model.domainValue.UserRole;
import de.signWritingEditor.shared.model.material.EmailAddress;
import de.signWritingEditor.shared.model.material.User;

public class UserDbTest {

	private UserDb userDb;
	private DbConnector connector;
	private User user;
	private User lecturer;
	private User author;

	@Before
	public void setUp() throws IOException {
		connector = new DbConnector(new ConfigurationService("/ESFConfig_Junit.properties"));
		userDb = new UserDb(connector);

		user = new User("user1", "abc", "def", new EmailAddress("user@gmail.de"), Arrays.asList(UserRole.USER), 1);
		lecturer = new User("lecturer1", "abc", "def", new EmailAddress("lecturer@gmail.de"),
				Arrays.asList(UserRole.LECTURER), 1);
		author = new User("author1", "abc", "def", new EmailAddress("author@gmail.de"), Arrays.asList(UserRole.AUTHOR),
				1);

		userDb.registerUser(user, "SafestPasswortEver");
		userDb.registerUser(lecturer, "SafestPasswortEver2");
		userDb.registerUser(author, "SafestPasswortEver3");
	}

	@After
	public void tearDown() {
		userDb.delete(user);
		userDb.delete(lecturer);
		userDb.delete(author);

		connector = null;
	}

	@Test
	public void test() {

		List<String> allUsernames = userDb.getAllUsernames();
		assertNotNull(allUsernames);
		int numberOfUsers = allUsernames.size();

		User user1 = new User("authorDbTestUser", "f", "l", new EmailAddress("authorDbTestUser@test.de"),
				Arrays.asList(new UserRole[] { UserRole.USER }), 1);
		if (userDb.existsUsername(user1.getUsername())) {
			assertTrue(userDb.delete(user1));
			numberOfUsers--;
			allUsernames = userDb.getAllUsernames();
			assertNotNull(allUsernames);
			assertEquals(numberOfUsers, allUsernames.size());
		}
		assertFalse(userDb.existsUsername(user1.getUsername()));
		assertTrue(userDb.saveUser(user1, PasswordHashUtil.hash("author1PW")));
		assertTrue(userDb.existsUserWithName(user1));
		numberOfUsers++;
		allUsernames = userDb.getAllUsernames();
		assertNotNull(allUsernames);
		assertEquals(numberOfUsers, allUsernames.size());
		assertTrue(allUsernames.contains(user1.getUsername()));

		user1.setFirstName("F");
		assertTrue(userDb.getUser(user1.getUsername()).equals(user1));
		assertTrue(userDb.saveUser(user1, PasswordHashUtil.hash("author1PW")));
		assertEquals(user1, userDb.getUser(user1.getUsername()));

		// Test case sensitivity:
		assertEquals(user1, userDb.getUser(user1.getUsername().toUpperCase()));
		assertEquals(user1, userDb.getUser(user1.getUsername().toLowerCase()));

		assertTrue(userDb.delete(user1));
		numberOfUsers--;
		allUsernames = userDb.getAllUsernames();
		assertNotNull(allUsernames);
		assertEquals(numberOfUsers, allUsernames.size());

		assertTrue(user1.getRoles().equals(Arrays.asList(new UserRole[] { UserRole.USER })));
	}

	@Test
	public void testIsUserEmailValid() {
		EmailAddress testUserEmailAddress = new EmailAddress("userDbTestTestUser@test.de");
		User testUser = new User("userDbTestTestUser", "userdbTest", "user", testUserEmailAddress,
				Arrays.asList(new UserRole[] { UserRole.USER }), 1);
		if (userDb.existsUsername(testUser.getUsername())) {
			assertTrue(userDb.delete(testUser));
		}
		assertTrue(userDb.saveUser(testUser, PasswordHashUtil.hash("password")));

		assertTrue(userDb.canUserHaveEmailAddress(testUser));
		assertTrue(userDb.isUserEmailValid(testUser));

		String secondUsername = "secondEmailUser";
		User otherUserWithSameEmail = new User(secondUsername, "Test", "Test", testUserEmailAddress,
				Arrays.asList(new UserRole[] { UserRole.USER }), 1);
		assertFalse(userDb.canUserHaveEmailAddress(otherUserWithSameEmail));
		assertFalse(userDb.isUserEmailValid(otherUserWithSameEmail));

		User otherUserWithValidEmail = new User(secondUsername, "Test", "Test",
				new EmailAddress(secondUsername + "@test.de"), Arrays.asList(new UserRole[] { UserRole.USER }), 1);
		assertTrue(userDb.canUserHaveEmailAddress(otherUserWithValidEmail));
		assertTrue(userDb.isUserEmailValid(otherUserWithValidEmail));

		User otherUserWithNullEmail = new User(secondUsername, "Test", "Test", null,
				Arrays.asList(new UserRole[] { UserRole.USER }), 1);
		assertTrue(userDb.isUserEmailValid(otherUserWithNullEmail));
	}

	@Test
	public void testIsValidCredential() throws IOException {

		User credentialTestUser = new User("credentialUser", "cred", "ibility", null,
				Arrays.asList(new UserRole[] { UserRole.USER }), 1);
		if (userDb.existsUserWithName(credentialTestUser)) {
			assertTrue(userDb.delete(credentialTestUser));
		}
		String credentialsTestPassword = "CredentialsFTW";
		userDb.saveUser(credentialTestUser, PasswordHashUtil.hash(credentialsTestPassword));

		assertTrue(userDb.isValidCredential(credentialTestUser.getUsername(), credentialsTestPassword));
		assertTrue(userDb.isValidCredential(credentialTestUser.getUsername().toUpperCase(), credentialsTestPassword));
		assertTrue(userDb.isValidCredential(credentialTestUser.getUsername().toLowerCase(), credentialsTestPassword));
		assertFalse(userDb.isValidCredential(credentialTestUser.getUsername(),
				PasswordHashUtil.hash(credentialsTestPassword)));
		assertFalse(userDb.isValidCredential("SomethingDifferent", credentialsTestPassword));
	}

	@Test
	public void testActivateUser() {
		User unactivatedUser = new User("notActivated", "not", "Activated", new EmailAddress("notActivated@test.de"),
				Arrays.asList(new UserRole[] { UserRole.USER }), 1);

		if (userDb.existsUserWithName(unactivatedUser)) {
			assertTrue(userDb.delete(unactivatedUser));
		}
		userDb.saveUser(unactivatedUser, PasswordHashUtil.hash("testPasswort"));

		assertTrue(userDb.existsUserWithName(unactivatedUser));
		assertFalse(userDb.isUserActivated(unactivatedUser));

		userDb.activateUser(unactivatedUser);
		assertTrue(userDb.isUserActivated(unactivatedUser));

	}

	@Test
	public void testChangePassword() {
		String oldPassword = "oldPassword";
		String newPassword = "newPassword";
		User user = new User("delegsTestChangePassword", "delegs", "", new EmailAddress("testChangePassword@delegs.de"),
				Arrays.asList(new UserRole[] { UserRole.USER }), 1);

		if (!userDb.existsUserWithName(user)) {
			userDb.saveUser(user, oldPassword);
			userDb.activateUser(user);
		}

		assertTrue(userDb.changePassword(user, newPassword));
		assertTrue(userDb.isValidCredential(user.getUsername(), newPassword));
		userDb.delete(user);
	}

	@Test
	public void testGetUserByEmail() {
		EmailAddress emailAddress = new EmailAddress("testChangePassword@delegs.de");
		User user = new User("delegsTestChangePassword", "delegs", "", emailAddress,
				Arrays.asList(new UserRole[] { UserRole.USER }), 1);

		assertNull(userDb.getUserByEMail(emailAddress));

		if (!userDb.existsUserWithName(user)) {
			userDb.saveUser(user, "Test");
			userDb.activateUser(user);
		}

		assertEquals(user, userDb.getUserByEMail(emailAddress));

		userDb.delete(user);
	}

	@Test
	public void testStaticUsersExist() {
		assertTrue(userDb.existsUserWithName(User.getSystemUser()));
		assertTrue(userDb.existsUserWithName(User.getDeletedUser()));
		assertTrue(userDb.existsUserWithName(User.getImportedUser()));
		assertTrue(userDb.existsUserWithName(User.getUnknownUser()));
	}

	@Test
	public void testUserRoles() {
		// prepare
		List<UserRole> userRolesUser;
		List<UserRole> userRolesLecturer;
		List<UserRole> userRolesAuthor;

		// action
		userRolesUser = userDb.getUserRoles(user.getUsername());
		userRolesLecturer = userDb.getUserRoles(lecturer.getUsername());
		userRolesAuthor = userDb.getUserRoles(author.getUsername());

		// check
		assertEquals(UserRole.USER, userRolesUser.get(0));
		assertEquals(UserRole.LECTURER, userRolesLecturer.get(0));
		assertEquals(UserRole.AUTHOR, userRolesAuthor.get(0));
	}
}
