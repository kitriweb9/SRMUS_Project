import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class SysComCchSrv {
	private static Map<String, Object> cacheDatas = new HashMap<>();
	private static String SETTING_FILE_PATH = System.getProperty("user.dir") + "/hq.setting";
	
	public static void main(String[] args) {
		Properties setting = getSetting();
		final int PORT = Integer.parseInt(setting.getProperty("CACHE_PORT"));
		try (ServerSocket serverSocket = new ServerSocket(PORT)) {
			System.out.println("캐시 서버가 시작되었습니다. 연결 대기 중...");
			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println(socket.getPort() + "로 클라이언트가 연결되었습니다.");
				Runnable client = new Client(socket);
				Thread clientThread = new Thread(client);
				clientThread.start();
			}

		} catch (IOException e) {
			System.err.println("서버 실행 오류: " + e.getMessage());
		} 
	}
	
	private static Properties getSetting() {
		Properties setting = new Properties();
		try (FileInputStream in = new FileInputStream(SETTING_FILE_PATH) ) {
			setting.load(in);
		} catch (FileNotFoundException e) {
			System.out.println("캐시 설정 파일이 없습니다");
			System.out.println("캐시 설정 파일 경로: " + SETTING_FILE_PATH);
		} catch (IOException e) {
			System.out.println("캐시 설정 파일을 읽을 수 없습니다.");
		}
		return setting;
		
	}
	private static class Client implements Runnable {
		private Socket socket;

		public Client(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			try (InputStream socketInput = socket.getInputStream();
					BufferedReader input = new BufferedReader(new InputStreamReader(socketInput));
					PrintWriter output = new PrintWriter(socket.getOutputStream(), true)

			) {

				String message;
				while ((message = input.readLine()) != null) {
					try {
						String key = message;
						System.out.println(key);
						switch (message.split(":")[0]) {
						case "GET":
							ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
							objectOutputStream.writeObject(cacheDatas.get(key));
							break;
						case "POST":
							ObjectInputStream objInput = new ObjectInputStream(socketInput);
							Object put = cacheDatas.put(message.replace("POST", "GET"), objInput.readObject());
							System.out.println("= 데이터 수신 =");
							System.out.println(put);
							break;
						default:
							System.out.println("올바르지 않는 명령입니다.");
						}

					} catch (SocketException e) {
						System.out.println("클라이언트가 연결을 종료 했습니다.");
					} catch (ClassNotFoundException e) {
						System.out.println("사전에 등록된 클래스가 아닙니다. 확인 후 다시 이용 바랍니다");
					}
				}

				

			} catch (IOException e) {
				System.out.println("IO Exception 발생");
			} finally {
				System.out.println("클라이언트와 연결이 종료되었습니다.");
			}
		}
	}

}