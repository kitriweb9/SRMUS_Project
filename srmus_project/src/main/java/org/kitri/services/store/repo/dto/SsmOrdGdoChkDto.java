package org.kitri.services.store.repo.dto;

import java.sql.Timestamp;

public class SsmOrdGdoChkDto {
	private String orderId;
	private String storeId;
	private Timestamp orderRegisterDate;
	private Timestamp orderConfirmDate;
	private String orderConfirmStatus;

	private String goodsId;
	private int orderQuantity;

	public SsmOrdGdoChkDto() {
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public Timestamp getOrderRegisterDate() {
		return orderRegisterDate;
	}

	public void setOrderRegisterDate(Timestamp orderRegisterDate) {
		this.orderRegisterDate = orderRegisterDate;
	}

	public Timestamp getOrderConfirmDate() {
		return orderConfirmDate;
	}

	public void setOrderConfirmDate(Timestamp orderConfirmDate) {
		this.orderConfirmDate = orderConfirmDate;
	}

	public String getOrderConfirmStatus() {
		return orderConfirmStatus;
	}

	public void setOrderConfirmStatus(String orderConfirmStatus) {
		this.orderConfirmStatus = orderConfirmStatus;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
}
