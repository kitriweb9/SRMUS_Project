package org.kitri.services.sales.stock.controller;

import org.kitri.services.sales.repo.dto.StoreStockDto;
import org.kitri.services.sales.stock.service.ShqStkMksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ShqStkMksChgController {
	private final ShqStkMksService svc;
	
	@Autowired
	public ShqStkMksChgController(ShqStkMksService svc) {
		this.svc = svc;
	}
	
	@PostMapping("/store/goods/stock/change")
	@ResponseBody
	public String changeGoodsStock(@ModelAttribute StoreStockDto dto) {
		svc.changeStock(dto);
		return "true";
	}
}
