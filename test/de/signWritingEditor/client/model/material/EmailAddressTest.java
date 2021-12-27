package de.signWritingEditor.client.model.material;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.signWritingEditor.shared.model.material.EmailAddress;

public class EmailAddressTest {

	@Test
	public void testInvalidValues() {

		assertFalse(EmailAddress.isValidAddressFormat("emailinformatik.de"));
		assertFalse(EmailAddress.isValidAddressFormat("email/@informatik.de"));
		assertFalse(EmailAddress.isValidAddressFormat("email@info/rmatik.de"));
		assertFalse(EmailAddress.isValidAddressFormat("email@informatik.dededede"));
		assertFalse(EmailAddress.isValidAddressFormat("email@informatik.2de"));
		assertFalse(EmailAddress.isValidAddressFormat("email@informatik.e"));
		assertTrue(EmailAddress.isValidAddressFormat("email@informatik.de"));

	}

	@Test
	public void testToString() {
		EmailAddress testEmailAddress = new EmailAddress("test@delegs.de");
		assertEquals(testEmailAddress.toString(), "test@delegs.de");
	}

	@Test
	public void testAsString() {
		EmailAddress testEmailAddress = new EmailAddress("test@delegs.de");
		assertEquals(testEmailAddress.asString(), "test@delegs.de");
	}

	@Test
	public void testEquals() {
		EmailAddress testEmailAddress = new EmailAddress("test@delegs.de");
		EmailAddress sameEmailAddress = new EmailAddress("test@delegs.de");
		EmailAddress otherEmailAddress = new EmailAddress("testete@delegs.de");

		assertEquals(testEmailAddress, sameEmailAddress);
		assertFalse(testEmailAddress.equals(otherEmailAddress));
	}

	@Test
	public void testHashCode() {
		assertTrue(new EmailAddress("delegs@delegs.de").hashCode() == new EmailAddress("delegs@delegs.de").hashCode());
	}

}
