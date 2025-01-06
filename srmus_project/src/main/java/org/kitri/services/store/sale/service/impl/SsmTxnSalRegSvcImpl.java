package org.kitri.services.store.sale.service.impl;

import java.util.List;

import org.kitri.services.store.repo.dto.SsmTxnPurRegDto;
import org.kitri.services.store.repo.dto.SsmTxnSalDto;
import org.kitri.services.store.sale.dao.ISsmTxnSalDao;
import org.kitri.services.store.sale.service.ISsmTxnSalRegSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SsmTxnSalRegSvcImpl implements ISsmTxnSalRegSvc {
	@Autowired
	public ISsmTxnSalDao sdao;

	@Override
	public String addSales(SsmTxnSalDto sdto) {
		sdao.addSales(sdto);
		return sdto.getSalesId();
		
	}

	@Override
	public void addSalesDetail(String salesId, List<SsmTxnPurRegDto> pdlist) {
		sdao.addSalesDetail(salesId, pdlist);
		
	}
}
