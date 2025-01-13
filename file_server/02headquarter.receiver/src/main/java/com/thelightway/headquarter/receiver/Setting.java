package com.thelightway.headquarter.receiver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.thelightway.headquarter.receiver.dao.DBInfo;

public class Setting {
	private static final String SETTING_FILE_PATH = "hq.setting";
	private static final int SERVER_PORT;
	private static final int POLLING_TIME;
	private static final String TESS_DATA_PATH;

	static {
		Properties setting = getSetting();
		SERVER_PORT = Integer.parseInt(setting.getProperty("RECV_PORT"));
		POLLING_TIME = Integer.parseInt(setting.getProperty("FILE_SERVER_POLLING")) * 1_000;
		TESS_DATA_PATH = setting.getProperty("TESSDATA_PATH");
	}

	private static Properties getSetting() {
		Properties setting = new Properties();
		try (FileInputStream in = new FileInputStream(System.getProperty("user.dir") + "/hq.setting")) {
			setting.load(in);
		} catch (IOException e) {
			printMsgNotFoundSetting();
		}
		return setting;
	}

	private static void printMsgNotFoundSetting() {
		System.out.println("본부 설정 파일이 없거나 읽는데 오류가 발생했습니다.");
		System.out.println("본부 설정 파일 경로: " + SETTING_FILE_PATH);
	}
	public static int getServerPort() {
		return SERVER_PORT;
	}

	public static int getPollingTime() {
		return POLLING_TIME;
	}

	public static String getStoreReceivePath(String storeId) {
        
		return getSetting().getProperty("FILE_SERVER_FOLDER_PATH") + "SHQ/" + storeId + "/receive/";
	}
	
	public static String getTessDataPath() {
		return TESS_DATA_PATH;
	}
	
	public static DBInfo getDBInfo() {
		Properties setting = getSetting();
		
		return new DBInfo(setting.getProperty("DB_URL"), setting.getProperty("DB_USER_NAME"), setting.getProperty("DB_USER_PASSWORD"));
	}

}
