package org.kitri.services.store.sale.service;

import java.util.List;

import org.kitri.services.store.repo.dto.SsmTxnSalDto;

public interface ISsmTxnSalChkSvc {
	public SsmTxnSalDto getSales(String purchaseId);
	public List<SsmTxnSalDto> getSalesListN(SsmTxnSalDto salDto);
	public List<SsmTxnSalDto> getSalesListY(SsmTxnSalDto salDto);
	public List<SsmTxnSalDto> getSalesCanceledList(SsmTxnSalDto salDto);
	

}
