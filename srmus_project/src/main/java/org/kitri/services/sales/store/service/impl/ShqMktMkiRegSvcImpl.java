package org.kitri.services.sales.store.service.impl;

import org.kitri.services.sales.repo.dto.ShqMktMkiChgDto;
import org.kitri.services.sales.store.dao.ShqMktMkiRegDao;
import org.kitri.services.sales.store.service.ShqMktMkiRegSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShqMktMkiRegSvcImpl implements ShqMktMkiRegSvc {
	private ShqMktMkiRegDao shqMktMkiRegDao;

	@Autowired
	public ShqMktMkiRegSvcImpl(ShqMktMkiRegDao shqMktMkiRegDao) {
		super();
		this.shqMktMkiRegDao = shqMktMkiRegDao;
	}

	@Override
	public String registStoreInfo(ShqMktMkiChgDto shqMktMkiChgDto) {
		if (shqMktMkiRegDao.registStoreInfo(shqMktMkiChgDto) >= 1) {
			return "등록에 성공하였습니다.";
		}
		return "등록에 실패하였습니다.";
	}

}
