package org.kitri.services.sales.close.controller;

import org.kitri.services.sales.close.service.ShqFinHqfChkSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShqFinHqfChkCtl {
	private ShqFinHqfChkSvc shqFinHqfChkSvc;

	@Autowired
	public ShqFinHqfChkCtl(ShqFinHqfChkSvc shqFinHqfChkSvc) {
		super();
		this.shqFinHqfChkSvc = shqFinHqfChkSvc;
	}

	@GetMapping("/hqcloseinfo")
	public String getHqClosingInfo(Model model) {
		model.addAttribute("hqClosingList", shqFinHqfChkSvc.getHqClosingInfo());
		return "hqcloseinfo";
	}
}
