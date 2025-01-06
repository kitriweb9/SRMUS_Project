package org.kitri.services.sales.repo.dto;

public class ShqFinHqfChkDto {
	private String hqClosingId;
	private int hqClosingAmount;
	private String hqClosingDate;

	public ShqFinHqfChkDto() {
		super();
	}

	public ShqFinHqfChkDto(String hqClosingId, int hqClosingAmount, String hqClosingDate) {
		super();
		this.hqClosingId = hqClosingId;
		this.hqClosingAmount = hqClosingAmount;
		this.hqClosingDate = hqClosingDate;
	}

	public String getHqClosingId() {
		return hqClosingId;
	}

	public void setHqClosingId(String hqClosingId) {
		this.hqClosingId = hqClosingId;
	}

	public double getHqClosingAmount() {
		return hqClosingAmount;
	}

	public void setHqClosingAmount(int hqClosingAmount) {
		this.hqClosingAmount = hqClosingAmount;
	}

	public String getHqClosingDate() {
		return hqClosingDate;
	}

	public void setHqClosingDate(String hqClosingDate) {
		this.hqClosingDate = hqClosingDate;
	}

}
