package org.kitri.services.store.repo.dto;

public class SsmStkMgtChgDto {
	private String goodsId;
	private String storeId;
	private int stockQuantity;
	private int stockSafetyQuantity;

	// Getters and Setters
	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
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
