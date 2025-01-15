package com.thelightway.headquarter.receiver.dao;

public class DBInfo {
	private final String DB_URL;
	private final String DB_ID;
	private final String DB_PWD;

	public DBInfo(String dburl, String id, String pwd) {
		this.DB_URL = dburl;
		this.DB_ID = id;
		this.DB_PWD = pwd;
	}

	public String getDbUrl() {
		return DB_URL;
	}

	public String getId() {
		return DB_ID;
	}

	public String getPwd() {
		return DB_PWD;
	}

}
