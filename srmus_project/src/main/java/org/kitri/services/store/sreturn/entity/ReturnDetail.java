package org.kitri.services.store.sreturn.entity;

public class ReturnDetail {
	private String returnId;
	private String goodsId;
	private int returnQuantity;
	
	public ReturnDetail() {}

	public ReturnDetail(String returnId, String goodsId, int returnQuantity) {
		super();
		this.returnId = returnId;
		this.goodsId = goodsId;
		this.returnQuantity = returnQuantity;
	}

	public String getReturnId() {
		return returnId;
	}

	public void setReturnId(String returnId) {
		this.returnId = returnId;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public int getReturnQuantity() {
		return returnQuantity;
	}

	public void setReturnQuantity(int returnQuantity) {
		this.returnQuantity = returnQuantity;
	}
	
	

}
