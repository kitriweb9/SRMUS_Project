package org.kitri.services.store.customer.dao;

import org.kitri.services.store.repo.dto.CustomerDto;

public interface ISvcComLgnCusDao {
	public CustomerDto findCustomerById(String id);
	public int insertCustomer(CustomerDto customer);
}
