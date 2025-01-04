package org.kitri.services.store.customer.dao;

import java.util.List;

import org.kitri.services.store.repo.dto.SsmCusLgnDto;

public interface ISsmCusMgtDao {
	public List<SsmCusLgnDto> findCustomerAll();
	public int updateCustomer(SsmCusLgnDto customer);
}
