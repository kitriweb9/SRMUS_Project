package org.kitri.services.store.sreturn.service.impl;

import org.kitri.services.store.sreturn.dao.ISsmRtnMgtDao;
import org.kitri.services.store.sreturn.service.ISsmRtnMgtAprSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SsmRtnMgtAprSvcImpl implements ISsmRtnMgtAprSvc {
	@Autowired
	private ISsmRtnMgtDao rdao;

	@Override
	public void updateRSatus(String returnId) {
		rdao.updateRSatus(returnId);
		
	}

}
