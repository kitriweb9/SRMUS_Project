package org.kitri.services.store.sale.service;

import java.util.List;

import org.kitri.services.store.repo.dto.SsmTxnSalAprDto;

public interface ISsmTxnSalAprSvc {
	public void updateSalStatus(List<SsmTxnSalAprDto> salAprDtoList, String employeeId);
}
