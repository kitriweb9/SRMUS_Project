package org.kitri.services.store.purchase.service;

import org.kitri.services.store.repo.dto.SsmTxnPurRegDto;

public interface ISsmTxnPurChgSvc {
	public void updateGoodsQty(SsmTxnPurRegDto pdto);
	public void updateAmount(SsmTxnPurRegDto pdto);
	public void updatePurchaseAmount(SsmTxnPurRegDto pdto);
	public void updatePStatusToY(String purchaseId);
}
