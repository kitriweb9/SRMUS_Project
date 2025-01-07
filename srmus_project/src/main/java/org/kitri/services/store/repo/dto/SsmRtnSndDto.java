package org.kitri.services.store.repo.dto;

import java.util.Date;

public class SsmRtnSndDto {
	private String returnId;
	private String storeId;
	private String employeeId;
	private Date returnRegisterDate;
	private String goodsId; 
	private Integer returnQuantity;
	private String returnState;
	
	public SsmRtnSndDto() {}

	public SsmRtnSndDto(String returnId, String storeId, String employeeId, Date returnRegisterDate, String goodsId,
			Integer returnQuantity, String returnState) {
		super();
		this.returnId = returnId;
		this.storeId = storeId;
		this.employeeId = employeeId;
		this.returnRegisterDate = returnRegisterDate;
		this.goodsId = goodsId;
		this.returnQuantity = returnQuantity;
		this.returnState = returnState;
	}

	public String getReturnId() {
		return returnId;
	}

	public void setReturnId(String returnId) {
		this.returnId = returnId;
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

	public Date getReturnRegisterDate() {
		return returnRegisterDate;
	}

	public void setReturnRegisterDate(Date returnRegisterDate) {
		this.returnRegisterDate = returnRegisterDate;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getReturnQuantity() {
		return returnQuantity;
	}

	public void setReturnQuantity(Integer returnQuantity) {
		this.returnQuantity = returnQuantity;
	}

	public String getReturnState() {
		return returnState;
	}

	public void setReturnState(String returnState) {
		this.returnState = returnState;
	}

	
	
}
