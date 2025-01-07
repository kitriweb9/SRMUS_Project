package org.kitri.services.store.sale.entity;

import java.util.Date;

public class Sales {
	private String salesId;
	private String purchaseId;
	private String storeId;
	private String employeeId;
	private int salesAmount;
	private Date salesDate;
	
	public Sales() {}

	public Sales(String salesId, String purchaseId, String storeId, String employeeId, int salesAmount,
			Date salesDate) {
		super();
		this.salesId = salesId;
		this.purchaseId = purchaseId;
		this.storeId = storeId;
		this.employeeId = employeeId;
		this.salesAmount = salesAmount;
		this.salesDate = salesDate;
	}

	public String getSalesId() {
		return salesId;
	}

	public void setSalesId(String salesId) {
		this.salesId = salesId;
	}

	public String getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(String purchaseId) {
		this.purchaseId = purchaseId;
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

	public int getSalesAmount() {
		return salesAmount;
	}

	public void setSalesAmount(int salesAmount) {
		this.salesAmount = salesAmount;
	}

	public Date getSalesDate() {
		return salesDate;
	}

	public void setSalesDate(Date salesDate) {
		this.salesDate = salesDate;
	}


}
