package org.kitri.services.store.purchase.controller;

import java.util.Map;

import org.kitri.services.store.purchase.service.ISsmTxnPurChgSvc;
import org.kitri.services.store.repo.dto.SsmTxnPurDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SsmTxnPurChgCtrl {
	@Autowired
	private ISsmTxnPurChgSvc purChgSvc;

	@PostMapping("SsmTxnPurChg")
	public String changePStatusToN(SsmTxnPurDto purDto, @RequestParam Map<String, String> goodsIds, @RequestParam Map<String, String> purQtys) {
		String purchaseId = purDto.getPurchaseId();
        String goodsId = goodsIds.get("goodsId_"+purchaseId);
        String purchaseQuantity = purQtys.get("purQty_"+purchaseId);
        purDto.setGoodsId(goodsId);
        purDto.setPurchaseQuantity(Integer.parseInt(purchaseQuantity));
		purChgSvc.modifyPurchaseStatus(purDto);
		return "redirect:/SsmTxnPurApr";
	}

}
