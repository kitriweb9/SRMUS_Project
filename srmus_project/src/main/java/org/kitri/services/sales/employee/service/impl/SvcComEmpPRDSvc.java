package org.kitri.services.sales.employee.service.impl;

import java.util.List;

import org.kitri.services.sales.employee.dao.ISvcComEmpPRDDao;
import org.kitri.services.sales.employee.dto.SvcComEmpDepDto;
import org.kitri.services.sales.employee.dto.SvcComEmpPosDto;
import org.kitri.services.sales.employee.dto.SvcComEmpRolDto;
import org.kitri.services.sales.employee.service.ISvcComEmpPRDSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SvcComEmpPRDSvc implements ISvcComEmpPRDSvc {
	
	@Autowired
	private ISvcComEmpPRDDao iPrdDao;

	@Override
	public List<SvcComEmpPosDto> positionInquiry() {
		return iPrdDao.positionInquiry();
	}

	@Override
	public List<SvcComEmpRolDto> roleInquiry() {
		return iPrdDao.roleInquiry();
	}

	@Override
	public List<SvcComEmpDepDto> departmentInquiry() {
		return iPrdDao.departmentInquiry();
	}

}
