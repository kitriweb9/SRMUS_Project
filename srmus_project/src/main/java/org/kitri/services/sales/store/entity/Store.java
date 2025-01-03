package org.kitri.services.sales.store.entity;

public class Store {
	private String storeId;
	private String employeeId;
	private String storeName;
	private String storeAddress;
	private String storeContact;

	public Store() {
		super();
	}

	public Store(String storeId, String employeeId, String storeName, String storeAddress, String storeContact) {
		super();
		this.storeId = storeId;
		this.employeeId = employeeId;
		this.storeName = storeName;
		this.storeAddress = storeAddress;
		this.storeContact = storeContact;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public String getStoreContact() {
		return storeContact;
	}

	public void setStoreContact(String storeContact) {
		this.storeContact = storeContact;
	}

}
