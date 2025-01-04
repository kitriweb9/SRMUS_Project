package org.kitri.services.store.customer.dao.impl;

import org.kitri.services.store.customer.dao.ISsmCusLgnCusDao;
import org.kitri.services.store.repo.dto.SsmCusLgnDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SsmCusLgnCusDaoImpl implements ISsmCusLgnCusDao {
	@Autowired
	private SqlSessionTemplate sqlTemplate;
	
	public SsmCusLgnDto findCustomerById(String id) {
		return sqlTemplate.selectOne("Customer.findCustomerLoginById", id);
	}
	
	public int insertCustomer(SsmCusLgnDto customer) {
		return sqlTemplate.insert("Customer.insertCustomer", customer);
	}
}
