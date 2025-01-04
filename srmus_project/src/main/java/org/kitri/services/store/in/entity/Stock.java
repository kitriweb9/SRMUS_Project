package org.kitri.services.store.in.entity;

public class Stock {
	private String storeId;
	private String goodsId;
	private int stockQuantity;
	private int stockSafetyQuantity;

	public Stock() {
	}

	public Stock(String storeId, String goodsId, int stockQuantity, int stockSafetyQuantity) {
		this.storeId = storeId;
		this.goodsId = goodsId;
		this.stockQuantity = stockQuantity;
		this.stockSafetyQuantity = stockSafetyQuantity;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public int getStockSafetyQuantity() {
		return stockSafetyQuantity;
	}

	public void setStockSafetyQuantity(int stockSafetyQuantity) {
		this.stockSafetyQuantity = stockSafetyQuantity;
	}
}
