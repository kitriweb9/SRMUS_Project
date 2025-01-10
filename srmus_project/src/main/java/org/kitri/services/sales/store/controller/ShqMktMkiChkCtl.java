package org.kitri.services.sales.store.controller;

import org.kitri.services.common.pageauth.intercepter.RequiresAuthority;
import org.kitri.services.sales.store.service.ShqMktMkiChkSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShqMktMkiChkCtl {

	private ShqMktMkiChkSvc shqMktMkiChkSvc;

	@Autowired
	public ShqMktMkiChkCtl(ShqMktMkiChkSvc shqMktMkiChkSvc) {
		super();
		this.shqMktMkiChkSvc = shqMktMkiChkSvc;
	}

	@GetMapping("/storelist")
	@RequiresAuthority(basicServiceId = "ShqMktMkiChk")
	public String getStoreList(Model model) {
		model.addAttribute("stores", shqMktMkiChkSvc.getStoreList());
		return "storelist";
	}

}