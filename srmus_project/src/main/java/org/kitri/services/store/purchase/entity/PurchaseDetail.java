package org.kitri.services.store.purchase.entity;

public class PurchaseDetail {
	private String purchaseId; 
	private String goodsId;
	private int purchaseQuantity;
	private String purchasePaymentStatus;
	
	public PurchaseDetail() {}

	public PurchaseDetail(String purchaseId, String goodsId, int purchaseQuantity, String purchasePaymentStatus) {
		super();
		this.purchaseId = purchaseId;
		this.goodsId = goodsId;
		this.purchaseQuantity = purchaseQuantity;
		this.purchasePaymentStatus = purchasePaymentStatus;
	}

	public String getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(String purchaseId) {
		this.purchaseId = purchaseId;
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


}
