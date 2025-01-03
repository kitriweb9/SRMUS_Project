package org.kitri.services.sales.repo.dto;

public class ShqMktMkiChkDto {
	private String storeId;
	private String storeName;
	private String employeeId;

	public ShqMktMkiChkDto() {
		super();
	}

	public ShqMktMkiChkDto(String storeId, String storeName, String employeeId) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.employeeId = employeeId;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

}
