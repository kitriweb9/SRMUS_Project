package org.kitri.services.sales.employee.dao.impl;

import java.util.List;

import org.kitri.services.sales.employee.dao.ISvcComEmpPRDDao;
import org.kitri.services.sales.employee.dto.SvcComEmpDepDto;
import org.kitri.services.sales.employee.dto.SvcComEmpPosDto;
import org.kitri.services.sales.employee.dto.SvcComEmpRolDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SvcComEmpPRDDao implements ISvcComEmpPRDDao {

	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	@Override
	public List<SvcComEmpPosDto> positionInquiry() {
		return sessionTemplate.selectList("employeePRD.positionInquiry");
	}

	@Override
	public List<SvcComEmpRolDto> roleInquiry() {
		return sessionTemplate.selectList("employeePRD.roleInquiry");
	}

	@Override
	public List<SvcComEmpDepDto> departmentInquiry() {
		return sessionTemplate.selectList("employeePRD.departmentInquiry");
	}

}
