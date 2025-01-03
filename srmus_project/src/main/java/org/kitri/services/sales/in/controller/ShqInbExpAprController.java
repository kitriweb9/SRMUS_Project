package org.kitri.services.sales.in.controller;

import org.kitri.services.sales.in.service.ShqInbExpService;
import org.kitri.services.sales.repo.dto.StoreInboundDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShqInbExpAprController {
	private final ShqInbExpService storeSvc;
	
	@Autowired
	public ShqInbExpAprController(ShqInbExpService storeSvc) {
		this.storeSvc = storeSvc;
	}
	
	@PostMapping("/inbound/store/approve")
	public String approveStoreInbound(@ModelAttribute StoreInboundDto dto){
		storeSvc.approve(dto);
		return "sales/in/ShqInbExpChk";
	}
	
	@PostMapping("/inbound/store/update")
	public String updateStoreInbound(@ModelAttribute StoreInboundDto dto){
		storeSvc.update(dto);
		return "sales/in/ShqInbExpChk";
	}
}
