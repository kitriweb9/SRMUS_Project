package org.kitri.services.sales.store.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.kitri.services.common.login.session.SvcComLgnSsn;
import org.kitri.services.common.pageauth.SvcComPgcAcp;
import org.kitri.services.sales.employee.dto.SvcComEmpDto;
import org.kitri.services.sales.employee.service.ISvcComEmpInqSvc;
import org.kitri.services.sales.repo.dto.SvcComEmpLgnDto;
import org.kitri.services.sales.store.service.ShqMktMkiChkSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShqMktMkiChkCtl {

	private ShqMktMkiChkSvc shqMktMkiChkSvc;

	private ISvcComEmpInqSvc iInqSvc;

	private SvcComPgcAcp auth;

	private SvcComLgnSsn sessionManager;

	private HttpSession session;

	@Autowired
	public ShqMktMkiChkCtl(ShqMktMkiChkSvc shqMktMkiChkSvc, ISvcComEmpInqSvc iInqSvc, SvcComPgcAcp auth,
			SvcComLgnSsn sessionManager, HttpSession session) {
		super();
		this.shqMktMkiChkSvc = shqMktMkiChkSvc;
		this.iInqSvc = iInqSvc;
		this.auth = auth;
		this.sessionManager = sessionManager;
		this.session = session;
	}

	@GetMapping("/storelist")
	public String getStoreList(Model model) {

		SvcComEmpLgnDto sessionEmployee = (SvcComEmpLgnDto) sessionManager.getValue(session, "user");

		if (sessionEmployee == null) {
			return "redirect:/employee/login";
		}

		if (!permissionCheck("ShqMktMkiChk", sessionEmployee)) {
			return "includes/PermissionError";
		}

		// 수정권한 model객체에 담아서 전달
		model.addAttribute("canEdit", permissionCheck("ShqMktMkiChg", sessionEmployee));

		model.addAttribute("stores", shqMktMkiChkSvc.getStoreList());
		return "storelist";
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