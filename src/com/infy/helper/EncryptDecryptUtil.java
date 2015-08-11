/**
 * 
 */
package com.infy.helper;

import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This call is used to develop the encryption logic to encrypt user password
 * 
 * @author AvinashVaidya
 *
 */
public class EncryptDecryptUtil {

	private static Logger LOGGER = LoggerFactory.getLogger(EncryptDecryptUtil.class);
	private static String algorithm = "DESede";
	public static Key symKey = null;
	public static Cipher cipher = null;

	static {
		try {
			symKey = KeyGenerator.getInstance(algorithm).generateKey();
			cipher = Cipher.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("Error in EncryptDecryptUtil: " + e);
		} catch (NoSuchPaddingException e) {
			LOGGER.error("Error in EncryptDecryptUtil: " + e);
		}
	}

	public static byte[] encryptString(String input) throws Exception {
		cipher.init(Cipher.ENCRYPT_MODE, symKey);
		byte[] inputBytes = input.getBytes();
		return cipher.doFinal(inputBytes);
	}

}
