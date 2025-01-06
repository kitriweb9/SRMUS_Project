package org.kitri.services.sales.store.controller;

import javax.servlet.http.HttpSession;

import org.kitri.services.common.login.session.SvcComLgnSsn;
import org.kitri.services.common.pageauth.SvcComPgcAcp;
import org.kitri.services.sales.employee.dto.SvcComEmpDto;
import org.kitri.services.sales.employee.service.ISvcComEmpInqSvc;
import org.kitri.services.sales.repo.dto.ShqMktMkiChgDto;
import org.kitri.services.sales.repo.dto.SvcComEmpLgnDto;
import org.kitri.services.sales.store.service.ShqMktMkiRegSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShqMktMkiRegCtl {
	private ShqMktMkiRegSvc shqMktMkiRegSvc;

	private ISvcComEmpInqSvc iInqSvc;

	private SvcComPgcAcp auth;

	private SvcComLgnSsn sessionManager;

	private HttpSession session;

	@Autowired
	public ShqMktMkiRegCtl(ShqMktMkiRegSvc shqMktMkiRegSvc, ISvcComEmpInqSvc iInqSvc, SvcComPgcAcp auth,
			SvcComLgnSsn sessionManager, HttpSession session) {
		super();
		this.shqMktMkiRegSvc = shqMktMkiRegSvc;
		this.iInqSvc = iInqSvc;
		this.auth = auth;
		this.sessionManager = sessionManager;
		this.session = session;
	}

	@GetMapping("/registstore")
	public String registStorePage() {
		SvcComEmpLgnDto sessionEmployee = (SvcComEmpLgnDto) sessionManager.getValue(session, "user");

		if (sessionEmployee == null) {
			return "redirect:/employee/login";
		}

		if (!permissionCheck("ShqMktMkiReg", sessionEmployee)) {
			return "includes/PermissionError";
		}
		return "registstore";
	}

	@PostMapping("/registstore")
	public String registStoreInfo(@ModelAttribute ShqMktMkiChgDto shqMktMkiChgDto, Model model) {
		model.addAttribute("message", shqMktMkiRegSvc.registStoreInfo(shqMktMkiChgDto));
		return "redirect:/storelist";
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
