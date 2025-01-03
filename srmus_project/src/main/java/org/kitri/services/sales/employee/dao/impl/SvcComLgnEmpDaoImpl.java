package org.kitri.services.sales.employee.dao.impl;

import org.kitri.services.sales.employee.dao.ISvcComLgnEmpDao;
import org.kitri.services.sales.employee.dto.SvcComEmpDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SvcComLgnEmpDaoImpl implements ISvcComLgnEmpDao{
	@Autowired
	private SqlSessionTemplate sqlTemplate;

	@Override
	public SvcComEmpDto findEmployeeById(String id) {
		return sqlTemplate.selectOne("employee.inquiryByEmpNum", id);
	}
}
