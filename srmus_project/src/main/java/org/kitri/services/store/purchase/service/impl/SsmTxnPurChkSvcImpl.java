package org.kitri.services.store.purchase.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.kitri.services.store.purchase.dao.ISsmTxnPurRegDao;
import org.kitri.services.store.purchase.service.ISsmTxnPurChkSvc;
import org.kitri.services.store.repo.dto.SsmTxnPurRegDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SsmTxnPurChkSvcImpl implements ISsmTxnPurChkSvc {
	@Autowired
	public ISsmTxnPurRegDao pdao;

	@Override
	public String getPIdByCId(String customerId) {
		return pdao.getPIdByCid(customerId);
	}

	@Override
	public String getStatusByPid(String purchaseId) {
		return pdao.getStatusByPid(purchaseId);
	}

	@Override
	public String getPidByCidWithDate(String customerId) {
		return pdao.getPidByCidAndDate(customerId);
	}

	@Override
	public Integer getGoodsQtyByPidAndGid(SsmTxnPurRegDto pdto) {
		return pdao.getGoodsQtyByPidAndGid(pdto);
	}

	@Override
	public SsmTxnPurRegDto getPurchaseByPId(String purchaseId) {
		SsmTxnPurRegDto getpdto=pdao.getPurchaseByPId(purchaseId);
		return getpdto;
	}
	
	@Override
	public List<SsmTxnPurRegDto> getPurchaseDetailByPId(String purchaseId) {
		List<SsmTxnPurRegDto> pdlist = new ArrayList<SsmTxnPurRegDto>();
		pdlist=pdao.getPurchaseDetailByPId(purchaseId);
		return pdlist;
	}

	@Override
	public List<SsmTxnPurRegDto> getCartByPId(String purchaseId) {
		List<SsmTxnPurRegDto> cartlist = new ArrayList<SsmTxnPurRegDto>();
		cartlist=pdao.getCartByPId(purchaseId);
		return cartlist;
	}
}
