package org.kitri.services.store.repo.dto;

public class SsmOrdGdoAprDto {
	private String orderId;

	public SsmOrdGdoAprDto() {
	}

	public SsmOrdGdoAprDto(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
}
