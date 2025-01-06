package org.kitri.services.sales.close.entity;

import java.sql.Timestamp;

public class HeadQuaterClosing {
	private String hqClosingId;
	private int hqClosingAmount;
	private Timestamp hqClosingDate;

	public HeadQuaterClosing() {
		super();
	}

	public HeadQuaterClosing(String hqClosingId, int hqClosingAmount, Timestamp hqClosingDate) {
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

	public int getHqClosingAmount() {
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
