package org.kitri.services.store.goods.service.impl;

import java.util.List;

import org.kitri.services.store.goods.dao.ISsmGdsChkDao;
import org.kitri.services.store.goods.service.ISsmGdsChkSvc;
import org.kitri.services.store.repo.dto.SsmGdsChkDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SsmGdsChkSvcImpl implements ISsmGdsChkSvc {
	@Autowired
	ISsmGdsChkDao goodsDao;
	
	public List<SsmGdsChkDto> findGoodsAll(){
		return goodsDao.findGoodsAll();
	}
}
