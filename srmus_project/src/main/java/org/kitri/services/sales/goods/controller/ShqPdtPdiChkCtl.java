package org.kitri.services.sales.goods.controller;

import org.kitri.services.sales.goods.service.ShqPdtPdiChgSvc;
import org.kitri.services.sales.goods.service.ShqPdtPdiChkSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShqPdtPdiChkCtl {
	private ShqPdtPdiChkSvc shqPdtPdiChkSvc;
	private ShqPdtPdiChgSvc shqPdtPdiChgSvc;

	@Autowired
	public ShqPdtPdiChkCtl(ShqPdtPdiChkSvc shqPdtPdiChkSvc, ShqPdtPdiChgSvc shqPdtPdiChgSvc) {
		super();
		this.shqPdtPdiChkSvc = shqPdtPdiChkSvc;
		this.shqPdtPdiChgSvc = shqPdtPdiChgSvc;
	}

	@GetMapping("/goodslist")
	public String getGoodsList(Model model) {
		model.addAttribute("goods", shqPdtPdiChkSvc.getGoodsList());
		model.addAttribute("categoryList", shqPdtPdiChgSvc.getCategories());
		return "goodslist";
	}

}
