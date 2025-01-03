package org.kitri.services.sales.stock.controller;

import org.kitri.services.sales.stock.service.ShqStkHqsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ShqStkHqsChkController {
	private final ShqStkHqsService svc;
	
	@Autowired
	public ShqStkHqsChkController(ShqStkHqsService svc) {
		this.svc = svc;
	}

	@GetMapping("/goods/stock")
	public String changeGoodsStock(Model model) {
		model.addAttribute("goods", svc.findAll());
		return "sales/stock/ShqStkHqsChk";
	}
	
	@GetMapping("/goods/stock/{goodsName}")
	public String changeGoodsStock(Model model, @PathVariable("goodsName") String goodsName) {
		model.addAttribute("goods", svc.findByName(goodsName));
		return "sales/stock/ShqStkHqsChkSearch";
	}
}
