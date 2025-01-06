package org.kitri.services.sales.close.service.impl;

import java.util.List;

import org.kitri.services.sales.close.dao.ShqFinMkfChkDao;
import org.kitri.services.sales.close.service.ShqFinMkfChkSvc;
import org.kitri.services.sales.repo.dto.ShqFinMkfChkDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShqFinMkfChkSvcImpl implements ShqFinMkfChkSvc {
	private ShqFinMkfChkDao shqFinMkfChkDao;

	@Autowired
	public ShqFinMkfChkSvcImpl(ShqFinMkfChkDao shqFinMkfChkDao) {
		super();
		this.shqFinMkfChkDao = shqFinMkfChkDao;
	}

	@Override
	public List<ShqFinMkfChkDto> getMarketClosingInfo() {
		return shqFinMkfChkDao.getMarketClosingInfo();
	}

	@Override
	public List<ShqFinMkfChkDto> findClosingInfoFilterByDate(String requestDate) {
		return shqFinMkfChkDao.findClosingInfoFilterByDate(requestDate);
	}

}
