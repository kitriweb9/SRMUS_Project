package org.kitri.services.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Setting {
	private static final String SETTING_PATH = "D:/SRMUS/store.setting";
	private static final Properties STORE_SETTING;
	
	static {
		STORE_SETTING = getSetting();
	}
	
	private static Properties getSetting() {
		Properties setting = new Properties();
		try (FileInputStream in = new FileInputStream(new File(SETTING_PATH))) {
			setting.load(in);
		} catch (IOException e) {
			printMsgNotFoundSetting();
		}
		return setting;
	}
	private static void printMsgNotFoundSetting() {
		System.out.println("설정 파일이 없거나 읽는데 오류가 발생했습니다.");
		System.out.println(SETTING_PATH);
	}
	
	public static String getStoreId() {
		return STORE_SETTING.getProperty("STORE_ID");
	}
	
	public static String getSsmFileSendPath(String storeId) {
		File file = new File(STORE_SETTING.getProperty("FILE_SERVER_FOLDER_PATH") + "SSM/" + storeId + "/send/");
		if(!file.exists()) {
			file.mkdirs();
		}
		return file.getPath();
	}
	public static String getShqFileSendPath(String storeId) {
		File file = new File(STORE_SETTING.getProperty("FILE_SERVER_FOLDER_PATH") + "SHQ/" + storeId + "/send/");
		if(!file.exists()) {
			file.mkdirs();
		}
		return file.getPath();
	}
}
