package org.kitri.services.store.sale.service.impl;

import java.util.List;

import org.kitri.services.store.repo.dto.SsmTxnPurDto;
import org.kitri.services.store.repo.dto.SsmTxnSalDto;
import org.kitri.services.store.sale.dao.ISsmTxnSalDao;
import org.kitri.services.store.sale.entity.Sales;
import org.kitri.services.store.sale.entity.SalesDetail;
import org.kitri.services.store.sale.service.ISsmTxnSalRegSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SsmTxnSalRegSvcImpl implements ISsmTxnSalRegSvc {
	@Autowired
	public ISsmTxnSalDao salDao;

	@Override
	public void addSalesAndDetail(SsmTxnPurDto purDto) {
        int seq=salDao.getSalSeqNextVal();
        String seqStr = String.format("%03d", seq);
        String salesId="SL"+seqStr;
    		
        Sales sales = new Sales();
        sales.setSalesId(salesId);
        sales.setPurchaseId(purDto.getPurchaseId());
        sales.setStoreId("ST001");
        sales.setEmployeeId(null);
        sales.setSalesAmount(Long.valueOf(purDto.getPurchaseAmount()));
        sales.setSalesDate(null);
        salDao.addSales(sales);
        
        SalesDetail salesDetail = new SalesDetail();
        salesDetail.setSalesId(salesId);
        salesDetail.setGoodsId(purDto.getGoodsId());
        salesDetail.setSalesQuantity(purDto.getPurchaseQuantity());
        salesDetail.setSalesStatus("N");
        salDao.addSalesDetail(salesDetail);
        
		
	}
}
