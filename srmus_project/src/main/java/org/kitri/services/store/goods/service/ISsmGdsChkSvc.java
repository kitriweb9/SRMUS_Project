package org.kitri.services.store.goods.service;

import java.util.List;

import org.kitri.services.store.repo.dto.SsmGdsChkDto;

public interface ISsmGdsChkSvc {
	public List<SsmGdsChkDto> findGoodsAll();
}
