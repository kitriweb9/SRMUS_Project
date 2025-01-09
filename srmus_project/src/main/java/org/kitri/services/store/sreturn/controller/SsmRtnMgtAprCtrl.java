//package org.kitri.services.store.sreturn.controller;
//
//import javax.servlet.http.HttpSession;
//
//import org.kitri.services.store.repo.dto.SsmRtnSndDto;
//import org.kitri.services.store.sreturn.service.ISsmRtnMgtAprSvc;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class SsmRtnMgtAprCtrl {
//	@Autowired
//	private ISsmRtnMgtAprSvc raprsvc;
//	
//	@PostMapping("rtnmodirs")
//	public String changeRStatus(HttpSession session,@ModelAttribute SsmRtnSndDto rdto) {
//		raprsvc.updateRSatus(rdto.getReturnId());
//		return "store/sreturn/rtnmodiresult";
//	}
//
//}
