package org.kitri.services.sales.goods.service.impl;

import java.util.List;

import org.kitri.services.sales.goods.dao.ShqPdtPdiChgDao;
import org.kitri.services.sales.goods.service.ShqPdtPdiChgSvc;
import org.kitri.services.sales.repo.dto.ShqPdtPdiChgCtgDto;
import org.kitri.services.sales.repo.dto.ShqPdtPdiChgDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShqPdtPdiChgSvcImpl implements ShqPdtPdiChgSvc {
	private ShqPdtPdiChgDao shqPdtPdiChgDao;

	@Autowired
	public ShqPdtPdiChgSvcImpl(ShqPdtPdiChgDao shqPdtPdiChgDao) {
		super();
		this.shqPdtPdiChgDao = shqPdtPdiChgDao;
	}

	@Override
	public List<ShqPdtPdiChgCtgDto> getCategories() {
		return shqPdtPdiChgDao.getCategories();
	}

	@Override
	public String updateGoodsInfo(ShqPdtPdiChgDto shqPdtPdiChgDto) {
		if (shqPdtPdiChgDao.updateGoodsInfo(shqPdtPdiChgDto) >= 1) {
			return "수정에 성공하였습니다.";
		} else {
			return "수정에 실패하였습니다.";
		}

	}

}
