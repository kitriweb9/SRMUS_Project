package org.kitri.services.sales.goods.controller;

import org.kitri.services.sales.goods.service.ShqPdtPdiChgSvc;
import org.kitri.services.sales.repo.dto.ShqPdtPdiChgDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShqPdtPdiChgCtl {
	private ShqPdtPdiChgSvc shqPdtPdiChgSvc;

	@Autowired
	public ShqPdtPdiChgCtl(ShqPdtPdiChgSvc shqPdtPdiChgSvc) {
		super();
		this.shqPdtPdiChgSvc = shqPdtPdiChgSvc;
	}

	@PostMapping("/goodsupdate")
	public String getCategoryInfo(Model model, @ModelAttribute ShqPdtPdiChgDto shqPdtPdiChgDto) {
		model.addAttribute("message", shqPdtPdiChgSvc.updateGoodsInfo(shqPdtPdiChgDto));
		return "redirect:/goodslist";
	}

}
