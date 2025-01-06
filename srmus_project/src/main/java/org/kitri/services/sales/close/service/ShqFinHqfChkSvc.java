package org.kitri.services.sales.close.service;

import java.util.List;

import org.kitri.services.sales.repo.dto.ShqFinHqfChkDto;

public interface ShqFinHqfChkSvc {
	public List<ShqFinHqfChkDto> getHqClosingInfo();
}
