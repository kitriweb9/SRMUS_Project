package org.kitri.services.store.purchase.service.impl;

import org.kitri.services.store.purchase.dao.ISsmTxnPurRegDao;
import org.kitri.services.store.purchase.service.ISsmTxnPurChgSvc;
import org.kitri.services.store.repo.dto.SsmTxnPurRegDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SsmTxnPurChgSvcImpl implements ISsmTxnPurChgSvc {
	@Autowired
	public ISsmTxnPurRegDao pdao;
	

	@Override
	public void updateGoodsQty(SsmTxnPurRegDto pdto) {
		pdao.updateGoodsQty(pdto);
	}

	@Override
	public void updateAmount(SsmTxnPurRegDto pdto) {
		pdao.updateAmount(pdto);
	}
	
	@Override
	public void updatePurchaseAmount(SsmTxnPurRegDto pdto) {
		pdao.updatePurchaseAmount(pdto);
	}
	@Override
	public void updatePStatusToY(String purchseId) {
		pdao.updatePStatusToY(purchseId);
	}

}
