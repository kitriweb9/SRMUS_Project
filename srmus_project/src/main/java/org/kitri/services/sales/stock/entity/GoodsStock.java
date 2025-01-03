package org.kitri.services.sales.stock.entity;

import java.sql.Timestamp;

public class GoodsStock {
	private String goodsId;
	private String goodsName;
	private int qty;
	private Timestamp updateDate;
	
	public String getGoodsId() {
		return goodsId;
	}

	public GoodsStock setGoodsId(String goodsId) {
		this.goodsId = goodsId;
		return this;
	}

	public int getQty() {
		return qty;
	}

	public GoodsStock setQty(int qty) {
		this.qty = qty;
		return this;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public GoodsStock setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
		return this;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public GoodsStock setGoodsName(String goodsName) {
		this.goodsName = goodsName;
		return this;
	}

}
