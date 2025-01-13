package com.thelightway.store.receiver;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;
import java.util.Properties;

import com.thelightway.store.receiver.dao.ReceiverDao;
import com.thelightway.store.receiver.dao.SvcComItT;


public class StoreReceiver {
	private final String SERVER_IP;
	private final int SERVER_PORT;
	private final String RECEIVE_PATH;

	private final String STORE_ID; 
	private final SvcComItT IMG_CONVERTER;
	private final ReceiverDao DAO;
	
	private InputStream socketInput;
	private OutputStream socketOutput;
	
	private StoreReceiver() {
		Properties setting = getSetting();
		STORE_ID = setting.getProperty("STORE_ID");
		RECEIVE_PATH = setting.getProperty("FILE_SERVER_FOLDER_PATH") + "SSM/"+ STORE_ID + "/receive/";
		SERVER_IP = setting.getProperty("SERVER_IP");
		SERVER_PORT = Integer.parseInt(setting.getProperty("RECV_PORT"));
		IMG_CONVERTER = new SvcComItT(setting.getProperty("TESSDATA_PATH"));
		DAO = new ReceiverDao();
	}
	
	
	public static void main(String[] args) {
		new StoreReceiver().start();
	}
	
	private void connect() {
		System.out.println("== 본부 서버 연결 시도 ==");
		try {
			Socket socket = new Socket(SERVER_IP, SERVER_PORT);
			socketInput = socket.getInputStream();
			socketOutput = socket.getOutputStream();
			System.out.println("본부 연결 성공");
		} catch (IOException e) {
			System.out.println("소켓 연결 실패");
		}
	}
	
	
	private void sendText(String msg) {
		PrintWriter printWriter = new PrintWriter(socketOutput, true);
		printWriter.println(msg);
	}

	
	private Properties getSetting() {
        Properties setting = new Properties();
		try (FileInputStream in = new FileInputStream(System.getProperty("user.dir") + "/store.setting")) {
        	setting.load(in);
        } catch (IOException e) {
			System.out.println("매장 설정 파일이 없거나 읽을 수 없습니다");
		}

		return setting;
	}


	public void start() {
		System.out.println("매장 수신 모듈 켜짐");
		connect();
		sendText(STORE_ID);
		try (BufferedReader input = new BufferedReader(new InputStreamReader(socketInput))) {
			while (true) {
				try {
					String filename = input.readLine();
					if (filename == null) { break;	}
					
					long fileSize = Long.parseLong(input.readLine());
					
					File file = new File(RECEIVE_PATH + filename);
					createParentDir(file);
					receiveFile(fileSize, file);
				} catch (IOException | NumberFormatException e) {
					System.err.println("파일 수신 중 오류: " + e.getMessage());
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void receiveFile(long fileSize, File file) throws IOException, FileNotFoundException {
		try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
			byte[] buffer = new byte[4096];
			long bytesReadTotal = 0;

			while (bytesReadTotal < fileSize) {
				int bytesRead = socketInput.read(buffer);
				if (bytesRead == -1) {
					throw new IOException("파일 전송 중 연결이 끊어졌습니다.");
				}
				fileOutputStream.write(buffer, 0, bytesRead);
				bytesReadTotal += bytesRead;
			}

			System.out.println("파일 수신 완료: " + file.getName());
		}
		
		
		System.out.println("파일변환 실행");
		Map<String, String> keyAndValues = IMG_CONVERTER.extractTextFromImage(file.getPath());
		
		
		if(file.getName().toLowerCase().startsWith("i")) {
			System.out.println("DB 기록 - 입고");

			System.out.println(DAO.saveData(keyAndValues));
			
		}
		//파일 삭제
		try {
			System.out.println("삭제전 10초 대기");
			Thread.sleep(10_000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(file.getPath());
		file.delete();
		
	}

	private File createParentDir(File file) {
		File parentDir = file.getParentFile();
		if (!parentDir.exists()) {
			parentDir.mkdirs();
		}
		return parentDir;
	}
}
