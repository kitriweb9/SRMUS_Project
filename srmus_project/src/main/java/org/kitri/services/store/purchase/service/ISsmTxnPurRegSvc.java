package org.kitri.services.store.purchase.service;

import org.kitri.services.store.repo.dto.SsmTxnPurRegDto;

public interface ISsmTxnPurRegSvc {
	public void registPurchase(SsmTxnPurRegDto pdto);
	public void registPurchaseDetail(SsmTxnPurRegDto pdto);
	
}
