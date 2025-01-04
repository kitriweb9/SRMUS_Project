package org.kitri.system.encryption;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncShaUtil {
	private HexConverter hc = new HexConverter();
	public String sha256(String inputText) {
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			System.out.println("NoSuchAlgorithmException");
			e.printStackTrace();
		}
		byte[] hash = digest.digest((inputText).getBytes(StandardCharsets.UTF_8));
		return hc.byteToHexString(hash);
	}
}
