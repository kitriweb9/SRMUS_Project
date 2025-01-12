package org.kitri.services.store.purchase.service.impl;

import java.util.List;

import org.kitri.services.store.purchase.dao.ISsmTxnPurDao;
import org.kitri.services.store.purchase.service.ISsmTxnPurChkSvc;
import org.kitri.services.store.repo.dto.SsmTxnPurDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SsmTxnPurChkSvcImpl implements ISsmTxnPurChkSvc {
	@Autowired
	public ISsmTxnPurDao purDao;

	@Override
	public List<SsmTxnPurDto> getPurchaseY(SsmTxnPurDto purDto) {
		purDto.setPurchasePaymentStatus("Y");
		return purDao.getPurchaseByCIdAndStatus(purDto);
	}

	@Override
	public List<SsmTxnPurDto> getPurchaseN(SsmTxnPurDto purDto) {
		purDto.setPurchasePaymentStatus("N");
		return purDao.getPurchaseByCIdAndStatus(purDto);
	}
}
