package org.kitri.services.store.sale.controller;

import java.util.Map;

import org.kitri.services.store.repo.dto.SsmTxnSalDto;
import org.kitri.services.store.sale.service.ISsmTxnSalAprSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SsmTxnSalAprCtrl {
	@Autowired
	public ISsmTxnSalAprSvc salAprSvc;
	
	@PostMapping("SsmTxnSalApr")
	public String changeSalStatus(SsmTxnSalDto salDto, @RequestParam Map<String, String> goodsIds, @RequestParam Map<String, String> salesQuantities) {
		String salesId=salDto.getSalesId();
		String goodsId=goodsIds.get("goodsId_"+salesId);
		int salesQuantity=Integer.parseInt(salesQuantities.get("salesQuantity_"+salesId));
		salDto.setGoodsId(goodsId);
		salDto.setSalesQuantity(salesQuantity);
		salAprSvc.updateSalStatus(salDto);

		return "redirect:/SsmTxnSalChk";
	}
//		
//	@PostMapping("SsmTxnSalApr")
//	public String changeSalStatus(String[] salesIds, String employeeId) {
//		System.out.println("salesIds[0]: "+salesIds[0]);
//		List<SsmTxnSalAprDto> salAprDtoList = new ArrayList<>();
//		if(salesIds != null) {
//			for(String salesId : salesIds) {
//				salAprDtoList.add(new SsmTxnSalAprDto(salesId));	
//				System.out.println("sales id: "+salesId);
//			}
//		}
//		employeeId="EMP1234";
//		salAprSvc.updateSalStatus(salAprDtoList, employeeId);
//		System.out.println("sal status 변경");
//		return "redirect:/SsmTxnSalChk";
//	}
			

}
