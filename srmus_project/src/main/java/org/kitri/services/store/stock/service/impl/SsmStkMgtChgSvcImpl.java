package org.kitri.services.store.stock.service.impl;

import org.kitri.services.store.repo.dto.SsmStkMgtChgDto;
import org.kitri.services.store.stock.dao.ISsmStkMgtChgDao;
import org.kitri.services.store.stock.service.ISsmStkMgtChgSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SsmStkMgtChgSvcImpl implements ISsmStkMgtChgSvc {

	@Autowired
	private ISsmStkMgtChgDao chgDao;

	@Override
	public void updateStock(SsmStkMgtChgDto stockDto) {
		chgDao.updateStock(stockDto);
	}
}
