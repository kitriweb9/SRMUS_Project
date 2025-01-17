package org.kitri.services.sales.ordered.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.kitri.services.sales.ordered.dto.ShqIgoRegIIDto;
import org.kitri.services.sales.ordered.service.IShqIgoRegSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShqIgoRegCtl {
	@Autowired
	private IShqIgoRegSvc iRegSvc;
	
	@GetMapping("/integrationorder")
	public String integrationOrder(Model model) {
		List<ShqIgoRegIIDto> integration = iRegSvc.integrationOrderInquiry(LocalDate.now().toString());
		model.addAttribute("integration", integration);
		return "/sales/ordered/orderedlist";
	}
	
	@PostMapping("/integrationorder")
	public String integrationOrderRegistration(@RequestParam String orderId, HttpSession httpSession, Model model) {
		String employeeId = (String) httpSession.getAttribute("employee");
		String integrationResult = iRegSvc.integrationOrderRegistration(orderId, employeeId);
		model.addAttribute("result", integrationResult);
		return "/sales/ordered/orderedlist";
	}
	
	@PostMapping("/integrationserach")
	public String integrationSerach(@RequestParam String inputDate, Model model) {
		List<ShqIgoRegIIDto> integration = iRegSvc.integrationOrderInquiry(inputDate);
		model.addAttribute("integration", integration);
		return "/sales/ordered/orderedlist";
	}
}
