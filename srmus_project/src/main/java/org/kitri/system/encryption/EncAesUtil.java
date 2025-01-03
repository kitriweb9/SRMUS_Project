package org.kitri.system.encryption;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;

/* 
 * @date 2024-12-23
 * @author Hyun
 * CTR is safer than CBC but catastrophic when it damaged
 * 
 */

@Component
public class EncAesUtil {
	public static final String FIRST_KEY = "TKATLQDLQKDLXMZL32KEYVMFKDLQPDLX";
	public static final String SECOND_KEY = "TPZJSEMZLSMS1ZLFMFEOTLSGKSMS2ZLD";

	public static String encAES256(String inputText) {
		byte[] encodedText = null;
		try {
			SecretKeySpec keySpec = new SecretKeySpec(FIRST_KEY.getBytes("UTF-8"), "AES");
			IvParameterSpec parameterSpec = new IvParameterSpec(FIRST_KEY.substring(0, 16).getBytes());
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, keySpec, parameterSpec);
			byte[] encText = cipher.doFinal(inputText.getBytes("UTF-8"));

			Encoder encoder = Base64.getEncoder();
			encodedText = encoder.encode(encText);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return HexConverter.byteToHexString(encodedText);
	}
	

	public static String decAES256(String encText) {
		String decodedText = null;
		
		try {
			SecretKeySpec keySpec = new SecretKeySpec(FIRST_KEY.getBytes("UTF-8"), "AES");
			IvParameterSpec parameterSpec = new IvParameterSpec(FIRST_KEY.substring(0, 16).getBytes());
			
			byte[] convertText = HexConverter.hexToByteArray(encText);
			Decoder decoder = Base64.getDecoder();
			byte[] decText = decoder.decode(convertText);
			
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, keySpec, parameterSpec);
			byte[] decode = cipher.doFinal(decText);
			decodedText = new String(decode, "UTF-8"); 

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return decodedText;
	}
	
	public static String encAES256Re(String decText) {
		byte[] encodedText = null;
		try {
			SecretKeySpec keySpec = new SecretKeySpec(SECOND_KEY.getBytes("UTF-8"), "AES");
			IvParameterSpec parameterSpec = new IvParameterSpec(SECOND_KEY.substring(0, 16).getBytes());
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, keySpec, parameterSpec);
			byte[] encText = cipher.doFinal(decText.getBytes("UTF-8"));

			Encoder encoder = Base64.getEncoder();
			encodedText = encoder.encode(encText);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return HexConverter.byteToHexString(encodedText);
	}
	
}
