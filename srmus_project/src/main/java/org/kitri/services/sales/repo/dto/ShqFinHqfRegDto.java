package org.kitri.services.sales.repo.dto;

import java.sql.Timestamp;

public class ShqFinHqfRegDto {
	private int hqClosingAmount;
	private Timestamp hqClosingDate;

	public ShqFinHqfRegDto() {
		super();
	}

	public ShqFinHqfRegDto(int hqClosingAmount, Timestamp hqClosingDate) {
		super();
		this.hqClosingAmount = hqClosingAmount;
		this.hqClosingDate = hqClosingDate;
	}

	public double getHqClosingAmount() {
		return hqClosingAmount;
	}

	public void setHqClosingAmount(int hqClosingAmount) {
		this.hqClosingAmount = hqClosingAmount;
	}

	public Timestamp getHqClosingDate() {
		return hqClosingDate;
	}

	public void setHqClosingDate(Timestamp hqClosingDate) {
		this.hqClosingDate = hqClosingDate;
	}
}
