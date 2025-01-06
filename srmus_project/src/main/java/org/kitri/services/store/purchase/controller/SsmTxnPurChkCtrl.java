package org.kitri.services.store.purchase.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.kitri.services.store.purchase.service.ISsmTxnPurChkSvc;
import org.kitri.services.store.repo.dto.SsmCusLgnDto;
import org.kitri.services.store.repo.dto.SsmTxnPurRegDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import oracle.jdbc.proxy.annotation.Post;

@Controller
public class SsmTxnPurChkCtrl {
	@Autowired
	public ISsmTxnPurChkSvc chksvc;

	// 카트 보기
	@GetMapping("list")
	public ModelAndView showList(HttpSession session, @ModelAttribute SsmTxnPurRegDto pdto) {
System.out.println("in cart");
//		SsmCusLgnDto dto = (SsmCusLgnDto)session.getAttribute("user");
//		String customerId = dto.getId();
		String customerId = pdto.getCustomerId();
		if (customerId == null) {
			SsmCusLgnDto d = (SsmCusLgnDto) session.getAttribute("user");
			customerId = d.getId();
		}
		System.out.println("cus " + customerId);

		ModelAndView mav = new ModelAndView();

		System.out.println("pdto" + pdto);
		String purchaseId = chksvc.getPIdByCId(customerId);
		System.out.println(purchaseId);
		mav.setViewName("store/purchase/cart");
		List<SsmTxnPurRegDto> pdlist = chksvc.getCartByPId(purchaseId);
		System.out.println(pdlist);
		mav.addObject("pdlist", pdlist);
		session.setAttribute("purchaseId", purchaseId);
		session.setAttribute("customerId", customerId);
		return mav;
	}

}
