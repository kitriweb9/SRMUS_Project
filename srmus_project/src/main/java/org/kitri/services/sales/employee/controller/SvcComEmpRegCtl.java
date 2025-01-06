package org.kitri.services.sales.employee.controller;

import javax.servlet.http.HttpSession;

import org.kitri.services.common.login.session.SvcComLgnSsn;
import org.kitri.services.common.pageauth.SvcComPgcAcp;
import org.kitri.services.sales.employee.dto.SvcComEmpDto;
import org.kitri.services.sales.employee.service.ISvcComEmpInqSvc;
import org.kitri.services.sales.employee.service.ISvcComEmpPRDSvc;
import org.kitri.services.sales.employee.service.ISvcComEmpRegSvc;
import org.kitri.services.sales.repo.dto.SvcComEmpLgnDto;
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

	@Autowired
	private ISvcComEmpInqSvc iInqSvc;

	@Autowired
	private SvcComPgcAcp auth;

	@Autowired
	private SvcComLgnSsn sessionManager;

	@Autowired
	private HttpSession session;

	@GetMapping("/employee/add")
	public String showSignUpForm(Model model) {

		SvcComEmpLgnDto sessionEmployee = (SvcComEmpLgnDto) sessionManager.getValue(session, "user");

		if (sessionEmployee == null) {
			return "redirect:/employee/login";
		}

		if (!permissionCheck("ShqEmpEmiReg", sessionEmployee)) {
			return "includes/PermissionError";
		}
		setInputValue(model);
		return "/sales/employee/employeejoin";
	}

	@PostMapping("/employee/add")
	public String createEmployee(SvcComEmpDto regDto, Model model) {
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

	private boolean permissionCheck(String serviceId, SvcComEmpLgnDto sessionEmployee) {
		SvcComEmpDto svcComEmpDto = iInqSvc.employeeInquiryByFilters(sessionEmployee.getEmployeeId(), null, null, null)
				.get(0);
		if (!auth.hasAuthority(svcComEmpDto, serviceId)) {
			// 권한없음
			return false;
		}
		return true;
	}
}
