package org.kitri.services.store.sale.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.kitri.services.store.repo.dto.SsmStkMgtChgDto;
import org.kitri.services.store.repo.dto.SsmTxnSalAprDto;
import org.kitri.services.store.repo.dto.SsmTxnSalDto;
import org.kitri.services.store.sale.dao.ISsmTxnSalDao;
import org.kitri.services.store.sale.service.ISsmTxnSalAprSvc;
import org.kitri.services.store.stock.service.ISsmStkMgtChgSvc;
import org.kitri.services.store.stock.service.ISsmStkMgtChkSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SsmTxnSalAprSvcImpl implements ISsmTxnSalAprSvc {
	@Autowired
	private ISsmTxnSalDao salDao;
	@Autowired
	private ISsmStkMgtChgSvc stkChgSvc;
	@Autowired
	private ISsmStkMgtChkSvc stkChkSvc;

	@Override
	public void updateSalStatus(List<SsmTxnSalAprDto> salAprDtoList, String employeeId) {
		Long datetime;
		Timestamp timestamp;
		
		for(SsmTxnSalAprDto salAprDto : salAprDtoList) {
		datetime = System.currentTimeMillis();
		timestamp = new Timestamp(datetime);
		SsmTxnSalDto salDto = new SsmTxnSalDto();
		salDto.setSalesId(salAprDto.getSalesId());
		salDto.setEmployeeId(employeeId);
		salDto.setSalesStatus("Y");
		salDto.setSalesDate(timestamp);
		salDao.updateSalStatus(salDto);

		SsmStkMgtChgDto stockDto = new SsmStkMgtChgDto();
		stockDto.setGoodsId(salDto.getGoodsId());
		stockDto.setStoreId("ST001");
		stockDto.setStockQuantity((stkChkSvc.getAllStocks().get(0).getStockQuantity())-salDto.getSalesQuantity());
		stkChgSvc.updateStock(stockDto);
		
		}
	}
	

}
