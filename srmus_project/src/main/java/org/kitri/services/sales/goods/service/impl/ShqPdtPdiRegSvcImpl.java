package org.kitri.services.sales.goods.service.impl;

import org.kitri.services.sales.goods.dao.ShqPdtPdiRegDao;
import org.kitri.services.sales.goods.service.ShqPdtPdiRegSvc;
import org.kitri.services.sales.repo.dto.ShqPdtPdiChgDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShqPdtPdiRegSvcImpl implements ShqPdtPdiRegSvc {
	private ShqPdtPdiRegDao shqPdtPdiRegDao;

	@Autowired
	public ShqPdtPdiRegSvcImpl(ShqPdtPdiRegDao shqPdtPdiRegDao) {
		super();
		this.shqPdtPdiRegDao = shqPdtPdiRegDao;
	}

	@Override
	public String registGoodsInfo(ShqPdtPdiChgDto shqPdtPdiChgDto) {
		if (shqPdtPdiRegDao.registGoodsInfo(shqPdtPdiChgDto) >= 1) {
			return "상품 등록을 성공하였습니다.";
		} else {
			return "상품 등록을 성공하였습니다.";
		}
	}

}
