package org.kitri.services.sales.employee.controller;

import javax.servlet.http.HttpSession;

import org.kitri.services.sales.employee.service.ISvcComEmpInqSvc;
import org.kitri.services.sales.repo.dto.SvcComEmpLgnDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShqEmpLgnInfCtl {
	private final ISvcComEmpInqSvc svcComEmpInqSvc;

	@Autowired
	public ShqEmpLgnInfCtl(ISvcComEmpInqSvc svcComEmpInqSvc) {
		super();
		this.svcComEmpInqSvc = svcComEmpInqSvc;
	}

	@GetMapping("/employee/mypage")
	public String viewMyPage(Model model, HttpSession session) {
		
		SvcComEmpLgnDto employee = (SvcComEmpLgnDto) session.getAttribute("employee");
		
		if(employee == null) {
			return "redirect:/employee/login";
		}
		
		model.addAttribute("employeeList",
				svcComEmpInqSvc.employeeInquiryByFilters(employee.getEmployeeId(), null, null, null));
		return "/sales/employee/mypage";
	}
}
