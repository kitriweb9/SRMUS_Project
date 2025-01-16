package org.kitri.services.common.data.login.session;

public class SessionDT {
	private String id;
	private String userId;
	
	public SessionDT() {
		
	}
	public SessionDT(String id, String userId) {
		this.id = id;
		this.userId = userId;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
