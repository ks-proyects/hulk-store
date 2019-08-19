package com.gio.hs.util;

//import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class AesCipher {

	private static final String algorithm = "AES/CBC/NoPadding";
	private static final byte[] keyValue = new byte[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c',
			'd', 'e', 'f' };
	private static final byte[] ivValue = new byte[] { 'f', 'e', 'd', 'c', 'b', 'a', '9', '8', '7', '6', '5', '4', '3',
			'2', '1', '0' };

	private static final IvParameterSpec ivspec = new IvParameterSpec(ivValue);
	private static final SecretKeySpec keyspec = new SecretKeySpec(keyValue, "AES");

	final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();

	public static String encrypt(String Data) throws Exception {
		Cipher c = Cipher.getInstance(algorithm);
		c.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
		byte[] encVal = c.doFinal(Data.getBytes());
		String encryptedValue = new Base64().encodeAsString(encVal);
		return encryptedValue;
	}

	public static String decrypt(String encryptedData) throws Exception {
		Cipher c = Cipher.getInstance(algorithm);
		c.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
		byte[] decordedValue = new Base64().decode(encryptedData);
		byte[] decValue = c.doFinal(decordedValue);
		String decryptedValue = new String(decValue);
		return decryptedValue.trim();
	}

	public static String bytesToHex(byte[] bytes) {
		char[] hexChars = new char[bytes.length * 2];
		int v;
		for (int j = 0; j < bytes.length; j++) {
			v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}

	public static String padString(String source) {
		char paddingChar = ' ';
		int size = 16;
		int x = source.length() % size;
		int padLength = size - x;

		for (int i = 0; i < padLength; i++) {
			source += paddingChar;
		}
		return source;
	}

	/**
	 * Metodo main para probar el encrypt y el decrypt
	 */
//	 public static void main(String[] args) throws Exception {
//	
//	 String password = "freddy0fh"; //
//	 String passwordEnc = AesCipher.encrypt(padString(password));
//	 String passwordDec = AesCipher.decrypt(passwordEnc);
//	
//	 System.out.println("Plain Text : " + password);
//	 System.out.println("Encrypted Text : " + passwordEnc);
//	 System.out.println("Decrypted Text : " + passwordDec);
//	 }
}
