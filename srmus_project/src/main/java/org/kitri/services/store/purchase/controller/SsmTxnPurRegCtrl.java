package org.kitri.services.store.purchase.controller;

import javax.servlet.http.HttpSession;

import org.kitri.services.store.purchase.service.ISsmTxnPurChgSvc;
import org.kitri.services.store.purchase.service.ISsmTxnPurChkSvc;
import org.kitri.services.store.purchase.service.ISsmTxnPurRegSvc;
import org.kitri.services.store.repo.dto.SsmTxnPurRegDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * Last update 2025-01-05 18:53S
 * **/

@Controller
public class SsmTxnPurRegCtrl {
	@Autowired
	public ISsmTxnPurRegSvc regsvc;
	@Autowired
	public ISsmTxnPurChkSvc chksvc;
	@Autowired
	public ISsmTxnPurChgSvc chgsvc;
	
	
//	@RequestMapping("goproc")
//	public String registPurchaseTest() {
//		return "store/purchase/goodstest";
//	}
	
	
	@PostMapping("purregtest")
	public String registPurchase(HttpSession session,@ModelAttribute SsmTxnPurRegDto pdto) {
		String customerId = pdto.getCustomerId();
		String purchaseId = chksvc.getPidByCidWithDate(customerId);
		System.out.println("p1"+purchaseId);
			if(purchaseId==null) {
				purchaseId = "";
				System.out.println("p2"+purchaseId);
			}
			else {
				pdto.setPurchaseId(purchaseId);
				System.out.println("p3"+purchaseId);
			}
		// 처음 이용 고객이거나 | 마지막 주문의 status가 결제 완료인 경우 장바구니 추가
		if((purchaseId=="")|("Y".equals(chksvc.getStatusByPid(purchaseId)))) {
			pdto.setCustomerId(customerId);
			regsvc.registPurchase(pdto);

			System.out.println("p4"+purchaseId);
			purchaseId=chksvc.getPIdByCId(customerId);
			pdto.setPurchaseId(purchaseId);
			regsvc.registPurchaseDetail(pdto);

			System.out.println("p5"+purchaseId);
		}
		else {
			//장바구니가 있다면 지금 선택한 굿즈가 있는지 찾아보고 수량 가져와서 더한다

			System.out.println("p6"+purchaseId);
				Integer goodsQty = chksvc.getGoodsQtyByPidAndGid(pdto);
				
				if(goodsQty==null) {
					pdto.setPurchaseId(purchaseId);
					regsvc.registPurchaseDetail(pdto);	

					System.out.println("p7"+purchaseId);
				}
				else {
					pdto.setPurchaseQuantity(goodsQty+pdto.getPurchaseQuantity());
					chgsvc.updateGoodsQty(pdto);
					chgsvc.updateAmount(pdto);
					System.out.println("p8"+purchaseId);
				}
			}
		System.out.println("p9"+purchaseId);
		System.out.println("c9"+customerId);
		session.setAttribute("customerId", customerId);
		
		return "redirect:/list";
	}
}
