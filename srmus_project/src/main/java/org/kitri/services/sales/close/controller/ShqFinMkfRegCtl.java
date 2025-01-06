package org.kitri.services.sales.close.controller;

import org.kitri.services.sales.close.service.ShqFinMkfRegSvc;
import org.kitri.services.sales.repo.dto.ShqFinMkfRegDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShqFinMkfRegCtl {
	private ShqFinMkfRegSvc shqFinMkfRegSvc;

	@Autowired
	public ShqFinMkfRegCtl(ShqFinMkfRegSvc shqFinMkfRegSvc) {
		super();
		this.shqFinMkfRegSvc = shqFinMkfRegSvc;
	}

	@GetMapping("/marketclose")
	public String marketClosePage() {
		return "marketclose";
	}

	@PostMapping("/registmarketclosing")
	public String registMarketClosingInfo(Model model, @ModelAttribute ShqFinMkfRegDto shqFinMkfRegDto) {
		model.addAttribute("message", shqFinMkfRegSvc.registMarketClosingInfo(shqFinMkfRegDto));
		return "redirect:/marketcloseinfo";
	}

}
