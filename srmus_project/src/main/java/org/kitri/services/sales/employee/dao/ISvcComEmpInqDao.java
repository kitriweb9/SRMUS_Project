package org.kitri.services.sales.employee.dao;

import java.util.List;

import org.kitri.services.sales.employee.dto.SvcComEmpDto;

public interface ISvcComEmpInqDao {
	List<SvcComEmpDto> inquiryOfAllEmp();
	
	List<SvcComEmpDto> inquiryByPositionId(String positionId);
	
	List<SvcComEmpDto> inquiryByRoleId(String roleId);
	
	List<SvcComEmpDto> inquiryByDepartmentId(String departmentId);
	
	List<SvcComEmpDto> inquiryByPositionRoleId(String positionId, String roleId);
	
	List<SvcComEmpDto> inquiryByPositionDepartId(String positionId, String departmentId);
	
	List<SvcComEmpDto> inquiryByRoleDepartId(String roleId, String departmentId);
	
	List<SvcComEmpDto> inquiryByPosRoleDepartId(String positionId, String roleId, String departmentId);
	
	List<SvcComEmpDto> inquiryByEmpNum(String employeeid);
}
