package org.kitri.services.sales.repo.dto;

public class ShqInbExpDto {
	private String inboundId;
	private String storeId;
	private String storeName;
	private String inboundDate;
	private String goodsId;
	private String goodsName;
	private int inboundQuantity;
	private String confirm;

	public String getInboundId() {
		return inboundId;
	}

	public ShqInbExpDto setInboundId(String inboundId) {
		this.inboundId = inboundId;
		return this;
	}

	public String getStoreId() {
		return storeId;
	}

	public ShqInbExpDto setStoreId(String storeId) {
		this.storeId = storeId;
		return this;
	}

	public String getInboundDate() {
		return inboundDate;
	}

	public ShqInbExpDto setInboundDate(String inboundDate) {
		this.inboundDate = inboundDate;
		return this;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public ShqInbExpDto setGoodsId(String goodsId) {
		this.goodsId = goodsId;
		return this;
	}

	public int getInboundQuantity() {
		return inboundQuantity;
	}

	public ShqInbExpDto setInboundQuantity(int inboundQuantity) {
		this.inboundQuantity = inboundQuantity;
		return this;
	}

	public String getConfirm() {
		return confirm;
	}

	public ShqInbExpDto setConfirm(String confirm) {
		this.confirm = confirm;
		return this;
	}

	public String getStoreName() {
		return storeName;
	}

	public ShqInbExpDto setStoreName(String storeName) {
		this.storeName = storeName;
		return this;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public ShqInbExpDto setGoodsName(String goodsName) {
		this.goodsName = goodsName;
		return this;
	}

}
