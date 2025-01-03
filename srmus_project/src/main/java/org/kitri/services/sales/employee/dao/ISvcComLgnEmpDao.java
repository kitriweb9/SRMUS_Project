package org.kitri.services.sales.employee.dao;

import org.kitri.services.sales.employee.dto.SvcComEmpDto;

public interface ISvcComLgnEmpDao {
	public SvcComEmpDto findEmployeeById(String id);
}
