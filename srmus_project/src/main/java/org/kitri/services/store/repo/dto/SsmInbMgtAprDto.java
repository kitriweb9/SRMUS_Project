package org.kitri.services.store.repo.dto;

public class SsmInbMgtAprDto {
	private String inboundId;

	public SsmInbMgtAprDto() {
	}

	public SsmInbMgtAprDto(String inboundId) {
		this.inboundId = inboundId;
	}

	public String getInboundId() {
		return inboundId;
	}

	public void setInboundId(String inboundId) {
		this.inboundId = inboundId;
	}
}
