package org.kitri.services.store.purchase.controller;

import org.kitri.services.store.purchase.service.ISsmTxnPurChgSvc;
import org.kitri.services.store.repo.dto.SsmTxnPurDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SsmTxnPurChgCtrl {
	@Autowired
	private ISsmTxnPurChgSvc purChgSvc;

	@PostMapping("SsmTxnPurChg")
	public String changePStatusToN(SsmTxnPurDto purDto) {
		purChgSvc.modifyPurchaseStatus(purDto);
		return "redirect:/SsmTxnPurApr";
	}

}
