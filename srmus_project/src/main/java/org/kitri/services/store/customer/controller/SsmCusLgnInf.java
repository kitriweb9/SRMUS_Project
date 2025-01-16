package org.kitri.services.store.customer.controller;

import javax.servlet.http.HttpSession;

import org.kitri.services.sales.repo.dto.SvcComEmpLgnDto;
import org.kitri.services.store.customer.service.ISsmCusLgnSvc;
import org.kitri.services.store.repo.dto.SsmCusLgnDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SsmCusLgnInf {
	@Autowired
	ISsmCusLgnSvc cusSvc;

	@GetMapping("/userInfo")
	public String userInfo(Model model, HttpSession session) {
		if (session != null && session.getAttribute("loginType") != null) {
			String userType = (String) session.getAttribute("loginType");

			if ("employee".equals(userType)) {
				SvcComEmpLgnDto d = (SvcComEmpLgnDto) session.getAttribute("employee");
				model.addAttribute("info", d);
				return "store/customer/SsmCusLgnEInf";
			} else {
				SsmCusLgnDto d = (SsmCusLgnDto) session.getAttribute("user");
				model.addAttribute("info", d);

				return "store/customer/SsmCusLgnInf";
			}
		}
		return "store/customer/SsmCusLgnLin";
	}
}
