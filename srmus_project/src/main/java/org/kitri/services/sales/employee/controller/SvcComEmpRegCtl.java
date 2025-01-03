package org.kitri.services.sales.employee.controller;

import org.kitri.services.sales.employee.dto.SvcComEmpDto;
import org.kitri.services.sales.employee.service.ISvcComEmpPRDSvc;
import org.kitri.services.sales.employee.service.ISvcComEmpRegSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SvcComEmpRegCtl {

	@Autowired
	private ISvcComEmpPRDSvc iPrdSvc;
	

	@Autowired
	private ISvcComEmpRegSvc iRegSvc;

	@GetMapping("/employeeregister")
	public String showSignUpForm(Model model) {
		setInputValue(model);
		return "/sales/employee/employeejoin";
	}

	@PostMapping("/employeeregister")
	public String createEmployee(SvcComEmpDto regDto, 
								 Model model) {
		String result = iRegSvc.employeeRegistration(regDto);
		model.addAttribute("registresult", result);
		setInputValue(model);
		return "/sales/employee/employeejoin";
	}
	
	private void setInputValue(Model model) {
		model.addAttribute("positions", iPrdSvc.positionInquiry());
		model.addAttribute("roles", iPrdSvc.roleInquiry());
		model.addAttribute("departments", iPrdSvc.departmentInquiry());
	}
}
