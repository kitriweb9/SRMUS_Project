package org.kitri.services.store.purchase.controller;

import org.kitri.services.store.purchase.service.ISsmTxnPurRegSvc;
import org.kitri.services.store.repo.dto.SsmTxnPurDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
	public String addPurchase(@ModelAttribute SsmTxnPurDto purDto) {
		purRegSvc.addPurchaseAndDetail(purDto);
		return "redirect:/SsmTxnPurChk";
	}
}
