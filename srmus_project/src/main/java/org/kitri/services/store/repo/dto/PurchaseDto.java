package org.kitri.services.store.repo.dto;

import java.sql.Timestamp;

public class PurchaseDto {
	private String purchaseId;
	private String customerId;
	private String storeId;
	private int amount;
	private Timestamp purchaseDate;
	private String goodsId;
	private int quantity;
	private String paymentStatus;
	
	public PurchaseDto() {}

	public PurchaseDto(String purchaseId, String customerId, String storeId, int amount, Timestamp purchaseDate,
			String goodsId, int quantity, String paymentStatus) {
		super();
		this.purchaseId = purchaseId;
		this.customerId = customerId;
		this.storeId = storeId;
		this.amount = amount;
		this.purchaseDate = purchaseDate;
		this.goodsId = goodsId;
		this.quantity = quantity;
		this.paymentStatus = paymentStatus;
	}

	public String getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(String purchaseId) {
		this.purchaseId = purchaseId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Timestamp getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Timestamp purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
}
