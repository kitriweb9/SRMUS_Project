package org.kitri.services.sales.employee.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kitri.services.sales.employee.dao.ISvcComEmpInqDao;
import org.kitri.services.sales.employee.dto.SvcComEmpDto;
import org.kitri.services.sales.employee.dto.SvcComEmpInqDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SvcComEmpInqDao implements ISvcComEmpInqDao{
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	@Override
	public List<SvcComEmpDto> inquiryOfAllEmp() {
		return sessionTemplate.selectList("employee.inquiryOfAllEmp");
	}


	@Override
	public List<SvcComEmpDto> inquiryByPositionId(String positionId) {
		return sessionTemplate.selectList("employee.inquiryByPositionId", positionId);
	}


	@Override
	public List<SvcComEmpDto> inquiryByRoleId(String roleId) {
		return sessionTemplate.selectList("employee.inquiryByRoleId", roleId);
	}


	@Override
	public List<SvcComEmpDto> inquiryByDepartmentId(String departmentId) {
		return sessionTemplate.selectList("employee.inquiryByDepartmentId", departmentId);
	}


	@Override
	public List<SvcComEmpDto> inquiryByPositionRoleId(String positionId, String roleId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("positionId", positionId); params.put("roleId", roleId);
		return sessionTemplate.selectList("employee.inquiryByPositionRoleId", params);
	}


	@Override
	public List<SvcComEmpDto> inquiryByPositionDepartId(String positionId, String departmentId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("positionId", positionId); params.put("departmentId", departmentId);
		return sessionTemplate.selectList("employee.inquiryByPositionDepartId", params);
	}


	@Override
	public List<SvcComEmpDto> inquiryByRoleDepartId(String roleId, String departmentId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("roleId", roleId); params.put("departmentId", departmentId);
		return sessionTemplate.selectList("employee.inquiryByRoleDepartId", params);
	}


	@Override
	public List<SvcComEmpDto> inquiryByPosRoleDepartId(String positionId, String roleId, String departmentId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("positionId", positionId); params.put("roleId", roleId); params.put("departmentId", departmentId); 
		return sessionTemplate.selectList("employee.inquiryByRoleDepartId", params);
	}
	
	@Override
	public List<SvcComEmpDto> inquiryByEmpNum(String employeeid) {
		return sessionTemplate.selectList("employee.inquiryByEmpNum", employeeid);
	}
}
