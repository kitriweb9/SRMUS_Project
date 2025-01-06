package org.kitri.services.store.repo.dto;

import java.util.Date;

public class SsmTxnSalDto {
	private String salesId;
	private String purchaseId;
	private String storeId;
	private String employeeId;
	private int salesAmount;
	private Date salesDate;
	private String goodsId;
	private int salesQuantity;
	private String salesStatus;
	
	public SsmTxnSalDto() {}

	public SsmTxnSalDto(String salesId, String purchaseId, String storeId, String employeeId, int salesAmount,
			Date salesDate, String goodsId, int salesQuantity, String salesStatus) {
		super();
		this.salesId = salesId;
		this.purchaseId = purchaseId;
		this.storeId = storeId;
		this.employeeId = employeeId;
		this.salesAmount = salesAmount;
		this.salesDate = salesDate;
		this.goodsId = goodsId;
		this.salesQuantity = salesQuantity;
		this.salesStatus = salesStatus;
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

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public int getSalesQuantity() {
		return salesQuantity;
	}

	public void setSalesQuantity(int salesQuantity) {
		this.salesQuantity = salesQuantity;
	}

	public String getSalesStatus() {
		return salesStatus;
	}

	public void setSalesStatus(String salesStatus) {
		this.salesStatus = salesStatus;
	}
	

}
