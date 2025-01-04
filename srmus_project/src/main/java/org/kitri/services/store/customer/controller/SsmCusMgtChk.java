package org.kitri.services.store.customer.controller;

import javax.servlet.http.HttpSession;

import org.kitri.services.common.login.session.SvcComLgnSsn;
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
	SvcComLgnSsn svcComLgnSsn;
	@Autowired
	ISsmCusMgtSvc ssmCusMgtSvc;
	
	@GetMapping("/userInfoAll")
	public String userInfoAll(Model model, HttpSession session) {
//		SvcComEmpRegDto emp = (SvcComEmpRegDto) session.getAttribute("user");
//		
//		if(svcComPgcAcp.handleAuthorizedPage(emp, emp.getServiceGroupId()).equals("SsmCusMgtChk")) {
			model.addAttribute("customer", ssmCusMgtSvc.findCustomerAll());
			return "store/customer/SsmCusMgtChk";
//		}
//		
//		return "store/customer/SsmCusLgnLin";
	}
}
