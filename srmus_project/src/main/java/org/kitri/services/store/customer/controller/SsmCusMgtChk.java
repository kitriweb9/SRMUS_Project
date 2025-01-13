package org.kitri.services.store.customer.controller;

import javax.servlet.http.HttpSession;

import org.kitri.services.common.pageauth.SvcComPgcAcp;
import org.kitri.services.store.customer.service.ISsmCusMgtSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SsmCusMgtChk {
	@Autowired
	SvcComPgcAcp svcComPgcAcp;
	@Autowired
	ISsmCusMgtSvc ssmCusMgtSvc;

	@GetMapping("/userInfoAll")
	public String userInfoAll(Model model, HttpSession session) {
		model.addAttribute("customer", ssmCusMgtSvc.findCustomerAll());
		
		return "store/customer/SsmCusMgtChk";
	}
}
