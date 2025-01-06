package org.kitri.services.store.repo.dto;

import java.util.Date;

public class SsmTxnPurRegDto {
	private String purchaseId;
	private String customerId;
	private String storeId;
	private int purchaseAmount;
	private Date purchaseDate;
	private String goodsId;
	private int purchaseQuantity;
	private String purchasePaymentStatus;
	private String goodsName;
	private int goodsPrice;
	
	public SsmTxnPurRegDto() {}

	public SsmTxnPurRegDto(String purchaseId, String customerId, String storeId, int purchaseAmount, Date purchaseDate,
			String goodsId, int purchaseQuantity, String purchasePaymentStatus, String goodsName, int goodsPrice) {
		super();
		this.purchaseId = purchaseId;
		this.customerId = customerId;
		this.storeId = storeId;
		this.purchaseAmount = purchaseAmount;
		this.purchaseDate = purchaseDate;
		this.goodsId = goodsId;
		this.purchaseQuantity = purchaseQuantity;
		this.purchasePaymentStatus = purchasePaymentStatus;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
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

	public int getPurchaseAmount() {
		return purchaseAmount;
	}

	public void setPurchaseAmount(int purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public int getPurchaseQuantity() {
		return purchaseQuantity;
	}

	public void setPurchaseQuantity(int purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}

	public String getPurchasePaymentStatus() {
		return purchasePaymentStatus;
	}

	public void setPurchasePaymentStatus(String purchasePaymentStatus) {
		this.purchasePaymentStatus = purchasePaymentStatus;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getPurchaseId()+"/"+getCustomerId()+"/"+getStoreId()+"/"+getPurchaseAmount()+"/"+getPurchaseDate()
				+"/"+getGoodsId()+"/"+getPurchaseQuantity()+"/"+getPurchasePaymentStatus()+"/"+getGoodsName()+"/"+getGoodsPrice();
	}
}
