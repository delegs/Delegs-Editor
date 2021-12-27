package de.signWritingEditor.client.model.material;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;

import org.junit.Test;

import de.signWritingEditor.shared.model.domainValue.SignLocale;
import de.signWritingEditor.shared.model.domainValue.UserRole;
import de.signWritingEditor.shared.model.material.AuthoredObject;
import de.signWritingEditor.shared.model.material.User;

public class AuthoredObjectTest {

	@Test
	public void testValidValues() {
		User author = new User("username", "firstname", "lastname", null,
				Arrays.asList(new UserRole[] { UserRole.USER }), 1);
		AuthoredObject ao = new AuthoredObjectDummy(author, SignLocale.DGS);
		assertEquals(author, ao.getAuthor());
		assertEquals("DGS", ao.getSignLocale().name());
		assertEquals(ao, new AuthoredObjectDummy(author, SignLocale.DGS));
		assertEquals(ao.hashCode(), new AuthoredObjectDummy(author, SignLocale.DGS).hashCode());
	}

	@Test
	public void testInvalidValues() {
		try {
			new AuthoredObjectDummy(null, SignLocale.DGS);
			fail("NULL as owner accepted!");
		} catch (AssertionError ae) {
			assertTrue(ae.getMessage().contains("author != null"));
		}

		try {
			new AuthoredObjectDummy(new User("", "", "", null, Arrays.asList(new UserRole[] { UserRole.USER }), 1),
					null);
			fail("NULL as region accepted!");
		} catch (AssertionError ae) {
			assertTrue(ae.getMessage().contains("signLocale != null"));
		}

		try {
			new AuthoredObjectDummy(new User("", "", "", null, Arrays.asList(new UserRole[] { UserRole.USER }), 1),
					SignLocale.DGS).setAuthor(null);
			fail("NULL as owner accepted!");
		} catch (AssertionError ae) {
			assertTrue(ae.getMessage().contains("owner != null"));
		}

		try {
			new AuthoredObjectDummy(new User("", "", "", null, Arrays.asList(new UserRole[] { UserRole.USER }), 1),
					SignLocale.DGS).setRegion(null);
			fail("NULL as region accepted!");
		} catch (AssertionError ae) {
			assertTrue(ae.getMessage().contains("signLocale != null"));
		}
	}

	// inner class

	private final class AuthoredObjectDummy extends AuthoredObject {
		private static final long serialVersionUID = 1L;

		private AuthoredObjectDummy(User author, SignLocale language) {
			super(author, language);
		}
	}

}
