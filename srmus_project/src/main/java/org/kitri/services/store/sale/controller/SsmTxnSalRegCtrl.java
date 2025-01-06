//package org.kitri.services.store.sale.controller;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpSession;
//
//import org.kitri.services.store.purchase.service.ISsmTxnPurChkSvc;
//import org.kitri.services.store.repo.dto.SsmTxnPurRegDto;
//import org.kitri.services.store.repo.dto.SsmTxnSalDto;
//import org.kitri.services.store.sale.service.ISsmTxnSalChkSvc;
//import org.kitri.services.store.sale.service.ISsmTxnSalRegSvc;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//public class SsmTxnSalRegCtrl {
//	@Autowired
//	public ISsmTxnSalRegSvc sregsvc;
//	@Autowired
//	public ISsmTxnSalChkSvc schksvc;
//	@Autowired
//	public ISsmTxnPurChkSvc pchksvc;
//	
//	
//	@RequestMapping("saltest")
//	public String addSalesTest() {
//		return "store/sale/salesmain";
//	}
//	
//	
//	@PostMapping("salesmain") //purchaseId와 employeeId 입력 필요
//	public String addSalesByPid(HttpSession session,@ModelAttribute SsmTxnSalDto sdto) {
//		String purchaseId = sdto.getPurchaseId();
//			if(	schksvc.getSIdByPId(purchaseId)==null) {
//				SsmTxnPurRegDto pdto =  pchksvc.getPurchaseByPId(purchaseId);			
//				sdto.setSalesAmount(pdto.getPurchaseAmount());
//				sdto.setGoodsId(pdto.getGoodsId());
//				sdto.setSalesQuantity(pdto.getPurchaseQuantity());
////				sregsvc.addSales(sdto);
//				List<SsmTxnPurRegDto> pdlist = pchksvc.getPurchaseDetailByPId(purchaseId);
////				String salesId = 
//				sregsvc.addSalesDetail(sregsvc.addSales(sdto), pdlist);
//			}
//			else {
//				System.out.println("이미 등록된 매출입니다."); //추후 없는 pid도 거르거나있는 pid 중에서만 고르게 수정
//			}
//		return "redirect:/saleslist/";
//	}
//	
//}
