package de.signWritingEditor.server.persistence;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PasswortHashUtilTest {

	@Test
	public void testIsWorking() {
		assertTrue(PasswordHashUtil.isWorking());
		assertTrue(PasswordHashUtil.isWorkingInternal(PasswordHashUtil.SHA_256_ALGORITHM));
		assertFalse(PasswordHashUtil.isWorkingInternal("Unknown algorithm"));
	}

	@Test()
	public void testHash() {
		assertTrue(PasswordHashUtil.hash("password")
				.equals("5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8"));
		assertFalse(PasswordHashUtil.hash("peter")
				.equals("5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8"));
		assertTrue(PasswordHashUtil.hash("peter")
				.equals("026ad9b14a7453b7488daa0c6acbc258b1506f52c441c7c465474c1a564394ff"));
	}

}
