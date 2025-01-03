package org.kitri.services.sales.in.controller;

import org.kitri.services.sales.in.service.ShqInbImiService;
import org.kitri.services.sales.repo.dto.IntegrationInboundDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inbound")
public class ShqInbImiAprController {
	private final ShqInbImiService svc;
	
	@Autowired
	public ShqInbImiAprController(@Qualifier("shqInbImiService")
							   ShqInbImiService service) {
		svc = service;
	}
	
	@PostMapping("/approve")
	public String updatIncomingStocks(Model model,
									  @ModelAttribute IntegrationInboundDto reqDto){
		svc.approveStock(reqDto);
		return "true";
	}

}
