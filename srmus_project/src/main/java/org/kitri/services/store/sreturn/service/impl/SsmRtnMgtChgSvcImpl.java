package org.kitri.services.store.sreturn.service.impl;

import org.kitri.services.store.repo.dto.SsmRtnSndDto;
import org.kitri.services.store.sreturn.dao.ISsmRtnMgtDao;
import org.kitri.services.store.sreturn.service.ISsmRtnMgtChgSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SsmRtnMgtChgSvcImpl implements ISsmRtnMgtChgSvc {
	@Autowired
	private ISsmRtnMgtDao rdao;

	@Override
	public void updateRtnGId(SsmRtnSndDto srdto) {
		rdao.updateRtnGId(srdto);
		
	}

	@Override
	public void updateRtnQty(SsmRtnSndDto srdto) {
		rdao.updateRtnQty(srdto);
		
	}

	@Override
	public void deleteReturn(String returnId) {
		rdao.deleteReturn(returnId);
		
	}

	@Override
	public void deleteReturnDetail(String returnId) {
		rdao.deleteReturnDetail(returnId);
	}

}
