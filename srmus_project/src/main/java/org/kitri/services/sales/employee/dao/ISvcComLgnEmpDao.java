package org.kitri.services.sales.employee.dao;

import org.kitri.services.sales.repo.dto.SvcComEmpLgnDto;

public interface ISvcComLgnEmpDao {
	public SvcComEmpLgnDto findEmployeeById(String id);
}
