package org.kitri.services.store.sale.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.kitri.services.store.repo.dto.SsmTxnSalDto;
import org.kitri.services.store.sale.dao.ISsmTxnSalDao;
import org.kitri.services.store.sale.service.ISsmTxnSalChkSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SsmTxnSalChkSvcImpl implements ISsmTxnSalChkSvc {
	@Autowired
	public ISsmTxnSalDao sdao;

	@Override
	public List<SsmTxnSalDto> getSalesList() {
		List<SsmTxnSalDto> slist = new ArrayList<SsmTxnSalDto>();
		return slist;
	}

	@Override
	public List<SsmTxnSalDto> getSalesListByStore(String storeId) {
		List<SsmTxnSalDto> slist = new ArrayList<SsmTxnSalDto>();
		slist=sdao.getSalesListByStore(storeId);
		return slist;
	}

	@Override
	public String getSIdByPId(String purchaseId) {
		String sid=sdao.getSIdByPId(purchaseId);
		return sid;
	}
	
}
