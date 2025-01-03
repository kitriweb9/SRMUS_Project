package org.kitri.services.sales.store.service.impl;

import org.kitri.services.sales.repo.dto.ShqMktMkiChgDto;
import org.kitri.services.sales.store.dao.ShqMktMkiChgDao;
import org.kitri.services.sales.store.service.ShqMktMkiChgSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShqMktMkiChgSvcImpl implements ShqMktMkiChgSvc {
	private ShqMktMkiChgDao shqMktMkiChgDao;

	@Autowired
	public ShqMktMkiChgSvcImpl(ShqMktMkiChgDao shqMktMkiChgDao) {
		super();
		this.shqMktMkiChgDao = shqMktMkiChgDao;
	}

	@Override
	public String updateStoreInfo(ShqMktMkiChgDto shqMktMkiChgDto) {
		if (shqMktMkiChgDao.updateStoreInfo(shqMktMkiChgDto) >= 1) {
			return "저장에 성공하였습니다.";
		}
		return "저장에 실패하였습니다.";
	}

}
