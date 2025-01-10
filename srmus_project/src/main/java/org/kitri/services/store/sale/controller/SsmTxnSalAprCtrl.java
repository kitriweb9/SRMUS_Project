package org.kitri.services.store.sale.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.kitri.services.store.repo.dto.SsmTxnSalAprDto;
import org.kitri.services.store.repo.dto.SsmTxnSalDto;
import org.kitri.services.store.sale.service.ISsmTxnSalAprSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SsmTxnSalAprCtrl {
	@Autowired
	public ISsmTxnSalAprSvc salAprSvc;
	
	@PostMapping("SsmTxnSalApr")
	public String changeSalStatus(String[] salesIds, String employeeId) {
		List<SsmTxnSalAprDto> salAprDtoList = new ArrayList<>();
		if(salesIds != null) {
			for(String salesId : salesIds) {
				salAprDtoList.add(new SsmTxnSalAprDto(salesId));				
			}
		}
		salAprSvc.updateSalStatus(salAprDtoList, employeeId);
		System.out.println("sal status 변경");
		return "redirect:/SsmTxnSalAprList/";
	}
		
		

}
