package org.kitri.services.store.purchase.service.impl;

import java.sql.Timestamp;

import org.kitri.services.store.purchase.dao.ISsmTxnPurDao;
import org.kitri.services.store.purchase.entity.Purchase;
import org.kitri.services.store.purchase.entity.PurchaseDetail;
import org.kitri.services.store.purchase.service.ISsmTxnPurRegSvc;
import org.kitri.services.store.repo.dto.SsmTxnPurDto;
import org.kitri.services.store.sale.service.ISsmTxnSalRegSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SsmTxnPurRegSvcImpl implements ISsmTxnPurRegSvc {
	@Autowired
	private ISsmTxnPurDao purDao;
	@Autowired
	private ISsmTxnSalRegSvc salRegSvc;

	@Override
	public void addPurchaseAndDetail(SsmTxnPurDto purDto) {
		Long datetime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(datetime);
        int seq=purDao.getPurSeqNextVal();
        String seqStr = String.format("%03d", seq);
        String purchaseId="PC"+seqStr;
        
		Purchase purchase = new Purchase();
		purchase.setPurchaseId(purchaseId);		
		purchase.setCustomerId(purDto.getCustomerId());
		purchase.setStoreId("ST001");
		purchase.setPurchaseAmount(purDto.getPurchaseQuantity()*purDto.getGoodsPrice());
		purchase.setPurchaseDate(timestamp);
		purDao.addPurchase(purchase);
		
		PurchaseDetail purchaseDetail=new PurchaseDetail();
		purchaseDetail.setPurchaseId(purchaseId);
		purchaseDetail.setGoodsId(purDto.getGoodsId());
		purchaseDetail.setPurchaseQuantity(purDto.getPurchaseQuantity());
		purchaseDetail.setPurchasePaymentStatus("Y");
		purDao.addPurchaseDetail(purchaseDetail);
		
		purDto.setPurchaseAmount(purchase.getPurchaseAmount());
		purDto.setPurchaseId(purchaseId);
		
		salRegSvc.addSalesAndDetail(purDto);
	}

	

}
