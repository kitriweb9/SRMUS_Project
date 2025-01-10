package org.kitri.services.store.sale.controller;

import java.util.List;

import org.kitri.services.store.repo.dto.SsmTxnSalDto;
import org.kitri.services.store.sale.service.ISsmTxnSalChkSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SsmTxnSalChkCtrl {
	@Autowired
	public ISsmTxnSalChkSvc salChkSvc;
	
	//판매 승인 대기 목록 보기
	@GetMapping("SsmTxnSalAprList")
	public String showSalesList(SsmTxnSalDto salDto, Model model) {
		salDto.setStoreId("ST001");
		List<SsmTxnSalDto> salList = salChkSvc.getSalesListN(salDto);
		model.addAttribute("salList", salList);
		System.out.println("sal status N = 승인 대기");
		
		return "store/sale/SsmTxnSalApr";
	}
	
	// 판매 승인 목록 보기
	@GetMapping("SsmTxnSalChk")
	public String showSalesApprovedList(SsmTxnSalDto salDto, Model model) {
		salDto.setStoreId("ST001");
		List<SsmTxnSalDto> salList = salChkSvc.getSalesListY(salDto);
		model.addAttribute("salList", salList);
		System.out.println("sal status Y = 승인 완료");
		
		return "store/sale/SsmTxnSalChk";
	}
	
	
}
