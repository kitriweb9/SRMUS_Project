package org.kitri.services.store.purchase.service;

import org.kitri.services.store.repo.dto.SsmTxnPurDto;

public interface ISsmTxnPurRegSvc {
	public void addPurchaseAndDetail(SsmTxnPurDto pdto);
	
}
