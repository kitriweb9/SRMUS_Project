package org.kitri.services.sales.employee.controller;

import javax.servlet.http.HttpSession;

import org.kitri.services.common.pageauth.intercepter.RequiresAuthority;
import org.kitri.services.sales.employee.dto.SvcComEmpChaDto;
import org.kitri.services.sales.employee.service.ISvcComEmpChaSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SvcComEmpChaCtl {
	@Autowired
	private ISvcComEmpChaSvc iChaSvc;
	
	@RequestMapping("/changepage")
	@RequiresAuthority("SvcComEmpCha")
	public String change() {
		return "/sales/employee/employeepasswordchange";
	}
	
	@PostMapping("/employeepasswordchangepage")
	public String passwordChange(@ModelAttribute SvcComEmpChaDto chaDto, HttpSession session, Model model) {
		String employeeId = (String) session.getAttribute("employeeId");
		chaDto.setEmployeeId(employeeId);
		String result = iChaSvc.changByEmpPwd(chaDto);
		model.addAttribute("changeresult", result);
		return "/sales/employee/employeepasswordchange";
	}
}
