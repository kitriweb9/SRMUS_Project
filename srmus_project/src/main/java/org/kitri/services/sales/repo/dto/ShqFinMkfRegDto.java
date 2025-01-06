package org.kitri.services.sales.repo.dto;

public class ShqFinMkfRegDto {
	private String marketClosingId;
	private String storeId;
	private String marketClosingDate;
	private int marketClosingAmount;

	public ShqFinMkfRegDto() {
		super();
	}

	public ShqFinMkfRegDto(String marketClosingId, String storeId, String marketClosingDate, int marketClosingAmount) {
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

	public String getMarketClosingDate() {
		return marketClosingDate;
	}

	public void setMarketClosingDate(String marketClosingDate) {
		this.marketClosingDate = marketClosingDate;
	}

	public int getMarketClosingAmount() {
		return marketClosingAmount;
	}

	public void setMarketClosingAmount(int marketClosingAmount) {
		this.marketClosingAmount = marketClosingAmount;
	}

}
