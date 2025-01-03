package org.kitri.services.sales.employee.dao.impl;

import org.kitri.services.sales.employee.dao.ISvcComEmpChaDao;
import org.kitri.services.sales.employee.dto.SvcComEmpChaDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SvcComEmpChaDao implements ISvcComEmpChaDao {

	@Autowired
	private SqlSessionTemplate sessionTemplate;

	@Override
	public int changByEmpPwd(SvcComEmpChaDto svcComEmpChaDto) {
		return sessionTemplate.update("employee.changByEmpPwd", svcComEmpChaDto);
	}
}
