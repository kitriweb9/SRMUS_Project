package org.kitri.services.sales.in.service;

import java.util.List;

import org.kitri.services.sales.repo.dto.IntegrationInboundDto;

public interface ShqInbImiService {

	List<IntegrationInboundDto> getIncomingInbound();
	
	List<IntegrationInboundDto> getInbounds();

	boolean updateIncomingStocks(IntegrationInboundDto updateDto);

	void approveStock(IntegrationInboundDto reqDto);

	List<IntegrationInboundDto> getApproveInbound();

}
