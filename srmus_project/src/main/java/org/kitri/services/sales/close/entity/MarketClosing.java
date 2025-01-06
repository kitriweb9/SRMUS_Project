package org.kitri.services.sales.close.entity;

import java.sql.Timestamp;

public class MarketClosing {
	private String marketClosingId;
	private String storeId;
	private Timestamp marketClosingDate;
	private int marketClosingAmount;

	public MarketClosing() {
		super();
	}

	public MarketClosing(String marketClosingId, String storeId, Timestamp marketClosingDate, int marketClosingAmount) {
		super();
		this.marketClosingId = marketClosingId;
		this.storeId = storeId;
		this.marketClosingDate = marketClosingDate;
		this.marketClosingAmount = marketClosingAmount;
	}

	public String getMarketClosingId() {
		return marketClosingId;
	}

	public void setMarketClosingId(String marketClosingId) {
		this.marketClosingId = marketClosingId;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public Timestamp getMarketClosingDate() {
		return marketClosingDate;
	}

	public void setMarketClosingDate(Timestamp marketClosingDate) {
		this.marketClosingDate = marketClosingDate;
	}

	public int getMarketClosingAmount() {
		return marketClosingAmount;
	}

	public void setMarketClosingAmount(int marketClosingAmount) {
		this.marketClosingAmount = marketClosingAmount;
	}

}
