package org.kitri.services.store.sale.service.impl;

import org.kitri.services.store.sale.dao.ISsmTxnSalDao;
import org.kitri.services.store.sale.service.ISsmTxnSalChgSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SsmTxnSalChgSvcImpl implements ISsmTxnSalChgSvc {
	@Autowired
	private ISsmTxnSalDao salDao;

	@Override
	public void deleteSales(String salesId) {
		salDao.deleteSales(salesId);		
	}

}
