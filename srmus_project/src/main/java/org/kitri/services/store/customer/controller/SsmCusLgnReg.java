package org.kitri.services.store.customer.controller;

import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.http.HttpSession;

import org.kitri.services.store.customer.service.ISsmCusLgnSvc;
import org.kitri.services.store.repo.dto.SsmCusLgnDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SsmCusLgnReg {
	@Autowired
	ISsmCusLgnSvc loginSvc;
	
	@GetMapping("/register")
	public String register(Model model) {
		return "store/customer/SsmCusLgnReg";
	}
	
	@PostMapping("/register")
	public String register(Model model, HttpSession session, @ModelAttribute SsmCusLgnDto cus) {
		try {
			boolean result = loginSvc.register(cus);
			
			if(result) {
				return "store/customer/SsmCusLgnLin";
			}
			
			return "store/customer/SsmCusLgnReg";
			
		} catch (SQLIntegrityConstraintViolationException e) {
			// TODO: handle exception
			e.printStackTrace();
			
			return "store/customer/SsmCusLgnReg";
		}
	}
}
