package org.kitri.services.store.sale.service;

import java.util.List;

import org.kitri.services.store.repo.dto.SsmTxnSalAprDto;
import org.kitri.services.store.repo.dto.SsmTxnSalDto;

public interface ISsmTxnSalAprSvc {
	public void updateSalStatus(SsmTxnSalDto salDto);
}
