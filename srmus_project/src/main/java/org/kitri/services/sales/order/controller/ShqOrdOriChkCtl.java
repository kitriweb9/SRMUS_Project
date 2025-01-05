package org.kitri.services.sales.order.controller;

import java.util.List;

import org.kitri.services.sales.order.dto.ShqOrdOriChkDto;
import org.kitri.services.sales.order.service.IShqOrdOriChkSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShqOrdOriChkCtl {
	@Autowired
	private IShqOrdOriChkSvc iChkSvc;
	
	@GetMapping("/searchorders")
	public String searchOrdersPage(Model model) {
		List<ShqOrdOriChkDto> ordersList = iChkSvc.searchOrders(null, null);
		model.addAttribute("ordersList", ordersList);
		return "/sales/order/orderlist";
	}
	
	@PostMapping("/searchorders")
	public String searchOrders(@RequestParam(required = false) String orderId, @RequestParam(required = false) String goodsName, Model model) {
		List<ShqOrdOriChkDto> ordersList = iChkSvc.searchOrders(orderId, goodsName);
		model.addAttribute("ordersList", ordersList);
		System.out.println(ordersList);
		return "/sales/order/orderlist";
	}
}
