package org.kitri.services.store.sreturn.service;

import org.kitri.services.store.repo.dto.SsmRtnSndDto;

public interface ISsmRtnMgtChgSvc {
	public void updateRtnGId(SsmRtnSndDto srdto);
	public void updateRtnQty(SsmRtnSndDto srdto);
	public void deleteReturn(String returnId);
	public void deleteReturnDetail(String returnId);

}
