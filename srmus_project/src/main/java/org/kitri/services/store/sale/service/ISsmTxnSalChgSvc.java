package org.kitri.services.store.sale.service;

import org.kitri.services.store.repo.dto.SsmTxnSalDto;

public interface ISsmTxnSalChgSvc {
	public void updateSalQty(SsmTxnSalDto sdto);
	public void updateSalAmount(SsmTxnSalDto sdto);

}
