package org.kitri.services.store.goods.dao;

import java.util.List;

import org.kitri.services.store.repo.dto.SsmGdsChkDto;

public interface ISsmGdsChkDao {
	public List<SsmGdsChkDto> findGoodsAll();
}
