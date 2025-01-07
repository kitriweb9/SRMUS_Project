//package org.kitri.services.store.purchase.controller;
//
//import javax.servlet.http.HttpSession;
//
//import org.kitri.services.store.purchase.service.ISsmTxnPurChgSvc;
//import org.kitri.services.store.purchase.service.ISsmTxnPurChkSvc;
//import org.kitri.services.store.repo.dto.SsmTxnPurRegDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class SsmTxnPurChgCtrl {
//	@Autowired
//	private ISsmTxnPurChgSvc chgsvc;
//	@Autowired
//	private ISsmTxnPurChkSvc chksvc;
//	
//	
//	
//	@PostMapping("modi")
//	public String changePurchaseQty(HttpSession session, @ModelAttribute SsmTxnPurRegDto pdto) {
//		//입력한 값만큼 상품 수량 변경
//		System.out.println("modi");
//		System.out.println(pdto.getGoodsId());
//
//		System.out.println(pdto.getPurchaseQuantity());
//		chgsvc.updateGoodsQty(pdto);
//		session.setAttribute("purchaseId", pdto.getPurchaseId());
//		session.setAttribute("customerId", pdto.getCustomerId());
//		return "redirect:/list/";
//	}
//	@PostMapping("checkstatus")
//	public String changePStatusToY(HttpSession session, @ModelAttribute SsmTxnPurRegDto pdto) {
//		// purchase_payment_status를 Y로 변경(결제 완료)
//		pdto.setPurchaseId(chksvc.getPIdByCId(pdto.getCustomerId()));
//		chgsvc.updatePStatusToY(pdto.getPurchaseId());
//		pdto.setCustomerId(pdto.getCustomerId());
//		pdto.setGoodsId(pdto.getGoodsId());
//		session.setAttribute("purchaseId", pdto.getPurchaseId());
//		session.setAttribute("customerId", pdto.getCustomerId());
//		return "redirect:/goproc/";
//	}
//		
//		
//
//}
