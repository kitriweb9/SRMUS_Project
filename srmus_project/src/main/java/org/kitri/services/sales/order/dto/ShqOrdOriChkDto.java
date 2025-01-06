package org.kitri.services.sales.order.dto;

public class ShqOrdOriChkDto {
	private String orderId;
	private String storeName;
	private String employeeName;
	private String goodsCategoryName;
	private String goodsName;
	private int orderQuantity;
	private String orderConfirmStatus;

	public ShqOrdOriChkDto() {
		super();
	}

	public ShqOrdOriChkDto(String orderId, String storeName, String employeeName, String goodsCategoryName,
			String goodsName, int orderQuantity, String orderConfirmStatus) {
		super();
		this.orderId = orderId;
		this.storeName = storeName;
		this.employeeName = employeeName;
		this.goodsCategoryName = goodsCategoryName;
		this.goodsName = goodsName;
		this.orderQuantity = orderQuantity;
		this.orderConfirmStatus = orderConfirmStatus;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getGoodsCategoryName() {
		return goodsCategoryName;
	}

	public void setGoodsCategoryName(String goodsCategoryName) {
		this.goodsCategoryName = goodsCategoryName;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public String getOrderConfirmStatus() {
		return orderConfirmStatus;
	}

	public void setOrderConfirmStatus(String orderConfirmStatus) {
		this.orderConfirmStatus = orderConfirmStatus;
	}

	@Override
	public String toString() {
		return "ShqOrdOriChkDto [orderId=" + orderId + ", storeName=" + storeName + ", employeeName=" + employeeName
				+ ", goodsCategoryName=" + goodsCategoryName + ", goodsName=" + goodsName + ", orderQuantity="
				+ orderQuantity + ", orderConfirmStatus=" + orderConfirmStatus + "]";
	}

}
