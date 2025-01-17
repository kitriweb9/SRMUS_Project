package org.kitri.services.store.sale.service;

import org.kitri.services.store.repo.dto.SsmTxnSalDto;

public interface ISsmTxnSalAprSvc {
	public void updateSalStatus(SsmTxnSalDto salDto);
}
