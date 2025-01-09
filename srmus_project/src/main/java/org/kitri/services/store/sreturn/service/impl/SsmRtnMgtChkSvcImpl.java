package org.kitri.services.store.sreturn.service.impl;

import java.util.List;

import org.kitri.services.store.repo.dto.SsmRtnSndDto;
import org.kitri.services.store.sreturn.dao.ISsmRtnMgtDao;
import org.kitri.services.store.sreturn.service.ISsmRtnMgtChkSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SsmRtnMgtChkSvcImpl implements ISsmRtnMgtChkSvc {
	@Autowired
	private ISsmRtnMgtDao rdao;

	@Override
	public List<SsmRtnSndDto> getReturnList() {
		List<SsmRtnSndDto> rlist = rdao.getReturnList();
		return rlist;
	}

	@Override
	public SsmRtnSndDto getReturnModiResult(String returnId) {
		SsmRtnSndDto modirdto = rdao.getReturnModiResult(returnId);
		return modirdto;
	}

}
