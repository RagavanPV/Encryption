package com.ragavan.pbkdf2;

import java.util.UUID;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.math.BigInteger;

public class PBKDF2{
	private static final int ITERATIONS = 1000;
	private static final int KEY_LENGTH = 192; // bits

	public static String hashPassword(String password, String salt) throws InvalidKeySpecException {
		char[] passwordChars = password.toCharArray();
		byte[] saltBytes = salt.getBytes();
		byte[] hashedPassword = null;

		PBEKeySpec spec = new PBEKeySpec(passwordChars, saltBytes, ITERATIONS, KEY_LENGTH);
		SecretKeyFactory key;
		try {
			key = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			hashedPassword = key.generateSecret(spec).getEncoded();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return String.format("%x", new BigInteger(hashedPassword));
	}

	public static void main(String[] args) throws Exception {
		System.out.println(hashPassword("password", "salt"));
		if (hashPassword("password", "salt").equals("6e88be8bad7eae9d9e10aa061224034fed48d03fcbad968b"))
			System.out.println("true");
	}
}