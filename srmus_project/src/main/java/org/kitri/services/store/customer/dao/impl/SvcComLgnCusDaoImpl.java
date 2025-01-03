package org.kitri.services.store.customer.dao.impl;

import java.util.Optional;

import org.kitri.services.store.customer.dao.ISvcComLgnCusDao;
import org.kitri.services.store.repo.dto.CustomerDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SvcComLgnCusDaoImpl implements ISvcComLgnCusDao {
	@Autowired
	private SqlSessionTemplate sqlTemplate;
	
	public CustomerDto findCustomerById(String id) {
		return sqlTemplate.selectOne("Customer.findCustomerLoginById", id);
	}
	
	public int insertCustomer(CustomerDto customer) {
		return sqlTemplate.insert("Customer.insertCustomer", customer);
	}
}
