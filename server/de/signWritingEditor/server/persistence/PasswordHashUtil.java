package de.signWritingEditor.server.persistence;

import java.io.UnsupportedEncodingException;

public class PasswordHashUtil extends HashUtil {

	/**
	 * Hash a given string with SHA256 algorithm
	 * 
	 * @param password
	 *            String
	 * @return the hashed password
	 */
	public static String hash(String password) {
		assert password != null : "Precondition failed: password != null";

		return hashInternal(password);
	}

	protected static String hashInternal(String password) {
		try {
			byte[] hash = hash(password.getBytes("UTF-8"), SHA_256_ALGORITHM);

			return byteArrayToHexString(hash);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("Hashing not available", e);
		}
	}
}
