package com.thelightway.headquarter.receiver.dao;

public class DBInfo {
	private final String dbUrl;
	private final String id;
	private final String pwd;

	public DBInfo(String dburl, String id, String pwd) {
		this.dbUrl = dburl;
		this.id = id;
		this.pwd = pwd;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public String getId() {
		return id;
	}

	public String getPwd() {
		return pwd;
	}

}
