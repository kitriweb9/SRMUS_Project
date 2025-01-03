package org.kitri.system.dualdata;

public class Key {
	private String cId;
	private String salt;
	private String sKey;
	
	public Key() {}

	public Key(String cId, String salt, String sKey) {
		super();
		this.cId = cId;
		this.salt = salt;
		this.sKey = sKey;
	}

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getsKey() {
		return sKey;
	}

	public void setsKey(String sKey) {
		this.sKey = sKey;
	}
	
}
