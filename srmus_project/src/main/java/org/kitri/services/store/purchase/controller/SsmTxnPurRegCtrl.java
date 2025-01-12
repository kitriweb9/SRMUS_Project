package org.kitri.services.store.purchase.controller;

import java.util.Map;

import org.kitri.services.store.purchase.service.ISsmTxnPurRegSvc;
import org.kitri.services.store.repo.dto.SsmTxnPurDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * Last update 2025-01-05 18:53S
 * **/

@Controller
public class SsmTxnPurRegCtrl {
	@Autowired
	public ISsmTxnPurRegSvc purRegSvc;
	
	
//	@RequestMapping("goproc")
//	public String registPurchaseTest() {
//		return "store/purchase/goodstest";
//	}
	
	
	@PostMapping("SsmTxnPurReg")
	public String addPurchase(@ModelAttribute SsmTxnPurDto purDto,@RequestParam Map<String, String> goodsPrices) {
		String goodsId = purDto.getGoodsId();
        String priceKey = "goodsPrice_" + goodsId;  // 예: goodsPrice_1001
        int goodsPrice = Integer.parseInt(goodsPrices.get(priceKey));
        purDto.setGoodsPrice(goodsPrice);
		purRegSvc.addPurchaseAndDetail(purDto);
		return "redirect:/SsmTxnPurChk";
	}
}
