package org.kitri.services.sales.in.controller;

import org.kitri.services.common.pageauth.intercepter.RequiresAuthority;
import org.kitri.services.sales.in.service.ShqInbExpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inbound/store")
public class ShqInbExpChkController {
	private final ShqInbExpService storeSvc;
	
	@Autowired
	public ShqInbExpChkController(ShqInbExpService storeSvc) {
		this.storeSvc = storeSvc;
	}
	
	@GetMapping
	@RequiresAuthority(basicServiceId = "ShqInbExpChk")
	public String getIncomingStocks(Model model){
		model.addAttribute("goods", storeSvc.findAll());
		return "sales/in/ShqInbExpChk";
	}
	
	@GetMapping("/{storeId}")
	public String getIncomingStocks(Model model, @PathVariable(value="storeId") String storeId){
		model.addAttribute("goods", storeSvc.findById(storeId));
		return "sales/in/ShqInbExpChkSearch";
	}
}
