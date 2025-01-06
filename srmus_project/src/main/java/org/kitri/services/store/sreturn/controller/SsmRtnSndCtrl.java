package org.kitri.services.store.sreturn.controller;

import java.util.List;

import org.kitri.services.store.repo.dto.SsmRtnSndDto;
import org.kitri.services.store.sreturn.service.ISsmRtnMgtChkSvc;
import org.kitri.services.store.sreturn.service.ISsmRtnSndSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SsmRtnSndCtrl {
	@Autowired
	private ISsmRtnSndSvc rtnsndsvc;
	@Autowired
	private ISsmRtnMgtChkSvc rchksvc;
	
	@GetMapping("ssmrtnsndlist")
	public ModelAndView ssmRtnGetSendList() {
		ModelAndView mav = new ModelAndView();		
		List<SsmRtnSndDto> rtnlist= rchksvc.getReturnList();
		mav.setViewName("store/sreturn/rtnsndlist");
		mav.addObject("rtnlist",rtnlist);		
		return mav;
	}
	
	@PostMapping("ssmrtnsnd")
	@ResponseBody
	public String ssmRtnSend(SsmRtnSndDto rdto) {
		rtnsndsvc.ssmReturnSend();
		return "redirect:/rtntest/";
	}
	
	
}
