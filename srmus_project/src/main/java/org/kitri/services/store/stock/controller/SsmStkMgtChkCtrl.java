package org.kitri.services.store.stock.controller;

import java.util.List;
import org.kitri.services.store.repo.dto.SsmStkMgtChkDto;
import org.kitri.services.store.stock.service.ISsmStkMgtChkSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SsmStkMgtChkCtrl {

	@Autowired
	private ISsmStkMgtChkSvc chkSvc;

	@GetMapping("/SsmStkMgtChk/list")
	public String listStock(Model model) {
		List<SsmStkMgtChkDto> stockList = chkSvc.getAllStocks();
		model.addAttribute("stockList", stockList);
		return "store/stock/SsmStkMgtChk"; // JSP 파일 경로: /WEB-INF/views/stock/SsmStkMgtChk.jsp
	}
}
