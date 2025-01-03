package org.kitri.services.sales.employee.dao;

import org.kitri.services.sales.employee.dto.SvcComEmpDto;

public interface ISvcComEmpRegDao {
	String serviceGroupIdRegistration(SvcComEmpDto svcComEmpRegDto);
	
	int employeeRegistration(SvcComEmpDto svcComEmpRegDto);
}
