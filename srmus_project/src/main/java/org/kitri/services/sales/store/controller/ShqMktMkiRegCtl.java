package org.kitri.services.sales.store.controller;

import org.kitri.services.common.pageauth.SvcComPgcAcp;
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
	private SvcComPgcAcp svcComPgcAcp;

	@Autowired
	public ShqMktMkiRegCtl(ShqMktMkiRegSvc shqMktMkiRegSvc, SvcComPgcAcp svcComPgcAcp) {
		super();
		this.shqMktMkiRegSvc = shqMktMkiRegSvc;
		this.svcComPgcAcp = svcComPgcAcp;
	}

	@GetMapping("/registstore")
	public String registStorePage() {
//		svcComPgcAcp.handleAuthorizedPage(null, null);
		return "registstore";
	}

	@PostMapping("/registstore")
	public String registStoreInfo(@ModelAttribute ShqMktMkiChgDto shqMktMkiChgDto, Model model) {
		model.addAttribute("message", shqMktMkiRegSvc.registStoreInfo(shqMktMkiChgDto));
		return "redirect:/storelist";
	}

}
