package org.kitri.services.store.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.kitri.services.store.order.service.ISsmOrdGdoRegSvc;
import org.kitri.services.store.repo.dto.SsmOrdGdoRegDto;

@Controller
public class SsmOrdGdoRegCtrl {

	@Autowired
	private ISsmOrdGdoRegSvc regSvc;

	@GetMapping("/SsmOrdGdoReg/reg")
	public String showRegForm() {

		return "store/order/SsmOrdGdoReg";
	}

	@PostMapping("/SsmOrdGdoReg/reg")
	public String register(SsmOrdGdoRegDto regDto) {
		regSvc.registerOrder(regDto);

		return "redirect:/SsmOrdGdoChk/list";
	}
}
