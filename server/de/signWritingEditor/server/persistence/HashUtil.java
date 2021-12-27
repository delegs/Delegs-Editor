package de.signWritingEditor.server.persistence;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {

	public static final String SHA_256_ALGORITHM = "SHA-256";

	/**
	 * Testmethod if SHA256 Algorithm exist
	 * 
	 * @return true, if SHA256 can be used for hashing‚
	 */
	public static boolean isWorking() {
		return isWorkingInternal(SHA_256_ALGORITHM);
	}

	protected static boolean isWorkingInternal(String algorithm) {
		try {
			MessageDigest.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			return false;
		}
		return true;
	}

	public static byte[] hash(byte[] bytesToHash, String hashAlgorithm) {
		try {
			MessageDigest hasher = MessageDigest.getInstance(hashAlgorithm);
			return hasher.digest(bytesToHash);

		} catch (Exception e) {
			throw new RuntimeException("Hashing not available", e);
		}

	}

	/*
	 * From: Convert a byte array to a Hex string
	 * http://rgagnon.com/javadetails/java-0596.html
	 * 
	 * @param byte[] b byteArray
	 */
	protected static String byteArrayToHexString(byte[] b) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < b.length; i++) {
			result.append(Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1));
		}
		return result.toString();
	}
}
