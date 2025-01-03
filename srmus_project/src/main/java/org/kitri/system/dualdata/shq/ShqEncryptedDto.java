package org.kitri.system.dualdata.shq;

public class ShqEncryptedDto {
	private String inboundId;
	private String storeId;
	private String storeName;
	private String inboundDate;
	private String goodsId;
	private String goodsName;
	private String inboundQuantity;
	private String confirm;
	
	public String getInboundId() {
		return inboundId;
	}
	public ShqEncryptedDto setInboundId(String inboundId) {
		this.inboundId = inboundId;
		return this;
	}
	public String getStoreId() {
		return storeId;
	}
	public ShqEncryptedDto setStoreId(String storeId) {
		this.storeId = storeId;
		return this;
	}
	public String getInboundDate() {
		return inboundDate;
	}
	public ShqEncryptedDto setInboundDate(String inboundDate) {
		this.inboundDate = inboundDate;
		return this;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public ShqEncryptedDto setGoodsId(String goodsId) {
		this.goodsId = goodsId;
		return this;
	}
	public String getInboundQuantity() {
		return inboundQuantity;
	}
	public ShqEncryptedDto setInboundQuantity(String inboundQuantity) {
		this.inboundQuantity = inboundQuantity;
		return this;
	}
	public String getConfirm() {
		return confirm;
	}
	public ShqEncryptedDto setConfirm(String confirm) {
		this.confirm = confirm;
		return this;
	}
	public String getStoreName() {
		return storeName;
	}
	public ShqEncryptedDto setStoreName(String storeName) {
		this.storeName = storeName;
		return this;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public ShqEncryptedDto setGoodsName(String goodsName) {
		this.goodsName = goodsName;
		return this;
	}
	

}