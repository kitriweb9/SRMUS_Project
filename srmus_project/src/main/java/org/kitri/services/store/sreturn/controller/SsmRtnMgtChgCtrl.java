//package org.kitri.services.store.sreturn.controller;
//
//import javax.servlet.http.HttpSession;
//
//import org.kitri.services.store.repo.dto.SsmRtnSndDto;
//import org.kitri.services.store.sreturn.service.ISsmRtnMgtChgSvc;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class SsmRtnMgtChgCtrl {
//	@Autowired
//	private ISsmRtnMgtChgSvc rchgsvc;
//	
//	@PostMapping("rtnmodigid")
//	public String updateRtnGId(HttpSession session,@ModelAttribute SsmRtnSndDto rdto){
//		rchgsvc.updateRtnGId(rdto);
//		return "store/sreturn/rtnmodiresult";
//	}
//	@PostMapping("rtnmodiqty")
//	public String updateRtnQty(HttpSession session,@ModelAttribute SsmRtnSndDto rdto){
//		rchgsvc.updateRtnQty(rdto);
//		return "store/sreturn/rtnmodiresult";
//	}
//	@PostMapping("rtndel")
//	public String deleteReturn(HttpSession session,@ModelAttribute SsmRtnSndDto rdto){
//		rchgsvc.deleteReturnDetail(rdto.getReturnId());
//		rchgsvc.deleteReturn(rdto.getReturnId());
//		return "redirect:/rtnlist/";
//	}
//}
