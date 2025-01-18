package org.kitri.services.store.sale.entity;

public class SalesDetail {
	private String salesId;
	private String goodsId;
	private int salesQuantity;
	private String salesStatus;
	
	public SalesDetail() {}

	public SalesDetail(String salesId, String goodsId, int salesQuantity, String salesStatus) {
		super();
		this.salesId = salesId;
		this.goodsId = goodsId;
		this.salesQuantity = salesQuantity;
		this.salesStatus = salesStatus;
	}

	public String getSalesId() {
		return salesId;
	}

	public void setSalesId(String salesId) {
		this.salesId = salesId;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public int getSalesQuantity() {
		return salesQuantity;
	}

	public void setSalesQuantity(int salesQuantity) {
		this.salesQuantity = salesQuantity;
	}

	public String getSalesStatus() {
		return salesStatus;
	}

	public void setSalesStatus(String salesStatus) {
		this.salesStatus = salesStatus;
	}

	
}
