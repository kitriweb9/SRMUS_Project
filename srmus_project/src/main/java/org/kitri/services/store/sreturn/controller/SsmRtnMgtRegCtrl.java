package org.kitri.services.store.sreturn.controller;

import javax.servlet.http.HttpSession;

import org.kitri.services.store.repo.dto.SsmRtnSndDto;
import org.kitri.services.store.sreturn.service.ISsmRtnMgtRegSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SsmRtnMgtRegCtrl {
	@Autowired
	private ISsmRtnMgtRegSvc rregsvc;
	

	@RequestMapping("rtntest")
	public String goReturnTest() {
		return "store/sreturn/rtnmain";
	}

	@RequestMapping("addrtn")
	public String addReturn(HttpSession session,@ModelAttribute SsmRtnSndDto rdto) {
		rregsvc.addReturn(rdto);
		rregsvc.addReturnDetail(rdto);
		return "redirect:/rtnlist/";
	}

}
