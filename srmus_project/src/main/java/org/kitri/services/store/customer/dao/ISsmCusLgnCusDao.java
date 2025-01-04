package org.kitri.services.store.customer.dao;

import org.kitri.services.store.repo.dto.SsmCusLgnDto;

public interface ISsmCusLgnCusDao {
	public SsmCusLgnDto findCustomerById(String id);
	public int insertCustomer(SsmCusLgnDto customer);
}
