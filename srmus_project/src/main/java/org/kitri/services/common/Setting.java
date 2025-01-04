package org.kitri.services.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Setting {
	private static final String HQ_SETTING_FILE_PATH = System.getProperty("user.dir") + "/hq.setting";
	private static final String STORE_SETTING_FILE_PATH = System.getProperty("user.dir") + "/store.setting";
	private static final Properties STORE_SETTING; 
	static {
		STORE_SETTING = getSetting();
		
	}
	
	private static Properties getSetting() {
		Properties setting = new Properties();
		try (FileInputStream in = new FileInputStream(HQ_SETTING_FILE_PATH)) {
			setting.load(in);
		} catch (IOException e) {
			printMsgNotFoundSetting();
		}
		return setting;
	}
	private static void printMsgNotFoundSetting() {
		System.out.println("설정 파일이 없거나 읽는데 오류가 발생했습니다.");
	}
	
	public static String getStoreId() {
		return STORE_SETTING.getProperty("STORE_ID");
	}
	
	public static String getStoreFileSendPath() {
		File file = new File(STORE_SETTING.getProperty("FILE_SERVER_FOLDER_PATH") + getStoreId() + "/send/");
		if(file.exists()) {
			file.mkdirs();
		}
		return file.getAbsolutePath();
	}
}
