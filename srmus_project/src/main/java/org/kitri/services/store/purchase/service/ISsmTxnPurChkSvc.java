package org.kitri.services.store.purchase.service;

import java.util.List;

import org.kitri.services.store.repo.dto.SsmTxnPurDto;

public interface ISsmTxnPurChkSvc {
	public List<SsmTxnPurDto> getPurchaseY(SsmTxnPurDto pdto);
	public List<SsmTxnPurDto> getPurchaseN(SsmTxnPurDto pdto);
}
