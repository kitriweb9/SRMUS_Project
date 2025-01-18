package org.kitri.services.store.order.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.kitri.services.common.pageauth.intercepter.RequiresAuthority;
import org.kitri.services.store.order.service.ISsmOrdGdoChkSvc;
import org.kitri.services.store.order.service.ISsmOrdSndSvc;
import org.kitri.services.store.repo.dto.SsmOrdGdoChkDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SsmOrdSndCtrl {

	@Autowired
	private ISsmOrdGdoChkSvc chkSvc;

	@Autowired
	private ISsmOrdSndSvc sndSvc;

	@GetMapping("/SsmOrdSnd/beforeSend")
	@RequiresAuthority("SsmOrdSnd")
	public String beforeSend(Model model) {
		List<SsmOrdGdoChkDto> yList = chkSvc.getOrderList();
		model.addAttribute("yList", yList);

		return "store/order/SsmOrdSndCheck";
	}

	@PostMapping("/SsmOrdSnd/submit")
	public String submitOrders(String[] orderIds) {
		if (orderIds == null || orderIds.length == 0) {
			// 아무것도 선택 안하면 -> 목록 이동
			return "redirect:/SsmOrdGdoChk/list";
		}

		// 2-1) 전체 목록 중에서 해당 orderIds만 추려냄
		List<SsmOrdGdoChkDto> allList = chkSvc.getOrderList(); // 또는 DAO에서 IN 쿼리
		List<String> selected = Arrays.asList(orderIds);

		List<SsmOrdGdoChkDto> confirmedOrders = new ArrayList<>();
		for (SsmOrdGdoChkDto dto : allList) {
			// 상태가 Y 이면서, 체크된 orderId에 포함되는지
			if ("Y".equals(dto.getOrderConfirmStatus()) && selected.contains(dto.getOrderId())) {
				confirmedOrders.add(dto);
			}
		}

		// 2-2) 서비스 호출
		sndSvc.sendOrders(confirmedOrders);

		// 2-3) 끝나면 목록으로 리다이렉트
		return "redirect:/SsmOrdGdoChk/list";
	}
}
