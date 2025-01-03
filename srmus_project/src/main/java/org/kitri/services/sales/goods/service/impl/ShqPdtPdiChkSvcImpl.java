package org.kitri.services.sales.goods.service.impl;

import java.util.List;

import org.kitri.services.sales.goods.dao.ShqPdtPdiChkDao;
import org.kitri.services.sales.goods.service.ShqPdtPdiChkSvc;
import org.kitri.services.sales.repo.dto.ShqPdtPdiChkDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShqPdtPdiChkSvcImpl implements ShqPdtPdiChkSvc {
	private ShqPdtPdiChkDao shqPdtPdiChkDao;

	@Autowired
	public ShqPdtPdiChkSvcImpl(ShqPdtPdiChkDao shqPdtPdiChkDao) {
		super();
		this.shqPdtPdiChkDao = shqPdtPdiChkDao;
	}

	@Override
	public List<ShqPdtPdiChkDto> getGoodsList() {
		return shqPdtPdiChkDao.getGoodsList();
	}

}
