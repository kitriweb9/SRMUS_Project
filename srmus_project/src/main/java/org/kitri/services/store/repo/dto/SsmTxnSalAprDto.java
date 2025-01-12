package org.kitri.services.store.repo.dto;

public class SsmTxnSalAprDto {
	private String salesId;
	
	public SsmTxnSalAprDto() {}

	public SsmTxnSalAprDto(String salesId) {
		super();
		this.salesId = salesId;
	}

	public String getSalesId() {
		return salesId;
	}

	public void setSalesId(String salesId) {
		this.salesId = salesId;
	}
	
	
}
