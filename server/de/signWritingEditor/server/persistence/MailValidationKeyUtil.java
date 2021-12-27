package de.signWritingEditor.server.persistence;

import de.signWritingEditor.shared.model.material.User;

public class MailValidationKeyUtil extends HashUtil {

	public static final byte[] VALIDATION_SALT = new byte[] { 125, 16, -93, -109, -62, -102, 105, 94, -55, 5, 126, 35,
			2, -1, 72, 45, -112, 49, 121, -65, -128, 125, 77, -71, -57, -87, 23, -98, 3, -116, 56, -66 };

	public static String getValidationKeyForUser(User user) {
		assert user != null : "Precondition failed: user != null";
		assert user.hasEmailAddress() : "Precondition failed: user.hasEmailAddress()";

		byte[] emailAsBytes = user.getEmailAddress().asString().getBytes();

		byte[] mailAndSalt = new byte[emailAsBytes.length + VALIDATION_SALT.length];

		for (int i = 0; i < emailAsBytes.length; i++) {
			mailAndSalt[i] = emailAsBytes[i];
		}
		for (int i = 0; i < VALIDATION_SALT.length; i++) {
			mailAndSalt[i + emailAsBytes.length] = VALIDATION_SALT[i];
		}

		return byteArrayToHexString(hash(mailAndSalt, SHA_256_ALGORITHM));
	}
}
