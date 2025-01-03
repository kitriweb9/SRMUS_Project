package org.kitri.services.sales.goods.service;

import java.util.List;

import org.kitri.services.sales.repo.dto.ShqPdtPdiChgCtgDto;
import org.kitri.services.sales.repo.dto.ShqPdtPdiChgDto;

public interface ShqPdtPdiChgSvc {
	public List<ShqPdtPdiChgCtgDto> getCategories();

	public String updateGoodsInfo(ShqPdtPdiChgDto shqPdtPdiChgDto);
}
