package org.kitri.services.sales.store.controller;

import org.kitri.services.sales.repo.dto.ShqMktMkiChgDto;
import org.kitri.services.sales.store.service.ShqMktMkiChgSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShqMktMkiChgCtl {
	private ShqMktMkiChgSvc shqMktMkiChgSvc;

	@Autowired
	public ShqMktMkiChgCtl(ShqMktMkiChgSvc shqMktMkiChgSvc) {
		super();
		this.shqMktMkiChgSvc = shqMktMkiChgSvc;
	}

	@PostMapping("/storeupdate")
	public String updateStoreInfo(@ModelAttribute ShqMktMkiChgDto shqMktMkiChgDto, Model model) {
		model.addAttribute("message", shqMktMkiChgSvc.updateStoreInfo(shqMktMkiChgDto));
		return "storelist";

	}
}
