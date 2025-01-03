package org.kitri.services.sales.in.controller;

import org.kitri.services.sales.in.service.ShqInbImiService;
import org.kitri.services.sales.repo.dto.StoreInboundDto;
import org.kitri.services.sales.in.service.ShqInbExpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/inbound/ship")
public class ShqInbExpRegController {
	private final ShqInbImiService hqSvc;
	private final ShqInbExpService storeSvc;
	
	@Autowired
	public ShqInbExpRegController(ShqInbImiService hqSvc, ShqInbExpService storeSvc) {
		this.hqSvc = hqSvc;
		this.storeSvc = storeSvc;
	}
	
	@GetMapping
	public String getIncomingStocks(Model model){
		model.addAttribute("goods", hqSvc.getApproveInbound());
		return "sales/in/ShqInbExpReg";
	}
	
	@PostMapping("/create")
	public String createStoreInbound(@ModelAttribute
									  StoreInboundDto storeInboudDto,
									 @RequestParam(name="hqInboundDate")
									 String hqInboundDate) {
		storeSvc.addStoreInbound(storeInboudDto, hqInboundDate);
		System.out.println(hqInboundDate);
		return "sales/in/ShqInbExpReg";
	}
	
}
