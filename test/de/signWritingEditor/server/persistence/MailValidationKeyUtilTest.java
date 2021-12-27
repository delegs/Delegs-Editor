package de.signWritingEditor.server.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;

import org.junit.Test;

import de.signWritingEditor.shared.model.domainValue.UserRole;
import de.signWritingEditor.shared.model.material.EmailAddress;
import de.signWritingEditor.shared.model.material.User;

public class MailValidationKeyUtilTest {

	@Test
	public void testgetValidationKeyForUser() {
		User user = new User("validationKeyTestUser", "test", "validationKey",
				new EmailAddress("testValidationKey@test.de"), Arrays.asList(new UserRole[] { UserRole.USER }), 1);
		User userWithSameEmailAdrress = new User("validationKey", "testUser", "delegs",
				new EmailAddress("testValidationKey@test.de"), Arrays.asList(new UserRole[] { UserRole.USER }), 1);
		String validationKeyForUser = MailValidationKeyUtil.getValidationKeyForUser(user);

		User userWithDifferentMailAddress = new User("validationKey", "testUser", "delegs",
				new EmailAddress("andereMailAdresse@test.de"), Arrays.asList(new UserRole[] { UserRole.USER }), 1);

		assertEquals(validationKeyForUser, MailValidationKeyUtil.getValidationKeyForUser(userWithSameEmailAdrress));
		assertFalse(MailValidationKeyUtil.getValidationKeyForUser(userWithSameEmailAdrress)
				.equals(userWithDifferentMailAddress));
	}
}
