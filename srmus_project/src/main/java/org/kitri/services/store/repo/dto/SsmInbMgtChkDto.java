package org.kitri.services.store.repo.dto;

import java.sql.Timestamp;

public class SsmInbMgtChkDto {
	private String inboundId;
	private String storeId;
	private String goodsId;
	private int inboundQuantity;
	private Timestamp inboundDate;
	private Timestamp inboundConfirmDate;

	public String getInboundId() {
		return inboundId;
	}

	public void setInboundId(String inboundId) {
		this.inboundId = inboundId;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public int getInboundQuantity() {
		return inboundQuantity;
	}

	public void setInboundQuantity(int inboundQuantity) {
		this.inboundQuantity = inboundQuantity;
	}

	public Timestamp getInboundDate() {
		return inboundDate;
	}

	public void setInboundDate(Timestamp inboundDate) {
		this.inboundDate = inboundDate;
	}

	public Timestamp getInboundConfirmDate() {
		return inboundConfirmDate;
	}

	public void setInboundConfirmDate(Timestamp inboundConfirmDate) {
		this.inboundConfirmDate = inboundConfirmDate;
	}
}
