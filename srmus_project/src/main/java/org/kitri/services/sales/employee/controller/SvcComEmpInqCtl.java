package org.kitri.services.sales.employee.controller;

import java.util.List;

import org.kitri.services.sales.employee.dto.SvcComEmpDepDto;
import org.kitri.services.sales.employee.dto.SvcComEmpInqDto;
import org.kitri.services.sales.employee.dto.SvcComEmpPosDto;
import org.kitri.services.sales.employee.dto.SvcComEmpRolDto;
import org.kitri.services.sales.employee.service.ISvcComEmpInqSvc;
import org.kitri.services.sales.employee.service.ISvcComEmpPRDSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SvcComEmpInqCtl {
	
	@Autowired
	private ISvcComEmpPRDSvc iPrdSvc;
	
	@Autowired
	private ISvcComEmpInqSvc iInqSvc;
	
	@RequestMapping("/employeeinquirypage")
	public String employeeInquiry(@RequestParam(required = false) String employeeId, @RequestParam(required = false) String positionId, @RequestParam(required = false) String roleId, @RequestParam(required = false) String departmentId, Model model) {
		List<SvcComEmpPosDto> posDtos = iPrdSvc.positionInquiry();
	    List<SvcComEmpRolDto> rolDtos = iPrdSvc.roleInquiry();
	    List<SvcComEmpDepDto> depDtos = iPrdSvc.departmentInquiry();
	    
	    model.addAttribute("positions", posDtos);
	    model.addAttribute("roles", rolDtos);
	    model.addAttribute("departments", depDtos);

	    List<SvcComEmpInqDto> inqDtos = iInqSvc.employeeInquiryByFilters(employeeId, positionId, roleId, departmentId);
	    
	    model.addAttribute("employeeList", inqDtos);
	    
	    return "/sales/employee/employeelist";
	}
}
