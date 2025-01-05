package org.kitri.services.sales.goods.controller;

import javax.servlet.http.HttpSession;

import org.kitri.services.common.login.session.SvcComLgnSsn;
import org.kitri.services.common.pageauth.SvcComPgcAcp;
import org.kitri.services.sales.employee.dto.SvcComEmpDto;
import org.kitri.services.sales.employee.service.ISvcComEmpInqSvc;
import org.kitri.services.sales.goods.service.ShqPdtPdiChgSvc;
import org.kitri.services.sales.goods.service.ShqPdtPdiChkSvc;
import org.kitri.services.sales.repo.dto.SvcComEmpLgnDto;
import org.kitri.services.sales.store.service.ShqMktMkiChkSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShqPdtPdiChkCtl {
	private ShqPdtPdiChkSvc shqPdtPdiChkSvc;

	private ShqPdtPdiChgSvc shqPdtPdiChgSvc;

	private ISvcComEmpInqSvc iInqSvc;

	private SvcComPgcAcp auth;

	private SvcComLgnSsn sessionManager;

	private HttpSession session;

	@Autowired
	public ShqPdtPdiChkCtl(ShqPdtPdiChkSvc shqPdtPdiChkSvc, ShqPdtPdiChgSvc shqPdtPdiChgSvc, ISvcComEmpInqSvc iInqSvc,
			SvcComPgcAcp auth, SvcComLgnSsn sessionManager, HttpSession session) {
		super();
		this.shqPdtPdiChkSvc = shqPdtPdiChkSvc;
		this.shqPdtPdiChgSvc = shqPdtPdiChgSvc;
		this.iInqSvc = iInqSvc;
		this.auth = auth;
		this.sessionManager = sessionManager;
		this.session = session;
	}

	@GetMapping("/goodslist")
	public String getGoodsList(Model model) {
		SvcComEmpLgnDto sessionEmployee = (SvcComEmpLgnDto) sessionManager.getValue(session, "user");

		if (sessionEmployee == null) {
			return "redirect:/employee/login";
		}

		if (!permissionCheck("ShqPdtPdiChk", sessionEmployee)) {
			return "includes/PermissionError";
		}
		model.addAttribute("canEdit", permissionCheck("ShqPdtPdiChg", sessionEmployee));
		model.addAttribute("goods", shqPdtPdiChkSvc.getGoodsList());
		model.addAttribute("categoryList", shqPdtPdiChgSvc.getCategories());
		return "goodslist";
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
