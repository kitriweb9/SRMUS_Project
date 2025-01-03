package org.kitri.services.sales.employee.dao;

import java.util.List;

import org.kitri.services.sales.employee.dto.SvcComEmpDepDto;
import org.kitri.services.sales.employee.dto.SvcComEmpPosDto;
import org.kitri.services.sales.employee.dto.SvcComEmpRolDto;

public interface ISvcComEmpPRDDao {
	List<SvcComEmpPosDto> positionInquiry();
	
	List<SvcComEmpRolDto> roleInquiry();
	
	List<SvcComEmpDepDto> departmentInquiry();
}
