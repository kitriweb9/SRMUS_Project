package org.kitri.services.sales.in.controller;

import org.kitri.services.sales.in.service.ShqInbImiService;
import org.kitri.services.sales.repo.dto.ShqInbImiDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inbound")
public class ShqInbImiWfaController {
	private final ShqInbImiService svc;
	
	@Autowired
	public ShqInbImiWfaController(@Qualifier("shqInbImiService")
							   ShqInbImiService service) {
		svc = service;
	}
	
	
	@GetMapping("/ing")
	public String getIncomingStocks(Model model){
		model.addAttribute("goods", svc.getIncomingInbound());
		return "sales/in/ShqInbImiWfa";
	}
	
	@PostMapping("/update")
	public String updatIncomingStocks(Model model,
									  @ModelAttribute ShqInbImiDto reqDto){
		System.out.println(reqDto);
		System.out.println(reqDto.getInboundDate());
		svc.updateIncomingStocks(reqDto);
		model.addAttribute("goods", svc.getIncomingInbound());
		return "sales/in/ShqInbImiWfa";
	}

}
