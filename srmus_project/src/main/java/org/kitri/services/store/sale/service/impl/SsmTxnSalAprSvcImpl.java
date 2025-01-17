package org.kitri.services.store.sale.service.impl;

import java.sql.Timestamp;

import javax.servlet.http.HttpSession;

import org.kitri.services.sales.repo.dto.SvcComEmpLgnDto;
import org.kitri.services.store.purchase.dao.ISsmTxnPurDao;
import org.kitri.services.store.repo.dto.SsmStkMgtChgDto;
import org.kitri.services.store.repo.dto.SsmTxnSalDto;
import org.kitri.services.store.sale.dao.ISsmTxnSalDao;
import org.kitri.services.store.sale.service.ISsmTxnSalAprSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SsmTxnSalAprSvcImpl implements ISsmTxnSalAprSvc {
	@Autowired
	private ISsmTxnSalDao salDao;
	@Autowired
	private ISsmTxnPurDao purDao;
	@Autowired
	HttpSession httpSession;
	
	@Override
	public void updateSalStatus(SsmTxnSalDto salDto) {
		Long datetime = System.currentTimeMillis();
		Timestamp timestamp = new Timestamp(datetime);
		SvcComEmpLgnDto svcComEmpLgnDto = (SvcComEmpLgnDto) httpSession.getAttribute("employee");
		salDto.setEmployeeId(svcComEmpLgnDto.getEmployeeId());
		salDto.setSalesStatus("Y");
		salDto.setSalesDate(timestamp);
		salDao.updateSalStatus(salDto);

		SsmStkMgtChgDto stockDto = new SsmStkMgtChgDto();
		stockDto.setGoodsId(salDto.getGoodsId());
		stockDto.setStoreId("ST001");
		stockDto.setStockQuantity(purDao.getStockByGId(salDto.getGoodsId())-salDto.getSalesQuantity());
		purDao.applyStock(stockDto);
		
		}
	}
