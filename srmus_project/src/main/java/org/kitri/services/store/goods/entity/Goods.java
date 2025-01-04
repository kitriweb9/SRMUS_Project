package org.kitri.services.store.goods.entity;

public class Goods {
	private String goodsId;
	private String goodsCategoryId;
	private String goodsName;
	private int goodsPrice;
	private String goodsUnit;
	private String goodsFactoryId;
	
	public Goods() {
		
	}
	public Goods(String goodsId, String goodsCategoryId, String goodsName, int goodsPrice, String goodsUnit,
			String goodsFactoryId) {
		super();
		this.goodsId = goodsId;
		this.goodsCategoryId = goodsCategoryId;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsUnit = goodsUnit;
		this.goodsFactoryId = goodsFactoryId;
	}

	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsCategoryId() {
		return goodsCategoryId;
	}
	public void setGoodsCategoryId(String goodsCategoryId) {
		this.goodsCategoryId = goodsCategoryId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsUnit() {
		return goodsUnit;
	}
	public void setGoodsUnit(String goodsUnit) {
		this.goodsUnit = goodsUnit;
	}
	public String getGoodsFactoryId() {
		return goodsFactoryId;
	}
	public void setGoodsFactoryId(String goodsFactoryId) {
		this.goodsFactoryId = goodsFactoryId;
	}
}
