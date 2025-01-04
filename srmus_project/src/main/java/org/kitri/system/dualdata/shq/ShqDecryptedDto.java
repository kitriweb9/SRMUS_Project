package org.kitri.system.dualdata.shq;

public class ShqDecryptedDto {
	private String inboundId;
	private String storeId;
	private String storeInboundDate;
	private String goodsId;
	private int storeInboundQuantity;
	private String confirm;

	public ShqDecryptedDto(String inboundId, String storeId, String storeInboundDate, String goodsId,
			int storeInboundQuantity) {
		super();
		this.inboundId = inboundId;
		this.storeId = storeId;
		this.storeInboundDate = storeInboundDate;
		this.goodsId = goodsId;
		this.storeInboundQuantity = storeInboundQuantity;
	}

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

	public String getStoreInboundDate() {
		return storeInboundDate;
	}

	public void setStoreInboundDate(String storeInboundDate) {
		this.storeInboundDate = storeInboundDate;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public int getStoreInboundQuantity() {
		return storeInboundQuantity;
	}

	public void setStoreInboundQuantity(int storeInboundQuantity) {
		this.storeInboundQuantity = storeInboundQuantity;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

}
