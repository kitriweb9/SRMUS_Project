package org.kitri.services.store.customer.service;

import java.util.List;

import org.kitri.services.store.repo.dto.SsmCusLgnDto;

public interface ISsmCusMgtSvc {
	public List<SsmCusLgnDto> findCustomerAll();
	public boolean updateCustomer(SsmCusLgnDto customer);
}
