package org.kitri.services.sales.in.controller;

import org.kitri.services.sales.in.service.ShqInbImiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inbound")
public class ShqInbImiChkController {
	private final ShqInbImiService svc;
	
	@Autowired
	public ShqInbImiChkController(@Qualifier("shqInbImiService")
							   ShqInbImiService service) {
		svc = service;
	}
	
	
	@GetMapping
	public String getInbounds(Model model){
		model.addAttribute("goods", svc.getInbounds());
		return "sales/in/ShqInbImiChk";
	}

}
