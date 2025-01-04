package org.kitri.services.store.repo.dto;

public class SsmRtnSndDto {
	private String returnId;
	private String storeId;
	private String employeeId;
	private String returnRegisterDate;
	private String goodsId;
	private int returnQuantity;
	private String returnState;

	public SsmRtnSndDto() {
	}

	public SsmRtnSndDto(String returnId, String storeId, String employeeId, String returnRegisterDate, String goodsId,
			int returnQuantity, String returnState) {
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

	public String getReturnRegisterDate() {
		return returnRegisterDate;
	}

	public void setReturnRegisterDate(String returnRegisterDate) {
		this.returnRegisterDate = returnRegisterDate;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public int getReturnQuantity() {
		return returnQuantity;
	}

	public void setReturnQuantity(int returnQuantity) {
		this.returnQuantity = returnQuantity;
	}

	public String getReturnState() {
		return returnState;
	}

	public void setReturnState(String returnState) {
		this.returnState = returnState;
	}

	@Override
	public String toString() {
		return "SsmRtnSndDto [returnId=" + returnId + ", storeId=" + storeId + ", employeeId=" + employeeId
				+ ", returnRegisterDate=" + returnRegisterDate + ", goodsId=" + goodsId + ", returnQuantity="
				+ returnQuantity + ", returnState=" + returnState + "]";
	}

}
