package org.kitri.services.sales.employee.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kitri.services.sales.employee.dao.ISvcComEmpInqDao;
import org.kitri.services.sales.employee.dto.SvcComEmpInqDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SvcComEmpInqDao implements ISvcComEmpInqDao{
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	@Override
	public List<SvcComEmpInqDto> inquiryOfAllEmp() {
		return sessionTemplate.selectList("employee.inquiryOfAllEmp");
	}


	@Override
	public List<SvcComEmpInqDto> inquiryByPositionId(String positionId) {
		return sessionTemplate.selectList("employee.inquiryByPositionId", positionId);
	}


	@Override
	public List<SvcComEmpInqDto> inquiryByRoleId(String roleId) {
		return sessionTemplate.selectList("employee.inquiryByRoleId", roleId);
	}


	@Override
	public List<SvcComEmpInqDto> inquiryByDepartmentId(String departmentId) {
		return sessionTemplate.selectList("employee.inquiryByDepartmentId", departmentId);
	}


	@Override
	public List<SvcComEmpInqDto> inquiryByPositionRoleId(String positionId, String roleId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("positionId", positionId); params.put("roleId", roleId);
		return sessionTemplate.selectList("employee.inquiryByPositionRoleId", params);
	}


	@Override
	public List<SvcComEmpInqDto> inquiryByPositionDepartId(String positionId, String departmentId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("positionId", positionId); params.put("departmentId", departmentId);
		return sessionTemplate.selectList("employee.inquiryByPositionDepartId", params);
	}


	@Override
	public List<SvcComEmpInqDto> inquiryByRoleDepartId(String roleId, String departmentId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("roleId", roleId); params.put("departmentId", departmentId);
		return sessionTemplate.selectList("employee.inquiryByRoleDepartId", params);
	}


	@Override
	public List<SvcComEmpInqDto> inquiryByPosRoleDepartId(String positionId, String roleId, String departmentId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("positionId", positionId); params.put("roleId", roleId); params.put("departmentId", departmentId); 
		return sessionTemplate.selectList("employee.inquiryByRoleDepartId", params);
	}
	
	@Override
	public List<SvcComEmpInqDto> inquiryByEmpNum(String employeeid) {
		return sessionTemplate.selectList("employee.inquiryByEmpNum", employeeid);
	}
}
