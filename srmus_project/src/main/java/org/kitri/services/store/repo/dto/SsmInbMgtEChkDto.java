package org.kitri.services.store.repo.dto;

import java.sql.Timestamp;

public class SsmInbMgtEChkDto {
	private String inboundId;
	private String employeeId;
	private String storeId;
	private Timestamp inboundDate;
	private Timestamp inboundConfirmDate;

	private String goodsId;
	private int inboundQuantity;
	private String inboundConfirmStatus;

	public String getInboundId() {
		return inboundId;
	}

	public void setInboundId(String inboundId) {
		this.inboundId = inboundId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public Timestamp getInboundDate() {
		return inboundDate;
	}

	public void setInboundDate(Timestamp inboundDate) {
		this.inboundDate = inboundDate;
	}

	public Timestamp getInboundConfirmDate() {
		return inboundConfirmDate;
	}

	public void setInboundConfirmDate(Timestamp inboundConfirmDate) {
		this.inboundConfirmDate = inboundConfirmDate;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public int getInboundQuantity() {
		return inboundQuantity;
	}

	public void setInboundQuantity(int inboundQuantity) {
		this.inboundQuantity = inboundQuantity;
	}

	public String getInboundConfirmStatus() {
		return inboundConfirmStatus;
	}

	public void setInboundConfirmStatus(String inboundConfirmStatus) {
		this.inboundConfirmStatus = inboundConfirmStatus;
	}
}
