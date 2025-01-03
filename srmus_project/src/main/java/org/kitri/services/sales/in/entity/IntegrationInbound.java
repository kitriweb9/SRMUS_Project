package org.kitri.services.sales.in.entity;

import java.sql.Timestamp;

public class IntegrationInbound {
	private Timestamp inboundDate;
	private String goodsId;
	private String goodsName;
	private int inboundQty;
	private String confirmStatus;
	private Timestamp updateDate;

	public Timestamp getInboundDate() {
		return inboundDate;
	}

	public IntegrationInbound setInboundDate(Timestamp inboundDate) {
		this.inboundDate = inboundDate;
		return this;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public IntegrationInbound setGoodsId(String goodsId) {
		this.goodsId = goodsId;
		return this;
	}

	public int getInboundQty() {
		return inboundQty;
	}

	public IntegrationInbound setInboundQty(int inboundQty) {
		this.inboundQty = inboundQty;
		return this;
	}

	public String getConfirmStatus() {
		return confirmStatus;
	}

	public IntegrationInbound setConfirmStatus(String confirmStatus) {
		this.confirmStatus = confirmStatus;
		return this;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public IntegrationInbound setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
		return this;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

}
