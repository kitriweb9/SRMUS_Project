package org.kitri.services.sales.goods.controller;

import org.kitri.services.common.pageauth.SvcComPgcAcp;
import org.kitri.services.sales.goods.service.ShqPdtPdiChgSvc;
import org.kitri.services.sales.goods.service.ShqPdtPdiRegSvc;
import org.kitri.services.sales.repo.dto.ShqPdtPdiChgDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShqPdtPdiRegCtl {
	private ShqPdtPdiRegSvc shqPdtPdiRegSvc;
	private ShqPdtPdiChgSvc shqPdtPdiChgSvc;
	private SvcComPgcAcp svcComPgcAcp;

	@Autowired
	public ShqPdtPdiRegCtl(ShqPdtPdiRegSvc shqPdtPdiRegSvc, ShqPdtPdiChgSvc shqPdtPdiChgSvc,
			SvcComPgcAcp svcComPgcAcp) {
		super();
		this.shqPdtPdiRegSvc = shqPdtPdiRegSvc;
		this.shqPdtPdiChgSvc = shqPdtPdiChgSvc;
		this.svcComPgcAcp = svcComPgcAcp;
	}

	@GetMapping("/registgoods")
	public String registStorePage(Model model) {
		model.addAttribute("categoryList", shqPdtPdiChgSvc.getCategories());
//		svcComPgcAcp.handleAuthorizedPage(null, null);
		return "registgoods";
	}

	@PostMapping("/registgoods")
	public String registStoreInfo(@ModelAttribute ShqPdtPdiChgDto shqPdtPdiChgDto, Model model) {
		model.addAttribute("message", shqPdtPdiRegSvc.registGoodsInfo(shqPdtPdiChgDto));
		return "redirect:/goodslist";
	}
}
