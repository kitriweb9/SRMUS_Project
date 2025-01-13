import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class SysComCchClt {
	private Socket socket;
	private PrintWriter output;
	private ObjectOutputStream objOut;
	private ObjectInputStream objIn;
	private final String SETTING_FILE_PATH = System.getProperty("user.dir") + "/hq.setting";
	
	public SysComCchClt() {

		Properties setting = getSetting();
		final String IP = setting.getProperty("CACHE_IP");
		final int PORT = Integer.parseInt(setting.getProperty("CACHE_PORT"));
		
		try {
			socket = new Socket(IP, PORT);
			output = new PrintWriter(socket.getOutputStream(), true);
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
	}
	
	private Properties getSetting() {
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
	public <T> Object getCacheData(String command, Class<T> returnType) {
		output.println(command);

		try {
			Object getValue;
			objIn = new ObjectInputStream(socket.getInputStream());
			Object read = objIn.readObject();
			if (read == null) {
				return null;
			}

			if (read instanceof List) {
				List objs = (List) read;
				List getList = new ArrayList<T>();
				for (Object object : objs) {
					getList.add(mapToObject(returnType, (Map) object));
				}
				return (List<T>) getList;
			} else {
				getValue = mapToObject(returnType, (Map) read);
				return (T) getValue;
			}

		} catch (IOException e) {
			System.out.println("OBJ오류");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스 호환 안됨");
		} catch (InstantiationException e) {
			System.out.println("기본 생성자가 없습니다: " + e.getMessage());
		} catch (IllegalAccessException e) {
			System.out.println("접근 권한이 없습니다: " + e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println("잘못된 인자입니다: " + e.getMessage());
		} catch (InvocationTargetException e) {
			System.out.println("생성자 호출 중 오류가 발생했습니다: " + e.getTargetException().getMessage());
		} catch (NoSuchMethodException e) {
			System.out.println("생성자가 존재하지 않습니다: " + e.getMessage());
		} catch (SecurityException e) {
			System.out.println("보안 제한으로 인해 접근할 수 없습니다: " + e.getMessage());
		}
		return null;
	}

	private <T> T mapToObject(Class<T> returnType, Map read)
			throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Object returnObj = (T) returnType.getDeclaredConstructor().newInstance();
		Method[] methods = returnType.getMethods();
		for (Method setter : methods) {
			// setter찾기
			if (setter.getName().startsWith("set")) {
				String setterName = setter.getName();
				Object value = read.get(setterName.substring(3));
				if (value != null) {
					setter.invoke(returnObj, value);
				}

			}
		}
		return (T) returnObj;
	}

	public void inputCache(String command, Object obj) {
		try {
			// 서버로 메시지 전송
			output.println(command);
			Object sendData;
			if (obj instanceof List) {
				List objs = (List) obj;
				sendData = new ArrayList<HashMap<String, Object>>();

				for (Object object : objs) {
					((List) sendData).add(objectToMap(object));
				}
			} else {
				sendData = objectToMap(obj);

			}
			objOut = new ObjectOutputStream(socket.getOutputStream());
			objOut.writeObject(sendData);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private HashMap<String, Object> objectToMap(Object obj) throws IllegalAccessException, InvocationTargetException {
		HashMap<String, Object> datas = new HashMap<>();
		Method[] methods = obj.getClass().getMethods();
		for (Method m : methods) {
			if (m.getName().startsWith("get") && !m.getName().equals("getClass")) {
				String key = m.getName().replaceFirst("get", "");
				Object value = m.invoke(obj);
				datas.put(key, value);
			}
		}
		return datas;
	}
}
