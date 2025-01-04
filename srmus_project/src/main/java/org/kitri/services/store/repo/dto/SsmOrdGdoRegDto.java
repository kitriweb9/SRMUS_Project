package org.kitri.services.store.repo.dto;

public class SsmOrdGdoRegDto {
	private String goodsId;
	private int orderQuantity;

	public SsmOrdGdoRegDto() {
	}

	public SsmOrdGdoRegDto(String goodsId, int orderQuantity) {
		this.goodsId = goodsId;
		this.orderQuantity = orderQuantity;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
}
