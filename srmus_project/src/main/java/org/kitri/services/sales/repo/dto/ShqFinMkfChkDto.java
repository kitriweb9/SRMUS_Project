package org.kitri.services.sales.repo.dto;

public class ShqFinMkfChkDto {
	private String marketClosingId;
	private String storeId;
	private String storeName;
	private String employeeId;
	private String employeeName;
	private String marketClosingDate;
	private String marketClosingAmount;

	public ShqFinMkfChkDto() {
		super();
	}

	public ShqFinMkfChkDto(String marketClosingId, String storeId, String storeName, String employeeId,
			String employeeName, String marketClosingDate, String marketClosingAmount) {
		super();
		this.marketClosingId = marketClosingId;
		this.storeId = storeId;
		this.storeName = storeName;
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.marketClosingDate = marketClosingDate;
		this.marketClosingAmount = marketClosingAmount;
	}

	public String getMarketClosingId() {
		return marketClosingId;
	}

	public void setMarketClosingId(String marketClosingId) {
		this.marketClosingId = marketClosingId;
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

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getMarketClosingDate() {
		return marketClosingDate;
	}

	public void setMarketClosingDate(String marketClosingDate) {
		this.marketClosingDate = marketClosingDate;
	}

	public String getMarketClosingAmount() {
		return marketClosingAmount;
	}

	public void setMarketClosingAmount(String marketClosingAmount) {
		this.marketClosingAmount = marketClosingAmount;
	}

}
