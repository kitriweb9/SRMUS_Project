package org.kitri.services.sales.repo.dto;

public class ShqStkMksDto {
	private String storeId;
	private String goodsId;
	private String goodsName;
	private int qty;
	private String updateDate;

	public String getStoreId() {
		return storeId;
	}

	public ShqStkMksDto setStoreId(String storeId) {
		this.storeId = storeId;
		return this;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public ShqStkMksDto setGoodsId(String goodsId) {
		this.goodsId = goodsId;
		return this;
	}

	public int getQty() {
		return qty;
	}

	public ShqStkMksDto setQty(int qty) {
		this.qty = qty;
		return this;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public ShqStkMksDto setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
		return this;
	}
	
	public String getGoodsName() {
		return goodsName;
	}

	public ShqStkMksDto setGoodsName(String goodsName) {
		this.goodsName = goodsName;
		return this;
	}
}
