package org.kitri.services.store.purchase.service;

import org.kitri.services.store.repo.dto.SsmTxnPurDto;

public interface ISsmTxnPurChgSvc {
	public void modifyPurchaseStatus(SsmTxnPurDto pdto);
	public void deletePurchase(String purchaseId);
}
