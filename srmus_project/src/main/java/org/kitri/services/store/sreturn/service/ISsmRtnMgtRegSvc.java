package org.kitri.services.store.sreturn.service;

import org.kitri.services.store.repo.dto.SsmRtnSndDto;

public interface ISsmRtnMgtRegSvc {
	public void addReturn(SsmRtnSndDto srdto);
	public void addReturnDetail(SsmRtnSndDto srdto);

}
