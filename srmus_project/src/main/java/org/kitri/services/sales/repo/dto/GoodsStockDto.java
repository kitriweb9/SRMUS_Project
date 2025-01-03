package org.kitri.services.sales.repo.dto;

public class GoodsStockDto {
	private String goodsId;
	private String goodsName;
	private int qty;
	private String updateDate;

	public String getGoodsId() {
		return goodsId;
	}

	public GoodsStockDto setGoodsId(String goodsId) {
		this.goodsId = goodsId;
		return this;
	}

	public int getQty() {
		return qty;
	}

	public GoodsStockDto setQty(int qty) {
		this.qty = qty;
		return this;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public GoodsStockDto setGoodsName(String goodsName) {
		this.goodsName = goodsName;
		return this;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public GoodsStockDto setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
		return this;
	}


}
