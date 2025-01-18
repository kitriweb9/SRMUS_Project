package org.kitri.services.store.sale.service.impl;

import java.util.List;

import org.kitri.services.store.repo.dto.SsmTxnSalDto;
import org.kitri.services.store.sale.dao.ISsmTxnSalDao;
import org.kitri.services.store.sale.service.ISsmTxnSalChkSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SsmTxnSalChkSvcImpl implements ISsmTxnSalChkSvc {
	@Autowired
	public ISsmTxnSalDao salDao;
	
	
	@Override
	public SsmTxnSalDto getSales(String purchaseId) {
		return salDao.getSales(purchaseId);
	}

	@Override
	public List<SsmTxnSalDto> getSalesListN(SsmTxnSalDto salDto) {
		salDto.setStoreId("ST001");
		salDto.setSalesStatus("N");
		return salDao.getSalesList(salDto);
	}
	
	@Override
	public List<SsmTxnSalDto> getSalesListY(SsmTxnSalDto salDto) {
		salDto.setStoreId("ST001");
		salDto.setSalesStatus("Y");
		return salDao.getSalesList(salDto);
	}	

	@Override
	public List<SsmTxnSalDto> getSalesCanceledList(SsmTxnSalDto salDto) {
		salDto.setStoreId("ST001");
		salDto.setSalesStatus("N");
		return salDao.getSalesCanceledList(salDto);
	}
}
