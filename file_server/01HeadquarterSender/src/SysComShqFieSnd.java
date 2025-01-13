import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SysComShqFieSnd {
	public static void main(String[] args) {
		SysComShqFieSnd headquterSender = new SysComShqFieSnd();
		headquterSender.start();
	}

	public void start() {
		try (ServerSocket serverSocket = new ServerSocket(Setting.getServerPort())) {
			System.out.println("본부 송신 서버가 시작되었습니다. " + "연결 대기 중...");

			while (true) {
				Socket socket = serverSocket.accept();

				BufferedReader input = getSocketBufferedReader(socket);
				String storeId = input.readLine();
				if (storeId != null) {
					StoreSever storeSever = new StoreSever(storeId, socket);
					Thread clientThread = new Thread(storeSever);
					printMsgConnectSuccess(storeId);
					clientThread.start();
				}

			}

		} catch (IOException e) {
			System.err.println("클라이언트와의 통신 오류: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("예외 발생");
		}

	}


	private BufferedReader getSocketBufferedReader(Socket socket) {
		InputStream socketInput = null;
		try {
			socketInput = socket.getInputStream();
		} catch (IOException e) {
			System.out.println("Socekt Input Stream IO Exception");
		}
		BufferedReader input = new BufferedReader(new InputStreamReader(socketInput));
		return input;
	}

	private void printMsgConnectSuccess(String storeId) {
		System.out.println("송신 서버에 매장이 연결되었습니다.");
		System.out.println("매장 ID: " + storeId);
		System.out.println();
	}
	
	private class StoreSever implements Runnable {
		private final String STORE_ID;
		private final String SEND_PATH;
		private InputStream socketInput;
		private OutputStream socketOuput;
		private boolean sending = false;

		public StoreSever(String storeId, Socket socket) {
			this.STORE_ID = storeId;
			SEND_PATH = Setting.getStoreSendPath(storeId);
			System.out.println(storeId + " 매장 송신 폴더:" + new File(SEND_PATH).getAbsolutePath());
			try {
				this.socketInput = socket.getInputStream();
				this.socketOuput = socket.getOutputStream();
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
					if (!sending) {
						List<File> files = findFilesToSend();
						sendFile(files);
					}
				}
			} catch (IOException e) {
				System.out.println("클라이언트와의 연결 종료: " + e.getMessage());
			} finally {
				closeSocket();
			}
		}

		private void closeSocket() {
			try {
				socketInput.close();
				socketOuput.close();
				System.out.println("매장 연결이 종료되었습니다: " + STORE_ID);
			} catch (IOException e) {
				System.out.println("소켓 종료 중 오류: " + e.getMessage());
			}
		}

		private List<File> findFilesToSend() {
			List<File> pngFiles = new ArrayList<>();

			File sendFolder = new File(SEND_PATH);
			if (!sendFolder.exists()) {
				sendFolder.mkdirs();
				return pngFiles;
			}

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

		private void sendText(Object msg) {
			PrintWriter printWriter = new PrintWriter(socketOuput, true);
			printWriter.println(msg);
		}
		
		private void sendFile(List<File> sendFiles) {

			if (sendFiles.size() == 0) {
				return;
			}
			sending = true;
			waitTime(Setting.getPollingTime());
			byte[] buffer = new byte[4096];
			int bytesRead;
			for (File f : sendFiles) {
				sendText(f.getName());
				sendText(f.length());
				System.out.println("파일 전송: " + f.getName());
				try (FileInputStream fileInputStream = new FileInputStream(f)) {
					while ((bytesRead = fileInputStream.read(buffer)) != -1) {
						socketOuput.write(buffer, 0, bytesRead);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				waitTime(2_000);
				f.delete();
				waitTime(10_000);
			}
			sending = false;
			
		}

		private void waitTime(int waitTime) {
			try {
				Thread.sleep(waitTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}



	}
}
