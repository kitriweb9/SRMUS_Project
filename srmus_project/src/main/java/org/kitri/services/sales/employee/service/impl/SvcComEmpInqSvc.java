package org.kitri.services.sales.employee.service.impl;

import java.util.List;

import org.kitri.services.sales.employee.dao.ISvcComEmpInqDao;
import org.kitri.services.sales.employee.dto.SvcComEmpInqDto;
import org.kitri.services.sales.employee.service.ISvcComEmpInqSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SvcComEmpInqSvc implements ISvcComEmpInqSvc{

	@Autowired
	private ISvcComEmpInqDao iSvcComEmpInqDao;
	
	@Override
	public List<SvcComEmpInqDto> employeeInquiryByFilters(String employeeId, String positionId, String roleId, String departmentId) {
		List<SvcComEmpInqDto> inqDtos = null;
		if ((employeeId != null && !employeeId.isEmpty()) && (positionId == null || positionId.isEmpty()) && (roleId == null || roleId.isEmpty()) && (departmentId == null || departmentId.isEmpty())) {
        	inqDtos = iSvcComEmpInqDao.inquiryByEmpNum(employeeId);
        } 
		else if ((employeeId == null || employeeId.isEmpty()) && (positionId != null && !positionId.isEmpty()) && (roleId == null || roleId.isEmpty()) && (departmentId == null || departmentId.isEmpty())) {
			inqDtos = iSvcComEmpInqDao.inquiryByPositionId(positionId);
        }
		else if ((employeeId == null || employeeId.isEmpty()) && (positionId == null || positionId.isEmpty()) && (roleId != null && !roleId.isEmpty()) && (departmentId == null || departmentId.isEmpty())) {
        	inqDtos = iSvcComEmpInqDao.inquiryByRoleId(roleId);
        }
		else if ((employeeId == null || employeeId.isEmpty()) && (positionId == null || positionId.isEmpty()) && (roleId == null || roleId.isEmpty()) && (departmentId != null && !departmentId.isEmpty())) {
        	inqDtos = iSvcComEmpInqDao.inquiryByDepartmentId(departmentId);
        }
		else if ((employeeId == null || employeeId.isEmpty()) && (positionId != null && !positionId.isEmpty()) && (roleId != null && !roleId.isEmpty()) && (departmentId == null || departmentId.isEmpty())) {
        	inqDtos = iSvcComEmpInqDao.inquiryByPositionRoleId(positionId, roleId); 
        }
		else if ((employeeId == null || employeeId.isEmpty()) && (positionId != null && !positionId.isEmpty()) && (roleId == null || roleId.isEmpty()) && (departmentId != null && !departmentId.isEmpty())) {
			inqDtos = iSvcComEmpInqDao.inquiryByPositionDepartId(positionId, departmentId);
        }
		else if ((employeeId == null || employeeId.isEmpty()) && (positionId == null || positionId.isEmpty()) && (roleId != null && !roleId.isEmpty()) && (departmentId != null && !departmentId.isEmpty())) {
        	inqDtos = iSvcComEmpInqDao.inquiryByRoleDepartId(roleId, departmentId);
        }
		else if ((employeeId == null || employeeId.isEmpty()) && (positionId != null && !positionId.isEmpty()) && (roleId != null && !roleId.isEmpty()) && (departmentId != null && !departmentId.isEmpty())) {
        	inqDtos = iSvcComEmpInqDao.inquiryByPosRoleDepartId(positionId, roleId, departmentId);
        } else {
        	inqDtos = iSvcComEmpInqDao.inquiryOfAllEmp();
        }
        
        return inqDtos;
	}
}
