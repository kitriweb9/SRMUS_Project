package org.kitri.services.sales.store.service.impl;

import java.util.List;

import org.kitri.services.sales.store.dao.ShqMktMkiChkDao;
import org.kitri.services.sales.store.entity.Store;
import org.kitri.services.sales.store.service.ShqMktMkiChkSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShqMktMkiChkSvcImpl implements ShqMktMkiChkSvc {
	private ShqMktMkiChkDao shqMktMkiChkDao;

	@Autowired
	public ShqMktMkiChkSvcImpl(ShqMktMkiChkDao shqMktMkiChkDao) {
		super();
		this.shqMktMkiChkDao = shqMktMkiChkDao;
	}

	@Override
	public List<Store> getStoreList() {
		return shqMktMkiChkDao.findStoreList();
	}

}
