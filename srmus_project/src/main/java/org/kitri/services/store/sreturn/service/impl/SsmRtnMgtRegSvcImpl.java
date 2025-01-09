package org.kitri.services.store.sreturn.service.impl;

import org.kitri.services.store.repo.dto.SsmRtnSndDto;
import org.kitri.services.store.sreturn.dao.ISsmRtnMgtDao;
import org.kitri.services.store.sreturn.service.ISsmRtnMgtRegSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SsmRtnMgtRegSvcImpl implements ISsmRtnMgtRegSvc {
	@Autowired
	private ISsmRtnMgtDao rdao;

	@Override
	public void addReturn(SsmRtnSndDto srdto) {
		rdao.addReturn(srdto);
		
	}

	@Override
	public void addReturnDetail(SsmRtnSndDto srdto) {
		rdao.addReturnDetail(srdto);
	}

}
