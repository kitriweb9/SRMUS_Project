package org.kitri.services.sales.employee.service;

import java.util.List;

import org.kitri.services.sales.employee.dto.SvcComEmpInqDto;

public interface ISvcComEmpInqSvc{
	
	List<SvcComEmpInqDto> employeeInquiryByFilters(String employeeId, String positionId, String roleId, String departmentId);
	
}
