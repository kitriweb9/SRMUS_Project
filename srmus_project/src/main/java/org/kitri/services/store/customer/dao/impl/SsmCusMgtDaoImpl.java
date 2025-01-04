package org.kitri.services.store.customer.dao.impl;

import java.util.List;

import org.kitri.services.store.customer.dao.ISsmCusMgtDao;
import org.kitri.services.store.repo.dto.SsmCusLgnDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SsmCusMgtDaoImpl implements ISsmCusMgtDao {
	@Autowired
	SqlSessionTemplate sqlTemplate;
	
	@Override
	public List<SsmCusLgnDto> findCustomerAll() {
		return sqlTemplate.selectList("Customer.findCustomerAll");
	}

	@Override
	public int updateCustomer(SsmCusLgnDto customer) {
		return sqlTemplate.update("Customer.updateCustomer");
	}

}
