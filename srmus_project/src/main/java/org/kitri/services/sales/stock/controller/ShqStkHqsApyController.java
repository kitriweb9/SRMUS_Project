package org.kitri.services.sales.stock.controller;

import org.kitri.services.sales.repo.dto.ShqStkHqsDto;
import org.kitri.services.sales.stock.service.ShqStkHqsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ShqStkHqsApyController {
	private final ShqStkHqsService svc;
	
	@Autowired
	public ShqStkHqsApyController(ShqStkHqsService svc) {
		this.svc = svc;
	}

	@PostMapping("/goods/stock")
	@ResponseBody
	public String updateGoodsStock(@ModelAttribute ShqStkHqsDto dto) {
		svc.addStock(dto);
		return "true";
	}
}
