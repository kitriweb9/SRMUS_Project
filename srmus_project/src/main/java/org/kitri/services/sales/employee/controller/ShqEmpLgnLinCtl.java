package org.kitri.services.sales.employee.controller;

import javax.servlet.http.HttpSession;

import org.kitri.services.common.login.login.SvcComLgnLin;
import org.kitri.services.sales.employee.dto.SvcComEmpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShqEmpLgnLinCtl {
	private final SvcComLgnLin svcComLgnLin;

	@Autowired
	public ShqEmpLgnLinCtl(SvcComLgnLin svcComLgnLin) {
		this.svcComLgnLin = svcComLgnLin;
	}

	@GetMapping("/employee/login")
	public String loginPage() {
		return "sales/common/login/login";
	}

	@PostMapping("/employee/login")
	public String login(Model model, @ModelAttribute SvcComEmpDto user, HttpSession session) {

		if (svcComLgnLin.login(session, user.getEmployeeId(), user.getEmployeePassword(), "employee")) {
			return "redirect:/inbound";
		} else {
			model.addAttribute("message", "아이디 또는 비밀번호가 틀립니다.");
			return "sales/common/login/login";
		}

	}
}
