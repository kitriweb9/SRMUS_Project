
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class StoreSender {
	private final Properties SETTING;
	private InputStream in;
	private OutputStream out;

	public StoreSender(String settingPath) {
		SETTING = getSetting(settingPath);
		File sendFolder = new File(SETTING.getProperty("FILE_SERVER_FOLDER_PATH") + "SSM/" + SETTING.getProperty("STORE_ID") + "/send/");
		if (!sendFolder.exists()) {
			sendFolder.mkdirs();
		}
	}


	public void sendFile(List<File> sendFiles) {
		if (sendFiles.size() == 0) {
			return;
		}

		byte[] buffer = new byte[4096];
		int bytesRead;
		for (File f : sendFiles) {
			sendText(f.getName());
			sendText(f.length());
			System.out.println("파일 전송: " + f.getName());
			try (FileInputStream fileInputStream = new FileInputStream(f)) {
				while ((bytesRead = fileInputStream.read(buffer)) != -1) {
					out.write(buffer, 0, bytesRead);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			f.delete();
			waitTime(10_000);
		}
	}
	private void waitTime(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private List<File> getSendFile() {
		File sendFolder = new File(SETTING.getProperty("FILE_SERVER_FOLDER_PATH")  + "SSM/" + SETTING.getProperty("STORE_ID") + "/send/");
		List<File> pngFiles = new ArrayList<>();
		if (sendFolder.isDirectory()) {
			File[] files = sendFolder.listFiles();

			if (files != null) {
				for (File f : files) {
					if (f.isFile() && f.getName().toLowerCase().endsWith(".png")) {
						pngFiles.add(f);
					}
				}
			}
		}
		return pngFiles;
	}

	@SuppressWarnings("resource")
	private void connect() {
		System.out.println("== 본부 서버 연결 시도 ==");
		try {

			Socket socket = new Socket(SETTING.getProperty("SERVER_IP"), Integer.parseInt(SETTING.getProperty("SEND_PORT")));
			in = socket.getInputStream();
			out = socket.getOutputStream();
			System.out.println("본부 연결 성공");
		} catch (IOException e) {
			System.out.println("소켓 연결 실패");
		}
	}

	private void sendText(Object msg) {
		PrintWriter printWriter = new PrintWriter(out, true);
		printWriter.println(msg);
	}

	private Properties getSetting(String settingPath) {
		Properties setting = new Properties();
		try (FileInputStream in = new FileInputStream(System.getProperty("user.dir") + "/store.setting")) {
			setting.load(in);
		} catch (FileNotFoundException e) {
			System.out.println("매장 설정 파일이 없습니다");
			System.out.println("설정 파일 경로: "+ settingPath);
		} catch (IOException e) {
			System.out.println("매장 설정 파일을 읽을 수 없습니다.");
			System.out.println("설정 파일 경로: "+ settingPath);
		}
		return setting;
	}


	public void start() {
		System.out.println("매장 송신 모듈 켜짐");
		connect();
		sendText(SETTING.getProperty("STORE_ID"));
		while (true) {
			try {
				Thread.sleep(Integer.parseInt(SETTING.getProperty("FILE_SERVER_POLLING")) * 1_000);
				List<File> sendFile = getSendFile();
				sendFile(sendFile);
			} catch (InterruptedException e) {
				System.out.println("Interrupted");
			}
		}
	}
}
