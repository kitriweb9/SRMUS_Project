package org.kitri.services.sales.goods.dao;

import java.util.List;

import org.kitri.services.sales.repo.dto.ShqPdtPdiChgCtgDto;
import org.kitri.services.sales.repo.dto.ShqPdtPdiChgDto;

public interface ShqPdtPdiChgDao {
	public List<ShqPdtPdiChgCtgDto> getCategories();

	public int updateGoodsInfo(ShqPdtPdiChgDto shqPdtPdiChgCtgDto);
}
