package org.kitri.services.sales.goods.controller;

import org.kitri.services.common.pageauth.intercepter.RequiresAuthority;
import org.kitri.services.sales.goods.service.ShqPdtPdiChgSvc;
import org.kitri.services.sales.goods.service.ShqPdtPdiChkSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShqPdtPdiChkCtl {
	private final ShqPdtPdiChkSvc shqPdtPdiChkSvc;

	private final ShqPdtPdiChgSvc shqPdtPdiChgSvc;

	@Autowired
	public ShqPdtPdiChkCtl(ShqPdtPdiChkSvc shqPdtPdiChkSvc, ShqPdtPdiChgSvc shqPdtPdiChgSvc) {
		super();
		this.shqPdtPdiChkSvc = shqPdtPdiChkSvc;
		this.shqPdtPdiChgSvc = shqPdtPdiChgSvc;
	}

	@GetMapping("/goodslist")
	@RequiresAuthority(basicServiceId = "ShqPdtPdiChk", editServiceId = "ShqPdtPdiChg")
	public String getGoodsList(Model model) {
		model.addAttribute("goods", shqPdtPdiChkSvc.getGoodsList());
		model.addAttribute("categoryList", shqPdtPdiChgSvc.getCategories());
		return "goodslist";
	}

}
