package org.kitri.services.store.stock.controller;

import org.kitri.services.store.repo.dto.SsmStkMgtChgDto;
import org.kitri.services.store.stock.service.ISsmStkMgtChgSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SsmStkMgtChgCtrl {

	@Autowired
	private ISsmStkMgtChgSvc chgSvc;

	@PostMapping("/SsmStkMgtChg/update")
	public String updateStock(SsmStkMgtChgDto stockDto) {
		chgSvc.updateStock(stockDto);
		return "redirect:/SsmStkMgtChk/list";
	}
}
