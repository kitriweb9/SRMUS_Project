package org.kitri.services.store.sreturn.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.kitri.services.store.repo.dto.SsmRtnSndDto;
import org.kitri.services.store.sreturn.service.ISsmRtnMgtChkSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SsmRtnMgtChkCtrl {
	@Autowired
	private ISsmRtnMgtChkSvc rchksvc;
	
	@GetMapping("rtnlist")
	public ModelAndView showRtnList(HttpSession session,@ModelAttribute SsmRtnSndDto rdto) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("store/sreturn/rtnlist");
		List<SsmRtnSndDto> rlist = rchksvc.getReturnList();
		mav.addObject("rlist",rlist);
		return mav;
	}
//
//	@GetMapping("rtnmodiresult")
//	public ModelAndView showRtnModiResult(HttpSession session,@ModelAttribute SsmRtnSndDto rdto) {
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("store/sreturn/rtnmodiresult");
//		rdto = rchksvc.getReturnModiResult(rdto.getReturnId());
//		mav.addObject("rmodiresult",rdto);
//		return mav;
//	}
}
