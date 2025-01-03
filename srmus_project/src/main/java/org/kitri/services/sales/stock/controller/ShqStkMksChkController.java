package org.kitri.services.sales.stock.controller;

import org.kitri.services.sales.stock.service.ShqStkMksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ShqStkMksChkController {
	private final ShqStkMksService svc;
	
	@Autowired
	public ShqStkMksChkController(ShqStkMksService svc) {
		this.svc = svc;
	}

	@GetMapping("/store/goods/stock")
	public String changeGoodsStock(Model model) {
		model.addAttribute("goods", svc.findAll());
		return "sales/stock/ShqStkMksChk";
	}
	
	@GetMapping("/store/goods/stock/{storeId}")
	public String changeGoodsStock(Model model, @PathVariable("storeId") String storeId) {
		model.addAttribute("goods", svc.findByStoreId(storeId));
		return "sales/stock/ShqStkMksChkSearch";
	}
}
