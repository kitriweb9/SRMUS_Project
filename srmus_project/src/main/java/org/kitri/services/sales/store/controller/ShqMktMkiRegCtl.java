package org.kitri.services.sales.store.controller;

import org.kitri.services.common.pageauth.intercepter.RequiresAuthority;
import org.kitri.services.sales.repo.dto.ShqMktMkiChgDto;
import org.kitri.services.sales.store.service.ShqMktMkiRegSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShqMktMkiRegCtl {
	private ShqMktMkiRegSvc shqMktMkiRegSvc;

	@Autowired
	public ShqMktMkiRegCtl(ShqMktMkiRegSvc shqMktMkiRegSvc) {
		super();
		this.shqMktMkiRegSvc = shqMktMkiRegSvc;
	}

	@GetMapping("/registstore")
	@RequiresAuthority(basicServiceId = "ShqMktMkiReg")
	public String registStorePage() {
		return "registstore";
	}

	@PostMapping("/registstore")
	public String registStoreInfo(@ModelAttribute ShqMktMkiChgDto shqMktMkiChgDto, Model model) {
		model.addAttribute("message", shqMktMkiRegSvc.registStoreInfo(shqMktMkiChgDto));
		return "redirect:/storelist";
	}
}
