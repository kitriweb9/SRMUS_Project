package org.kitri.services.store.customer.controller;

import javax.servlet.http.HttpSession;

import org.kitri.services.common.login.session.SvcComLgnSsn;
import org.kitri.services.store.customer.service.ISsmCusLgnSvc;
import org.kitri.services.store.repo.dto.SsmCusLgnDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @apiNote 사용자 정보
 * @author 박시연
 * @since 2025-01-03
 */
@Controller
public class SsmCusLgnInf {
	@Autowired
	ISsmCusLgnSvc cusSvc;
	@Autowired
	SvcComLgnSsn svcComLgnSsn;
	
	/**
	 * @apiNote 사용자 정보
	 * @param model: customer 값을 서버에 전달해주기 위해 호출
	 * @param session: customer 값을 세션을 통해 호출
	 * @return: 주소
	 * @author 박시연
	 * @since 2025-01-03
	 */
	@GetMapping("/userInfo")
	public String userInfo(Model model, HttpSession session) {
		if(svcComLgnSsn.isLogin(session)) {
			SsmCusLgnDto cus = (SsmCusLgnDto) session.getAttribute("user");
			model.addAttribute("user", cusSvc.userInfo(cus.getId()));
			return "store/customer/SsmCusLgnInf";
		}
		
		return "store/customer/SsmCusLgnLin";
	}
}
