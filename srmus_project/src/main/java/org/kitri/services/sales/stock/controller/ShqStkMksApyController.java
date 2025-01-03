package org.kitri.services.sales.stock.controller;

import org.kitri.services.sales.repo.dto.ShqStkMksDto;
import org.kitri.services.sales.stock.service.ShqStkMksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ShqStkMksApyController {
	private final ShqStkMksService svc;
	
	@Autowired
	public ShqStkMksApyController(ShqStkMksService svc) {
		this.svc = svc;
	}

	@PostMapping("/store/goods/stock")
	@ResponseBody
	public String updateGoodsStock(@ModelAttribute ShqStkMksDto dto) {
		svc.addStock(dto);
		return "true";
	}
}
