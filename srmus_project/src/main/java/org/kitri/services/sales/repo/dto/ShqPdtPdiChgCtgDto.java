package org.kitri.services.sales.repo.dto;

public class ShqPdtPdiChgCtgDto {
	private String goodsCategoryid;
	private String goodsCategoryName;

	public ShqPdtPdiChgCtgDto(String goodsCategoryid, String goodsCategoryName) {
		super();
		this.goodsCategoryid = goodsCategoryid;
		this.goodsCategoryName = goodsCategoryName;
	}

	public String getGoodsCategoryid() {
		return goodsCategoryid;
	}

	public void setGoodsCategoryid(String goodsCategoryid) {
		this.goodsCategoryid = goodsCategoryid;
	}

	public String getGoodsCategoryName() {
		return goodsCategoryName;
	}

	public void setGoodsCategoryName(String goodsCategoryName) {
		this.goodsCategoryName = goodsCategoryName;
	}

}
