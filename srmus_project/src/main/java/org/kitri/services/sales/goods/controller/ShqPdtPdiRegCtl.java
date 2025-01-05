package org.kitri.services.sales.goods.controller;

import javax.servlet.http.HttpSession;

import org.kitri.services.common.login.session.SvcComLgnSsn;
import org.kitri.services.common.pageauth.SvcComPgcAcp;
import org.kitri.services.sales.employee.dto.SvcComEmpDto;
import org.kitri.services.sales.employee.service.ISvcComEmpInqSvc;
import org.kitri.services.sales.goods.service.ShqPdtPdiChgSvc;
import org.kitri.services.sales.goods.service.ShqPdtPdiRegSvc;
import org.kitri.services.sales.repo.dto.ShqPdtPdiChgDto;
import org.kitri.services.sales.repo.dto.SvcComEmpLgnDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShqPdtPdiRegCtl {
	private ShqPdtPdiRegSvc shqPdtPdiRegSvc;

	private ShqPdtPdiChgSvc shqPdtPdiChgSvc;

	private ISvcComEmpInqSvc iInqSvc;

	private SvcComPgcAcp auth;

	private SvcComLgnSsn sessionManager;

	private HttpSession session;

	@Autowired
	public ShqPdtPdiRegCtl(ShqPdtPdiRegSvc shqPdtPdiRegSvc, ShqPdtPdiChgSvc shqPdtPdiChgSvc, ISvcComEmpInqSvc iInqSvc,
			SvcComPgcAcp auth, SvcComLgnSsn sessionManager, HttpSession session) {
		super();
		this.shqPdtPdiRegSvc = shqPdtPdiRegSvc;
		this.shqPdtPdiChgSvc = shqPdtPdiChgSvc;
		this.iInqSvc = iInqSvc;
		this.auth = auth;
		this.sessionManager = sessionManager;
		this.session = session;
	}

	@GetMapping("/registgoods")
	public String registStorePage(Model model) {
		SvcComEmpLgnDto sessionEmployee = (SvcComEmpLgnDto) sessionManager.getValue(session, "user");

		if (sessionEmployee == null) {
			return "redirect:/employee/login";
		}

		if (!permissionCheck("ShqPdtPdiReg", sessionEmployee)) {
			return "includes/PermissionError";
		}
		model.addAttribute("categoryList", shqPdtPdiChgSvc.getCategories());
		return "registgoods";
	}

	@PostMapping("/registgoods")
	public String registStoreInfo(@ModelAttribute ShqPdtPdiChgDto shqPdtPdiChgDto, Model model) {
		model.addAttribute("message", shqPdtPdiRegSvc.registGoodsInfo(shqPdtPdiChgDto));
		return "redirect:/goodslist";
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
