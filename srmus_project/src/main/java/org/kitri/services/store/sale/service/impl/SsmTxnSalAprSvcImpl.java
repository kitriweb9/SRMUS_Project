package org.kitri.services.store.sale.service.impl;

import org.kitri.services.store.sale.dao.ISsmTxnSalDao;
import org.kitri.services.store.sale.service.ISsmTxnSalAprSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SsmTxnSalAprSvcImpl implements ISsmTxnSalAprSvc {
	@Autowired
	public ISsmTxnSalDao sdao;

	@Override
	public void updateSalStatus(String salesId) {
		sdao.updateSalStatus(salesId);
	}

}
