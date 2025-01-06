package org.kitri.services.sales.employee.controller;

import javax.servlet.http.HttpSession;

import org.kitri.services.common.login.login.SvcComLgnLot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShqEmpLgnLotCtl {
	private final SvcComLgnLot svcComLgnLot;

	@Autowired
	public ShqEmpLgnLotCtl(SvcComLgnLot svcComLgnLot) {
		super();
		this.svcComLgnLot = svcComLgnLot;
	}

	@GetMapping("employee/logout")
	public String logout(HttpSession session) {
		if (svcComLgnLot.logout(session)) {
			return "sales/common/login/login";
		}
		
		return "sales/common/login/login";
	}
}
