package de.signWritingEditor.client.model.material;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;

import org.junit.Test;

import de.signWritingEditor.shared.model.domainValue.UserRole;
import de.signWritingEditor.shared.model.material.EmailAddress;
import de.signWritingEditor.shared.model.material.User;

public class UserTest {

	@Test
	public void testValidValues() {
		User emptyUser = new User("", "", "", null, Arrays.asList(new UserRole[] {}), 1);
		assertEquals(emptyUser.getUsername(), "");
		assertEquals(emptyUser.getFirstName(), "");
		assertEquals(emptyUser.getLastName(), "");
		assertNull(emptyUser.getEmailAddress());
		assertEquals(emptyUser, new User("", "", "", null, Arrays.asList(new UserRole[] {}), 1));
		assertEquals(emptyUser.getRoles(), Arrays.asList(new UserRole[] {}));
		assertEquals(emptyUser.hashCode(), new User("", "", "", null, Arrays.asList(new UserRole[] {}), 1).hashCode());

		User user = new User("TestUser", "Test", "User", new EmailAddress("donot@email.de"),
				Arrays.asList(new UserRole[] { UserRole.USER }), 1);
		assertEquals(user.getUsername(), "TestUser");
		assertEquals(user.getFirstName(), "Test");
		assertEquals(user.getLastName(), "User");
		assertEquals(user.getEmailAddress(), new EmailAddress("donot@email.de"));
		assertEquals(user, new User("TestUser", "Test", "User", new EmailAddress("donot@email.de"),
				Arrays.asList(new UserRole[] { UserRole.USER }), 1));
		assertEquals(user.getRoles(), Arrays.asList(new UserRole[] { UserRole.USER }));
		assertEquals(user.hashCode(), new User("TestUser", "Test", "User", new EmailAddress("donot@email.de"),
				Arrays.asList(new UserRole[] { UserRole.USER }), 1).hashCode());
	}

	@Test
	public void testInvalidValues() {
		try {
			new User(null, "", "", null, Arrays.asList(new UserRole[] {}), 1);
			fail("NULL as username accepted!");
		} catch (AssertionError ae) {
			assertTrue(ae.getMessage().contains("username != null"));
		}

		try {
			new User("", null, "", null, Arrays.asList(new UserRole[] { UserRole.USER }), 1);
			fail("NULL as firstname accepted!");
		} catch (AssertionError ae) {
			assertTrue(ae.getMessage().contains("firstName != null"));
		}

		try {
			new User("", "", null, null, Arrays.asList(new UserRole[] { UserRole.USER }), 1);
			fail("NULL as lastname accepted!");
		} catch (AssertionError ae) {
			assertTrue(ae.getMessage().contains("lastName != null"));
		}

		try {
			new User("", "", "", null, Arrays.asList(new UserRole[] { UserRole.USER }), 1).setFirstName(null);
			fail("NULL as firstname accepted!");
		} catch (AssertionError ae) {
			assertTrue(ae.getMessage().contains("firstName != null"));
		}

		try {
			new User("", "", "", null, Arrays.asList(new UserRole[] { UserRole.USER }), 1).setLastName(null);
			fail("NULL as lastname accepted!");
		} catch (AssertionError ae) {
			assertTrue(ae.getMessage().contains("lastName != null"));
		}
	}

	@Test
	public void testValidNames() {
		assertFalse(User.isValidName("Hallo<Mein>NameIstPeter"));
		assertFalse(User.isValidName(""));
		assertFalse(User.isValidName(" "));
		assertTrue(User.isValidName("Hallo NameIstPeter"));
		assertFalse(User.isValidName(" Hallo NameIstPeter"));
		assertFalse(User.isValidName(null));
		assertFalse(User.isValidName("Hallo<NameIst>Peter"));
		assertFalse(User.isValidName("Peter!"));
		assertFalse(User.isValidName("Peter?"));
		assertFalse(User.isValidName("Peter/"));
		assertFalse(User.isValidName("Peter_"));
		assertTrue(User.isValidName("Peter-"));
	}

	@Test
	public void testValidUserNames() {
		assertFalse(User.isValidUsername("Hallo<Mein>NameIstPeter"));
		assertTrue(User.isValidUsername("HalloMeinNameIstPeter"));
		assertTrue(User.isValidUsername("0123HalloMeinNameIstPeter"));
		assertFalse(User.isValidUsername("Hallo MeinNameIstPeter"));
		assertFalse(User.isValidUsername(""));
		assertFalse(User.isValidUsername(
				"HalloMeinNameIstPeterHalloMeinNameIstPeterHalloMeinNameIstPeterHalloMeinNameIstPeterHalloMeinNameIstPeterHalloMeinNameIstPeterHalloMeinNameIstPeterHalloMeinNameIstPeterHalloMeinNameIstPeterHalloMeinNameIstPeterHalloMeinNameIstPeterHalloMeinNameIstPeterHalloMeinNameIstPeterHalloMeinNameIstPeterHalloMeinNameIstPeterHalloMeinNameIstPeterHalloMeinNameIstPeterHalloMeinNameIstPeterHalloMeinNameIstPeterHalloMeinNameIstPeter"));
		assertFalse(User.isValidUsername("krz"));
		assertFalse(User.isValidUsername("unknown"));
		assertFalse(User.isValidUsername("UNknown"));
		assertTrue(User.isValidUsername("UNbeknownst"));

		assertFalse(User.isValidName("Peter!"));
		assertFalse(User.isValidName("Peter?"));
		assertFalse(User.isValidName("Peter/"));
		assertFalse(User.isValidName("Peter_"));
		assertTrue(User.isValidName("Peter-"));
	}

	@Test
	public void testToString() {
		User user = new User("Spiderman", "Peter", "Parker", new EmailAddress("donot@email.de"),
				Arrays.asList(new UserRole[] { UserRole.USER }), 1);

		assertEquals("User [username=Spiderman, firstName=Peter, lastName=Parker, email=donot@email.de, roles={USER}]",
				user.toString());
	}

	@Test
	public void testEquals() {
		User user = new User("test", "testname", "testLastName", new EmailAddress("testmail@email.de"),
				Arrays.asList(new UserRole[] { UserRole.USER }), 1);
		User same = new User("test", "testname", "testLastName", new EmailAddress("testmail@email.de"),
				Arrays.asList(new UserRole[] { UserRole.USER }), 1);
		User other1 = new User("testDiff", "testname", "testLastName", new EmailAddress("testmail@email.de"),
				Arrays.asList(new UserRole[] { UserRole.USER }), 1);
		User other2 = new User("test", "testnameDiff", "testLastName", new EmailAddress("testmail@email.de"),
				Arrays.asList(new UserRole[] { UserRole.USER }), 1);
		User other3 = new User("test", "testname", "testLastNameDiff", new EmailAddress("testmail@email.de"),
				Arrays.asList(new UserRole[] { UserRole.USER }), 1);
		User other4 = new User("test", "testname", "testLastName", new EmailAddress("testmailDiff@email.de"),
				Arrays.asList(new UserRole[] { UserRole.USER }), 1);

		assertEquals(user, same);
		assertFalse(user.equals(other1));
		assertTrue(user.equals(other2));
		assertTrue(user.equals(other3));
		assertTrue(user.equals(other4));
		assertFalse(other1.equals(other2));
		assertFalse(other1.equals(other3));
		assertFalse(other1.equals(other4));
		assertTrue(other2.equals(other3));
		assertTrue(other2.equals(other4));
		assertTrue(other3.equals(other4));
	}
}