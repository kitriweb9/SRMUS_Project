package org.kitri.services.sales.close.dao;

import java.util.List;

import org.kitri.services.sales.repo.dto.ShqFinHqfChkDto;

public interface ShqFinHqfChkDao {
	public List<ShqFinHqfChkDto> getHqClosingInfo();
}
