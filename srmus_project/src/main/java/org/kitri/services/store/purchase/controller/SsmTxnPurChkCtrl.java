package org.kitri.services.store.purchase.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.kitri.services.store.purchase.service.ISsmTxnPurChkSvc;
import org.kitri.services.store.repo.dto.SsmCusLgnDto;
import org.kitri.services.store.repo.dto.SsmTxnPurDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SsmTxnPurChkCtrl {
	@Autowired
	public ISsmTxnPurChkSvc purChkSvc;
	
	// 구매 목록 보기
	@GetMapping("SsmTxnPurChk")
	public String showPurchaseList(HttpSession httpSession, SsmTxnPurDto purDto, Model model) {
		SsmCusLgnDto ssmCusLgnDto = (SsmCusLgnDto) httpSession.getAttribute("user");
		purDto.setCustomerId(ssmCusLgnDto.getId());
		List<SsmTxnPurDto> purList = purChkSvc.getPurchaseY(purDto);
		model.addAttribute("purList", purList);
		
		return "store/purchase/SsmTxnPurChk";
	}

	// 구매 취소 목록 보기
	@GetMapping("SsmTxnPurApr")
	public String showPurchaseCancleList(HttpSession httpSession, SsmTxnPurDto purDto, Model model) {
		SsmCusLgnDto ssmCusLgnDto = (SsmCusLgnDto) httpSession.getAttribute("user");
		purDto.setCustomerId(ssmCusLgnDto.getId());
		List<SsmTxnPurDto> purList = purChkSvc.getPurchaseN(purDto);
		model.addAttribute("purList", purList);
		
		return "store/purchase/SsmTxnPurApr";
	}
}
