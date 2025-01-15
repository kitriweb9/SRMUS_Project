package com.thelightway.headquarter.receiver.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ReceiverDao {
	private final DBInfo DB_INFO;
	
	public ReceiverDao(DBInfo dbInfo) {
        this.DB_INFO = dbInfo;
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
		
		try(Connection connection = DriverManager.getConnection(DB_INFO.getDbUrl(),
																DB_INFO.getId(),
																DB_INFO.getPwd()); 
			Statement st = connection.createStatement();
			Statement st2 = connection.createStatement();){
			
			count+= st.executeUpdate(sql1);		
			if(table2 != null) {
				String sql2 = convertTextToSql(table2, data2);
				System.out.println(sql2);
				count+= st2.executeUpdate(sql2);
								
			}
		} catch (SQLException e) {
					System.out.println("SQL 실행 오류");
					e.printStackTrace(System.out);
		}
		return count;
		
	}
	
	public String convertTextToSql(String tableName, Map<String, String> data) {
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
			inputValue = "'" + inputValue + "'";
			sql.append(", " + inputValue);
		}
		sql.append(")");
		
		return sql.toString().replace("'SYSDATE'", "SYSDATE");
	}
}

