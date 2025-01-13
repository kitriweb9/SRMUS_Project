package com.thelightway.headquarter.receiver.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Set;

import com.thelightway.headquarter.receiver.Setting;
import com.thelightway.headquarter.receiver.dao.ReceiverDao;
import com.thelightway.headquarter.receiver.dao.SvcComItT;

public class SysComShqFieRcv {
	private final SvcComItT IMG_CONVERTER;
	private final ReceiverDao DAO;

	public SysComShqFieRcv(String settingPath) {
		IMG_CONVERTER = new SvcComItT(Setting.getTessDataPath());
		DAO = new ReceiverDao(Setting.getDBInfo());
	}

	public static void main(String[] args) {
		String settingFile = System.getProperty("user.dir") + "/hq.setting";
		SysComShqFieRcv headquterReceiver = new SysComShqFieRcv(settingFile);
		headquterReceiver.start();
	}

	public void start() {
		try (ServerSocket serverSocket = new ServerSocket(Setting.getServerPort())) {
			System.out.println("본부 수신 서버가 시작되었습니다. " + "연결 대기 중...");

			while (true) {
				Socket socket = serverSocket.accept();
				BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String connectMessage = input.readLine();
				if (connectMessage != null) {
					StoreSever storeSever = new StoreSever(connectMessage, socket);
					Thread clientThread = new Thread(storeSever);
					System.out.println("매장이 연결되었습니다.");
					System.out.println("매장 ID: " + connectMessage);
					System.out.println();
					clientThread.start();
				}
			}
		} catch (IOException e) {
			System.err.println("매장과 통신 오류: " + e.getMessage());
		}

	}

	private class StoreSever implements Runnable {
		private final String RECEIVE_PATH;
		private final String STORE_ID;
		private InputStream socketInput;
		private OutputStream socketOutput;

		public StoreSever(String storeId, Socket socket) {
			this.STORE_ID = storeId;
			RECEIVE_PATH = Setting.getStoreReceivePath(storeId);
			System.out.println("수신 폴더 경로: " + RECEIVE_PATH);
			createFolderIfNotExist(new File(RECEIVE_PATH));
			try {
				this.socketInput = socket.getInputStream();
				this.socketOutput = socket.getOutputStream();
			} catch (IOException e) {
				System.err.println("소켓 입력 스트림 초기화 중 오류: " + e.getMessage());
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			try (BufferedReader input = new BufferedReader(new InputStreamReader(socketInput))) {

				while (true) {
					waitTime(Setting.getPollingTime());

					String filename = input.readLine();
					if (filename == null) {
						break;
					}

					long fileSize = Long.parseLong(input.readLine());
					File file = new File(RECEIVE_PATH + filename);
					receiveFile(file, filename, fileSize);

					System.out.println("파일변환 실행");
					Map<String, String> keyAndValues = IMG_CONVERTER.extractTextFromImage(file.getPath());

					saveToDatabase(file, keyAndValues);
				}
			} catch (IOException e) {
				System.err.println("클라이언트와의 연결 종료: " + e.getMessage());
			} finally {
				try {
					socketInput.close();
					socketOutput.close();
					System.out.println("매장 연결이 종료되었습니다: " + STORE_ID);
				} catch (IOException e) {
					System.err.println("소켓 종료 중 오류: " + e.getMessage());
				}
			}
		}

		private void receiveFile(File file, String filename, long fileSize) throws IOException, FileNotFoundException {
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

				socketOutput.write(1);

				System.out.println("파일 수신 완료: " + filename);

			}
		}

		private void createFolderIfNotExist(File folder) {
			if (!folder.exists()) {
				folder.mkdirs();
			}
		}

		private void saveToDatabase(File file, Map<String, String> keyAndValues) {
			System.out.println(" == 데이터 베이스 기록 == ");
			Set<String> keySet = keyAndValues.keySet();
			for (String string : keySet) {
				System.out.println(string);
			}
			
			int saveResult = DAO.saveData(keyAndValues);
			System.out.println("기록된 행수 = " + saveResult);

			file.delete();
			waitTime(2_000);
		}

		private void waitTime(int time) {
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
