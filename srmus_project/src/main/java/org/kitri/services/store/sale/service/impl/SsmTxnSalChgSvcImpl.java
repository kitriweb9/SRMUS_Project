package org.kitri.services.store.sale.service.impl;

import org.kitri.services.store.repo.dto.SsmTxnSalDto;
import org.kitri.services.store.sale.dao.ISsmTxnSalDao;
import org.kitri.services.store.sale.service.ISsmTxnSalChgSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SsmTxnSalChgSvcImpl implements ISsmTxnSalChgSvc {
	@Autowired
	public ISsmTxnSalDao sdao;
	
	@Override
	public void updateSalQty(SsmTxnSalDto sdto) {
		sdao.updateSalQty(sdto);
		
	}

	@Override
	public void updateSalAmount(SsmTxnSalDto sdto) {
		sdao.updateSalAmount(sdto);
	}

}
