package org.kitri.services.sales.close.service.impl;

import java.util.List;

import org.kitri.services.sales.close.dao.ShqFinHqfChkDao;
import org.kitri.services.sales.close.service.ShqFinHqfChkSvc;
import org.kitri.services.sales.repo.dto.ShqFinHqfChkDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShqFinHqfChkSvcImpl implements ShqFinHqfChkSvc {
	private ShqFinHqfChkDao shqFinHqfChkDao;

	@Autowired
	public ShqFinHqfChkSvcImpl(ShqFinHqfChkDao shqFinHqfChkDao) {
		super();
		this.shqFinHqfChkDao = shqFinHqfChkDao;
	}

	@Override
	public List<ShqFinHqfChkDto> getHqClosingInfo() {
		return shqFinHqfChkDao.getHqClosingInfo();
	}

}
