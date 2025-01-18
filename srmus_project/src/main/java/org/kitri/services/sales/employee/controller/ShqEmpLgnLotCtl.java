package org.kitri.services.sales.employee.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShqEmpLgnLotCtl {

	@GetMapping("employee/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "sales/common/login/login";
	}
}
