package org.kitri.system.encryption;

public class HexConverter {
	public String byteToHexString(byte[] data) {		
		StringBuilder builder = new StringBuilder();
		for(byte b : data) {
			builder.append(Integer.toString((b&0xff)+0x100,16).substring(1));
		}
		return builder.toString();
	}
	public byte[] hexToByteArray(String str) {
	    int len = str.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4)
	                + Character.digit(str.charAt(i + 1), 16));
	    }
	    return data;
	}
}
