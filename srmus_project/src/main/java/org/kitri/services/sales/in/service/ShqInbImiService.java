package org.kitri.services.sales.in.service;

import java.util.List;

import org.kitri.services.sales.repo.dto.ShqInbImiDto;

public interface ShqInbImiService {

	List<ShqInbImiDto> getIncomingInbound();
	
	List<ShqInbImiDto> getInbounds();

	boolean updateIncomingStocks(ShqInbImiDto updateDto);

	void approveStock(ShqInbImiDto reqDto);

	List<ShqInbImiDto> getApproveInbound();

}
