package org.kitri.services.sales.employee.dao.impl;

import java.util.Optional;

import org.kitri.services.sales.employee.dao.ISvcComLgnEmpDao;
import org.kitri.services.sales.repo.dto.SvcComEmpLgnDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SvcComLgnEmpDaoImpl implements ISvcComLgnEmpDao{
	@Autowired
	private SqlSessionTemplate sqlTemplate;

	@Override
	public SvcComEmpLgnDto findEmployeeById(String id) {
		return sqlTemplate.selectOne("Employee.findEmployeeById", id);
	}
}
