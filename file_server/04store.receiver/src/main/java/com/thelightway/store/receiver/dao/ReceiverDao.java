package com.thelightway.store.receiver.dao;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ReceiverDao {
	private final String dbUrl;
	private final String dbId;
	private final String dbPw;
	
	public ReceiverDao() {
		Properties setting = new Properties();
		try (FileInputStream in = new FileInputStream(System.getProperty("user.dir") + "/store.setting")) {
			setting.load(in);
		}  catch (IOException e) {
			System.out.println("매장 설정 파일이 없거나 읽을 수 없습니다. 읽을 수 없습니다.");
		}
		
		dbUrl = (String) setting.getProperty("DB_URL");
		dbId = setting.getProperty("DB_USER_NAME");
		dbPw = setting.getProperty("DB_USER_PASSWORD");
		
        
	}
	
	
	public int saveData(Map<String, String> data) {
		Map<String, String> data1 = new HashMap<String, String>();
		Map<String, String> data2 = new HashMap<String, String>();
		String table1 = data.get("TABLE1");
		String table2 = data.get("TABLE2");
		if(table1 != null) {
			data.remove("TABLE1");
		}
		
		if(table2 != null) {
			data.remove("TABLE2");
		}
		
		Set<String> keySet = data.keySet();
		for (String s : keySet) {
			if(s.contains("TABLE1")) {
				data1.put(s.replace("TABLE1_", ""), data.get(s));
			} else if (s.contains("TABLE2")) {
				data2.put(s.replace("TABLE2_", ""), data.get(s));
			}
		}
		String sql1 = convertTextToSql(table1, data1);
		System.out.println(sql1);
		
		int count = 0;
		try(Connection connection = DriverManager.getConnection(dbUrl,dbId,dbPw); 
			Statement st = connection.createStatement();){
			count+= st.executeUpdate(sql1);		
		} catch (SQLException e) {
			System.out.println("SQL 실행 오류");
			e.printStackTrace(System.out);
		}
		
		if(table2 != null) {
			String sql2 = convertTextToSql(table2, data2);
			System.out.println(sql2);
			try(Connection connection = DriverManager.getConnection(dbUrl,dbId,dbPw); 
					Statement st = connection.createStatement();){
					count+= st.executeUpdate(sql2);		
				} catch (SQLException e) {
					System.out.println("SQL 실행 오류");
					e.printStackTrace(System.out);
				}			
		}
		return count;
		
	}
	
	private String convertTextToSql(String tableName, Map<String, String> data) {
		StringBuilder sql = new StringBuilder("INSERT INTO " + tableName + " ");
		Set<String> colums = data.keySet();
		Iterator<String> keyIterator = colums.iterator();
		//컬럼 추가
		sql.append("(");
		sql.append(keyIterator.next());
		while(keyIterator.hasNext()) {
			sql.append(", "+keyIterator.next());
		}
		sql.append(")");
		
		//값 추가
		sql.append(" VALUES (");
		Iterator<String> valueKeys = colums.iterator();
		sql.append("'" + data.get(valueKeys.next()) + "'");
		while(valueKeys.hasNext()) {
			String inputValue = data.get(valueKeys.next());
			if(!inputValue.equals("SYSDATE")) {
				inputValue = "'" + inputValue + "'";
			}
			sql.append(", " + inputValue);
		}
		sql.append(")");
		
		return sql.toString();
	}
	
	
	
	
}

