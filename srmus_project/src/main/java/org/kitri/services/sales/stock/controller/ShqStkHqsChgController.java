package org.kitri.services.sales.stock.controller;

import org.kitri.services.common.pageauth.intercepter.RequiresAuthority;
import org.kitri.services.sales.repo.dto.ShqStkHqsDto;
import org.kitri.services.sales.stock.service.ShqStkHqsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ShqStkHqsChgController {
	private final ShqStkHqsService svc;
	
	@Autowired
	public ShqStkHqsChgController(ShqStkHqsService svc) {
		this.svc = svc;
	}
	
	@PostMapping("/goods/stock/change")
	@ResponseBody
	@RequiresAuthority(basicServiceId = "ShqStkHqsChg")
	public String changeGoodsStock(@ModelAttribute ShqStkHqsDto dto) {
		svc.changeStock(dto);
		return "true";
	}
}
