package org.kitri.services.store.goods.entity;

public class GoodsCategory {
	private String goodsCategoryId;
	private String goodsCategoryName;
	
	public GoodsCategory() {
		
	}
	public GoodsCategory(String goodsCategoryId, String goodsCategoryName) {
		super();
		this.goodsCategoryId = goodsCategoryId;
		this.goodsCategoryName = goodsCategoryName;
	}

	public String getGoodsCategoryId() {
		return goodsCategoryId;
	}
	public void setGoodsCategoryId(String goodsCategoryId) {
		this.goodsCategoryId = goodsCategoryId;
	}
	public String getGoodsCategoryName() {
		return goodsCategoryName;
	}
	public void setGoodsCategoryName(String goodsCategoryName) {
		this.goodsCategoryName = goodsCategoryName;
	}
}
