package org.kitri.services.store.repo.dto;

public class SsmInbMgtChgDto {
	private String inboundId;
	private String goodsId;
	private int inboundQuantity;

	public SsmInbMgtChgDto() {
	}

	public SsmInbMgtChgDto(String inboundId, String goodsId, int inboundQuantity) {
		this.inboundId = inboundId;
		this.goodsId = goodsId;
		this.inboundQuantity = inboundQuantity;
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
}
