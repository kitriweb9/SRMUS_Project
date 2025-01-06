package org.kitri.services.store.sreturn.service;

import java.util.List;

import org.kitri.services.store.repo.dto.SsmRtnSndDto;

public interface ISsmRtnMgtChkSvc {
	public List<SsmRtnSndDto> getReturnList();
	public SsmRtnSndDto getReturnModiResult(String returnId);

}
