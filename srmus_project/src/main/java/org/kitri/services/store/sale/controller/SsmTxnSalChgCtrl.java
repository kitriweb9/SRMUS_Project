//package org.kitri.services.store.sale.controller;
//
//import javax.servlet.http.HttpSession;
//
//import org.kitri.services.store.repo.dto.SsmTxnSalDto;
//import org.kitri.services.store.sale.service.ISsmTxnSalChgSvc;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class SsmTxnSalChgCtrl {
//	@Autowired
//	public ISsmTxnSalChgSvc schgsvc;
//	
//	@PostMapping("salmodi")
//	public String changePurchaseQty(HttpSession session, @ModelAttribute SsmTxnSalDto sdto) {
//		//입력한 값만큼 상품 수량 변경
//		schgsvc.updateSalQty(sdto);
//		schgsvc.updateSalAmount(sdto);
//		session.setAttribute("salesId", sdto.getSalesId());
//		return "redirect:/saleslist/";
//	}
//		
//
//}
