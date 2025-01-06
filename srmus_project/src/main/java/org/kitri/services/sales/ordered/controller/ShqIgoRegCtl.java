package org.kitri.services.sales.ordered.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.kitri.services.sales.ordered.dto.ShqIgoRegIIDto;
import org.kitri.services.sales.ordered.service.IShqIgoRegSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShqIgoRegCtl {
	@Autowired
	private IShqIgoRegSvc iRegSvc;
	
	
	@PostMapping("/integrationorder")
	public String integrationOrderRegistration(@RequestParam String orderId, HttpSession httpSession, Model model) {
//		String employeeId = (String)httpSession.getAttribute("employeeId");
		String employeeId = "11111";
		String integrationResult = iRegSvc.integrationOrderRegistration(orderId, employeeId);
		model.addAttribute("result", integrationResult);
		return "/sales/ordered/orderedlist";
	}
	
	@PostMapping("/integrationserach")
	public String integrationSerach(@RequestParam String inputDate, Model model) {
		System.out.println(inputDate);
		List<ShqIgoRegIIDto> integration = iRegSvc.integrationOrderInquiry(inputDate);
		model.addAttribute("integration", integration);
		return "/sales/ordered/orderedlist";
	}
}
