package org.kitri.services.store.in.entity;

import java.sql.Timestamp;

public class Inbound {
	private String inboundId;
	private String employeeId;
	private String storeId;
	private Timestamp inboundDate;
	private Timestamp inboundConfirmDate;

	public Inbound() {
	}

	public Inbound(String inboundId, String employeeId, String storeId, Timestamp inboundDate,
			Timestamp inboundConfirmDate) {
		this.inboundId = inboundId;
		this.employeeId = employeeId;
		this.storeId = storeId;
		this.inboundDate = inboundDate;
		this.inboundConfirmDate = inboundConfirmDate;
	}

	public String getInboundId() {
		return inboundId;
	}

	public void setInboundId(String inboundId) {
		this.inboundId = inboundId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public java.sql.Timestamp getInboundDate() {
		return inboundDate;
	}

	public void setInboundDate(java.sql.Timestamp inboundDate) {
		this.inboundDate = inboundDate;
	}

	public java.sql.Timestamp getInboundConfirmDate() {
		return inboundConfirmDate;
	}

	public void setInboundConfirmDate(java.sql.Timestamp inboundConfirmDate) {
		this.inboundConfirmDate = inboundConfirmDate;
	}
}
