package org.kitri.services.store.sale.service;

import org.kitri.services.store.repo.dto.SsmTxnPurDto;

public interface ISsmTxnSalRegSvc {
	public void addSalesAndDetail(SsmTxnPurDto pdto);
}
