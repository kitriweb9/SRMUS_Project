//package org.kitri.services.store.sale.controller;
//
//import java.util.List;
//
//import javax.servlet.http.HttpSession;
//
//import org.kitri.services.store.repo.dto.SsmTxnSalDto;
//import org.kitri.services.store.sale.service.ISsmTxnSalChkSvc;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//public class SsmTxnSalChkCtrl {
//	@Autowired
//	public ISsmTxnSalChkSvc schksvc;
//	
//	@GetMapping("saleslist") // ST001 점포의 모든 마스터 세일즈를 불러온다
//	public ModelAndView showSalesList(HttpSession session,@ModelAttribute SsmTxnSalDto sdto) {
//		String storeId ="ST001";
//		System.out.println("stoname");
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("store/sale/saleslist");
//		List<SsmTxnSalDto> slist = schksvc.getSalesListByStore(storeId);
//		mav.addObject("slist", slist);
//				System.out.println("slist"+slist);
//		return mav;
//	}
//	
//	// 각 마스터를누르면 해당마스터의 디테일을 불러온다
//	
//	// status상태별 마스터세일즈를불러온다
//	
//}
