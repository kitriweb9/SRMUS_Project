package org.kitri.services.sales.employee.dao;

import java.util.List;

import org.kitri.services.sales.employee.dto.SvcComEmpInqDto;

public interface ISvcComEmpInqDao {
	List<SvcComEmpInqDto> inquiryOfAllEmp();
	
	List<SvcComEmpInqDto> inquiryByPositionId(String positionId);
	
	List<SvcComEmpInqDto> inquiryByRoleId(String roleId);
	
	List<SvcComEmpInqDto> inquiryByDepartmentId(String departmentId);
	
	List<SvcComEmpInqDto> inquiryByPositionRoleId(String positionId, String roleId);
	
	List<SvcComEmpInqDto> inquiryByPositionDepartId(String positionId, String departmentId);
	
	List<SvcComEmpInqDto> inquiryByRoleDepartId(String roleId, String departmentId);
	
	List<SvcComEmpInqDto> inquiryByPosRoleDepartId(String positionId, String roleId, String departmentId);
	
	List<SvcComEmpInqDto> inquiryByEmpNum(String employeeid);
}
