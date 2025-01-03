package org.kitri.services.sales.stock.entity;

import java.sql.Timestamp;

public class StoreStock {
	private String storeId;
	private String goodsId;
	private String goodsName;
	private int qty;
	private Timestamp updateDate;

	public String getStoreId() {
		return storeId;
	}

	public StoreStock setStoreId(String storeId) {
		this.storeId = storeId;
		return this;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public StoreStock setGoodsId(String goodsId) {
		this.goodsId = goodsId;
		return this;
	}

	public int getQty() {
		return qty;
	}

	public StoreStock setQty(int qty) {
		this.qty = qty;
		return this;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public StoreStock setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
		return this;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public StoreStock setGoodsName(String goodsName) {
		this.goodsName = goodsName;
		return this;
	}

}
