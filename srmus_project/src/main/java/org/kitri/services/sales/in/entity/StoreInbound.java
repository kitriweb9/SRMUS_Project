package org.kitri.services.sales.in.entity;

import java.sql.Timestamp;

public class StoreInbound {
	private String inboundId;
	private String storeId;
	private String storeName;
	private Timestamp inboundDate;
	private String goodsId;
	private String goodsName;
	private int inboundQuantity;
	private String confirm;
	
	public String getInboundId() {
		return inboundId;
	}
	public StoreInbound setInboundId(String inboundId) {
		this.inboundId = inboundId;
		return this;
	}
	public String getStoreId() {
		return storeId;
	}
	public StoreInbound setStoreId(String storeId) {
		this.storeId = storeId;
		return this;
	}
	public Timestamp getInboundDate() {
		return inboundDate;
	}
	public StoreInbound setInboundDate(Timestamp inboundDate) {
		this.inboundDate = inboundDate;
		return this;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public StoreInbound setGoodsId(String goodsId) {
		this.goodsId = goodsId;
		return this;
	}
	public int getInboundQuantity() {
		return inboundQuantity;
	}
	public StoreInbound setInboundQuantity(int inboundQuantity) {
		this.inboundQuantity = inboundQuantity;
		return this;
	}
	public String getConfirm() {
		return confirm;
	}
	public StoreInbound setConfirm(String confirm) {
		this.confirm = confirm;
		return this;
	}
	public String getStoreName() {
		return storeName;
	}
	public StoreInbound setStoreName(String storeName) {
		this.storeName = storeName;
		return this;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public StoreInbound setGoodsName(String goodsName) {
		this.goodsName = goodsName;
		return this;
	}
	

}
