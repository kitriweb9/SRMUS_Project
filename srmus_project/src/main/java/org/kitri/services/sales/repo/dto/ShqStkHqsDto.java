package org.kitri.services.sales.repo.dto;

public class ShqStkHqsDto {
	private String goodsId;
	private String goodsName;
	private int qty;
	private String updateDate;

	public String getGoodsId() {
		return goodsId;
	}

	public ShqStkHqsDto setGoodsId(String goodsId) {
		this.goodsId = goodsId;
		return this;
	}

	public int getQty() {
		return qty;
	}

	public ShqStkHqsDto setQty(int qty) {
		this.qty = qty;
		return this;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public ShqStkHqsDto setGoodsName(String goodsName) {
		this.goodsName = goodsName;
		return this;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public ShqStkHqsDto setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
		return this;
	}


}
