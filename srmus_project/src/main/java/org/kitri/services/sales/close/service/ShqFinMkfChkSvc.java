package org.kitri.services.sales.close.service;

import java.util.List;

import org.kitri.services.sales.repo.dto.ShqFinMkfChkDto;

public interface ShqFinMkfChkSvc {
	public List<ShqFinMkfChkDto> getMarketClosingInfo();

	public List<ShqFinMkfChkDto> findClosingInfoFilterByDate(String requestDate);
}
