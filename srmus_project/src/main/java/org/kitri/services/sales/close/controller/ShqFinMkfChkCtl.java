package org.kitri.services.sales.close.controller;

import org.kitri.services.sales.close.service.ShqFinMkfChkSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShqFinMkfChkCtl {
	private ShqFinMkfChkSvc shqFinMkfChkSvc;

	@Autowired
	public ShqFinMkfChkCtl(ShqFinMkfChkSvc shqFinMkfChkSvc) {
		super();
		this.shqFinMkfChkSvc = shqFinMkfChkSvc;
	}

	@GetMapping("/marketcloseinfo")
	public String marketCloseInfoFilterByDate(Model model, @RequestParam(required = false) String marketClosingDate) {
		// marketClosingDate가 null이거나 빈값("")일 때
		if (marketClosingDate == null || marketClosingDate.trim().isEmpty()) {
			// 빈값일 경우 기본 정보를 가져옴
			model.addAttribute("marketClosingList", shqFinMkfChkSvc.getMarketClosingInfo());
		} else {
			// 값이 있을 경우 해당 날짜로 필터링
			model.addAttribute("marketClosingList", shqFinMkfChkSvc.findClosingInfoFilterByDate(marketClosingDate));
		}

		return "marketclosinginfo";
	}

}
