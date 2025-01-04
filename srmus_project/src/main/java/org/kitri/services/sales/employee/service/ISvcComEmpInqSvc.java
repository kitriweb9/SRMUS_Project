package org.kitri.services.sales.employee.service;

import java.util.List;

import org.kitri.services.sales.employee.dto.SvcComEmpDto;

public interface ISvcComEmpInqSvc{
	
	List<SvcComEmpDto> employeeInquiryByFilters(String employeeId, String positionId, String roleId, String departmentId);
	
}
