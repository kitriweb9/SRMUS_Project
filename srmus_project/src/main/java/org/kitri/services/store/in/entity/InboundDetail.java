package org.kitri.services.store.in.entity;

public class InboundDetail {
	private String inboundId;
	private String goodsId;
	private int inboundQuantity;
	private String inboundConfirmStatus;

	public InboundDetail() {
	}

	public InboundDetail(String inboundId, String goodsId, int inboundQuantity, String inboundConfirmStatus) {
		this.inboundId = inboundId;
		this.goodsId = goodsId;
		this.inboundQuantity = inboundQuantity;
		this.inboundConfirmStatus = inboundConfirmStatus;
	}

	public String getInboundId() {
		return inboundId;
	}

	public void setInboundId(String inboundId) {
		this.inboundId = inboundId;
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

	public String getInboundConfirmStatus() {
		return inboundConfirmStatus;
	}

	public void setInboundConfirmStatus(String inboundConfirmStatus) {
		this.inboundConfirmStatus = inboundConfirmStatus;
	}
}
