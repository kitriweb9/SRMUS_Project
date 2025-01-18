import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Setting {
	private static final int SERVER_PORT;
	private static final int POLLING_TIME;

	static {
		Properties setting = getSetting();
		SERVER_PORT = Integer.parseInt(setting.getProperty("SEND_PORT"));
		POLLING_TIME = Integer.parseInt(setting.getProperty("FILE_SERVER_POLLING")) * 1_000;
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
	}
	public static int getServerPort() {
		return SERVER_PORT;
	}

	public static int getPollingTime() {
		return POLLING_TIME;
	}

	public static String getStoreSendPath(String storeId) {
		return getSetting().getProperty("FILE_SERVER_FOLDER_PATH") +  "SHQ/" + storeId + "/send/";
	}

}
