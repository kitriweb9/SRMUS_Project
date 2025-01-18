package org.kitri.services.store.purchase.service.impl;

import java.sql.Timestamp;

import org.kitri.services.store.purchase.dao.ISsmTxnPurDao;
import org.kitri.services.store.purchase.service.ISsmTxnPurChgSvc;
import org.kitri.services.store.repo.dto.SsmStkMgtChgDto;
import org.kitri.services.store.repo.dto.SsmTxnPurDto;
import org.kitri.services.store.sale.service.ISsmTxnSalAprSvc;
import org.kitri.services.store.sale.service.ISsmTxnSalChkSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SsmTxnPurChgSvcImpl implements ISsmTxnPurChgSvc {
	@Autowired
	private ISsmTxnPurDao purDao;
	@Autowired
	private ISsmTxnSalChkSvc salChkSvc;
	@Autowired
	private ISsmTxnSalAprSvc salAprSvc;

	@Override
	public void modifyPurchaseStatus(SsmTxnPurDto purDto) {
		Long datetime = System.currentTimeMillis();
		Timestamp timestamp = new Timestamp(datetime);
		purDto.setPurchasePaymentStatus("N");
		purDto.setPurchaseDate(timestamp);
		purDao.modifyPurchaseStatus(purDto);
		String salesId=salChkSvc.getSales(purDto.getPurchaseId()).getSalesId();
		String salesStatus=salChkSvc.getSales(purDto.getPurchaseId()).getSalesStatus();
		if("Y".equals(salesStatus)) {
			salAprSvc.updateSalStatusToN(salesId);
			SsmStkMgtChgDto stockDto = new SsmStkMgtChgDto();
			stockDto.setGoodsId(purDto.getGoodsId());
			stockDto.setStoreId("ST001");
			stockDto.setStockQuantity(purDao.getStockByGId(purDto.getGoodsId())+purDto.getPurchaseQuantity());
			purDao.applyStock(stockDto);
		}
	}
}
