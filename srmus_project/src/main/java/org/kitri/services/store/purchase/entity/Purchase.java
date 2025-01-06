package org.kitri.services.store.purchase.entity;

import java.sql.Timestamp;
import java.util.Date;

public class Purchase {
	private String purchaseId;
	private String customerId;
	private String storeId;
	private int purchaseAmount;
	private Date purchaseDate;
	
	public Purchase() {}

	public Purchase(String purchaseId, String customerId, String storeId, int purchaseAmount, Date purchaseDate) {
		super();
		this.purchaseId = purchaseId;
		this.customerId = customerId;
		this.storeId = storeId;
		this.purchaseAmount = purchaseAmount;
		this.purchaseDate = purchaseDate;
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

}
