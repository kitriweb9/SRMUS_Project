package org.kitri.services.sales.ordered.dto;

public class ShqIgoRegIIDto {
	private String integrationConfirmDate;
	private String goodsName;
	private int totalQuantity;

	public ShqIgoRegIIDto() {
		super();
	}

	public ShqIgoRegIIDto(String integrationConfirmDate, String goodsName, int totalQuantity) {
		super();
		this.integrationConfirmDate = integrationConfirmDate;
		this.goodsName = goodsName;
		this.totalQuantity = totalQuantity;
	}

	public String getIntegrationConfirmDate() {
		return integrationConfirmDate;
	}

	public void setIntegrationConfirmDate(String integrationConfirmDate) {
		this.integrationConfirmDate = integrationConfirmDate;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

}
