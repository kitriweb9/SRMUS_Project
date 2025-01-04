package org.kitri.services.store.customer.controller;

import javax.servlet.http.HttpSession;

import org.kitri.services.common.pageauth.SvcComPgcAcp;
import org.kitri.services.sales.repo.dto.SvcComEmpRegDto;
import org.kitri.services.store.customer.dao.ISsmCusLgnCusDao;
import org.kitri.services.store.customer.service.ISsmCusMgtSvc;
import org.kitri.services.store.repo.dto.SsmCusLgnDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SsmCusMgtChg {
	@Autowired
	SvcComPgcAcp svcComPgcAcp;
	@Autowired
	ISsmCusMgtSvc mgtSvc;
	@Autowired
	ISsmCusLgnCusDao cusDao;
	
	/*
	 * 작동 안 되는게 맞습니다! 오류 파악을 못 하겠어서 일단 오류만 안 나도록 수정했습니다 
	 */
	
	@GetMapping("/updateUserInfo")
	public String updateUserInfo(Model model, HttpSession session, @RequestParam String id) {
//		SvcComEmpRegDto emp = (SvcComEmpRegDto) session.getAttribute("user");
//		
//		if(svcComPgcAcp.handleAuthorizedPage(emp, emp.getServiceGroupId()).equals("SsmCusMgtChg")) {
			model.addAttribute("id", id);
			return "store/customer/SsmCusMgtChg";
//		}
//		return "store/customer/SsmCusLgnInf";
	}
	
	@PostMapping("/updateUserInfo")
	public String updateUserInfo(HttpSession session, @ModelAttribute SsmCusLgnDto cusInput) {
//		SvcComEmpRegDto emp = (SvcComEmpRegDto) session.getAttribute("user");
		
		SsmCusLgnDto customer = cusDao.findCustomerById(cusInput.getId());
		
		if(cusInput.getName() != null) {
			customer.setName(cusInput.getName());
		}
		
		if(cusInput.getAddress() != null) {
			customer.setAddress(cusInput.getAddress());
		}
		
		if(cusInput.getContact() != null) {
			customer.setContact(cusInput.getContact());
		}
		
		if(cusInput.getEmail() != null) {
			customer.setEmail(cusInput.getEmail());
		}
		
//		if(svcComPgcAcp.handleAuthorizedPage(emp, emp.getServiceGroupId()).equals("SsmCusMgtChg")) {
			if(mgtSvc.updateCustomer(customer)) {
				return "redirect: userInfoAll";
			} else {
				return "redirect: userInfoAll";
			}
//		}
//		return "store/customer/SsmCusLgnInf";
	}
}
