package org.kitri.services.store.purchase.service.impl;

import org.kitri.services.store.purchase.dao.ISsmTxnPurRegDao;
import org.kitri.services.store.purchase.service.ISsmTxnPurRegSvc;
import org.kitri.services.store.repo.dto.SsmTxnPurRegDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SsmTxnPurRegSvcImpl implements ISsmTxnPurRegSvc {
	@Autowired
	public ISsmTxnPurRegDao pdao;
	
	
	@Override
	public void registPurchase(SsmTxnPurRegDto pdto) {
		pdao.addPurchase(pdto);		
	}

	@Override
	public void registPurchaseDetail(SsmTxnPurRegDto pdto) {
		pdao.addPurchaseDetail(pdto);		
	}
	

}
