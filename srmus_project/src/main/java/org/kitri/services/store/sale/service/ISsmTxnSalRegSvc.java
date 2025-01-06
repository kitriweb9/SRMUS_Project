package org.kitri.services.store.sale.service;

import java.util.List;

import org.kitri.services.store.repo.dto.SsmTxnPurRegDto;
import org.kitri.services.store.repo.dto.SsmTxnSalDto;

public interface ISsmTxnSalRegSvc {
	public String addSales(SsmTxnSalDto sdto);
	public void addSalesDetail(String salesId, List<SsmTxnPurRegDto> pdlist);
}
