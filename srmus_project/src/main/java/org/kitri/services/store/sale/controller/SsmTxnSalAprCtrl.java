//package org.kitri.services.store.sale.controller;
//
//import javax.servlet.http.HttpSession;
//
//import org.kitri.services.store.repo.dto.SsmTxnSalDto;
//import org.kitri.services.store.sale.service.ISsmTxnSalAprSvc;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class SsmTxnSalAprCtrl {
//	@Autowired
//	public ISsmTxnSalAprSvc saprsvc;
//	
//	@PostMapping("salapr")
//	public String changeSalStatus(HttpSession session, @ModelAttribute SsmTxnSalDto sdto) {
//		// sales_status를 Y로 변경
//		saprsvc.updateSalStatus(sdto.getSalesId());
//		session.setAttribute("salesId", sdto.getSalesId());
//		return "redirect:/saleslist/";
//	}
//		
//		
//
//}
