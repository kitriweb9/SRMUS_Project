package org.kitri.services.store.purchase.service;

import org.kitri.services.store.repo.dto.SsmTxnPurDto;

public interface ISsmTxnPurChgSvc {
	public void modifyPurchaseStatus(SsmTxnPurDto purDto);
	public void deletePurchase(String purchaseId);
}
