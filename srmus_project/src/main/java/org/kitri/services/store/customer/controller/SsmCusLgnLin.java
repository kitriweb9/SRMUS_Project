package org.kitri.services.store.customer.controller;

import javax.servlet.http.HttpSession;

import org.kitri.services.common.login.SvcComLgnLin;
import org.kitri.system.encryption.EncShaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SsmCusLgnLin {
	@Autowired
	SvcComLgnLin loginSvc;

	@GetMapping("/")
	public String welcome() {
		return "store/customer/SsmCusLgnLin";
	}

	@GetMapping("/customer/login")
	public String login() {
		return "store/customer/SsmCusLgnLin";
	}

	@PostMapping("/customer/login")
	public String login(HttpSession session, @RequestParam String id, @RequestParam String pwd,
			@RequestParam String loginType) {
		if (id.isEmpty() || pwd.isEmpty()) {
			return "store/customer/SsmCusLgnLin";
		}
		EncShaUtil sha = new EncShaUtil();

		pwd = sha.sha256(pwd);

		session.setAttribute("loginType", loginType);
		if (loginSvc.login(session, id, pwd, loginType)) {
			return "redirect:/customer/goods";
		}

		return "store/customer/SsmCusLgnLin";
	}
}
