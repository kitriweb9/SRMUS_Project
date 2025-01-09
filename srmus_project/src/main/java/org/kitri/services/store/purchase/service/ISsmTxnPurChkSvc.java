package org.kitri.services.store.purchase.service;

import java.util.List;

import org.kitri.services.store.repo.dto.SsmTxnPurRegDto;

public interface ISsmTxnPurChkSvc {
	public String getPIdByCId(String customerId);
	public String getStatusByPid(String purchaseId);
	public String getPidByCidWithDate(String customerId);
	public Integer getGoodsQtyByPidAndGid(SsmTxnPurRegDto pdto);
	public SsmTxnPurRegDto getPurchaseByPId(String purchaseId);
	public List<SsmTxnPurRegDto> getPurchaseDetailByPId(String purchaseId);
	public List<SsmTxnPurRegDto> getCartByPId(String purchaseId);
}
