package org.kitri.services.sales.repo.dto;

public class ShqPdtPdiChkDto {
	private String goodsId;
	private String goodsCategoryId;
	private String goodsCategoryName;
	private String factoryId;
	private String goodsName;
	private int goodsCostPrice;
	private int goodsMarketPrice;
	private int goodsCustomerPrice;
	private String goodsUnit;

	public ShqPdtPdiChkDto() {
		super();
	}

	public ShqPdtPdiChkDto(String goodsId, String goodsCategoryId, String goodsCategoryName, String factoryId,
			String goodsName, int goodsCostPrice, int goodsMarketPrice, int goodsCustomerPrice, String goodsUnit) {
		super();
		this.goodsId = goodsId;
		this.goodsCategoryId = goodsCategoryId;
		this.goodsCategoryName = goodsCategoryName;
		this.factoryId = factoryId;
		this.goodsName = goodsName;
		this.goodsCostPrice = goodsCostPrice;
		this.goodsMarketPrice = goodsMarketPrice;
		this.goodsCustomerPrice = goodsCustomerPrice;
		this.goodsUnit = goodsUnit;
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

	public String getGoodsCategoryName() {
		return goodsCategoryName;
	}

	public void setGoodsCategoryName(String goodsCategoryName) {
		this.goodsCategoryName = goodsCategoryName;
	}

	public String getFactoryId() {
		return factoryId;
	}

	public void setFactoryId(String factoryId) {
		this.factoryId = factoryId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getGoodsCostPrice() {
		return goodsCostPrice;
	}

	public void setGoodsCostPrice(int goodsCostPrice) {
		this.goodsCostPrice = goodsCostPrice;
	}

	public int getGoodsMarketPrice() {
		return goodsMarketPrice;
	}

	public void setGoodsMarketPrice(int goodsMarketPrice) {
		this.goodsMarketPrice = goodsMarketPrice;
	}

	public int getGoodsCustomerPrice() {
		return goodsCustomerPrice;
	}

	public void setGoodsCustomerPrice(int goodsCustomerPrice) {
		this.goodsCustomerPrice = goodsCustomerPrice;
	}

	public String getGoodsUnit() {
		return goodsUnit;
	}

	public void setGoodsUnit(String goodsUnit) {
		this.goodsUnit = goodsUnit;
	}

}
