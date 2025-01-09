package org.kitri.services.store.sale.service;

import java.util.List;

import org.kitri.services.store.repo.dto.SsmTxnSalDto;

public interface ISsmTxnSalChkSvc {
	public List<SsmTxnSalDto> getSalesList(); 
	public List<SsmTxnSalDto> getSalesListByStore(String storeId);
	public String getSIdByPId(String purchaseId);
//	public int getSalSeqNextVal();
	

}
