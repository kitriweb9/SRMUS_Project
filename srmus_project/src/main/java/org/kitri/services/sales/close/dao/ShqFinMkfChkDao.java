package org.kitri.services.sales.close.dao;

import java.util.List;

import org.kitri.services.sales.repo.dto.ShqFinMkfChkDto;

public interface ShqFinMkfChkDao {
	public List<ShqFinMkfChkDto> getMarketClosingInfo();

	public List<ShqFinMkfChkDto> findClosingInfoFilterByDate(String requestDate);
}
