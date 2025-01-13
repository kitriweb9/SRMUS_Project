package org.kitri.services.sales.employee.dao.impl;

import org.kitri.services.sales.employee.dao.ISvcComEmpRegDao;
import org.kitri.services.sales.employee.dto.SvcComEmpDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SvcComEmpRegDao implements ISvcComEmpRegDao {

	@Autowired
	private SqlSessionTemplate sessionTemplate;

	@Override
	public String serviceGroupIdRegistration(SvcComEmpDto svcComEmpDto) {
		return sessionTemplate.selectOne("employee.servicegroupRegistration", svcComEmpDto);
	}

	@Override
	public int employeeRegistration(SvcComEmpDto svcComEmpDto) {
		return sessionTemplate.insert("employee.employeeRegistration", svcComEmpDto);
	}

}
