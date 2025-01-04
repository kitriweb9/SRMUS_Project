package org.kitri.services.store.customer.controller;

import javax.servlet.http.HttpSession;

import org.kitri.services.common.login.session.SvcComLgnSsn;
import org.kitri.services.store.customer.service.ISsmCusLgnSvc;
import org.kitri.services.store.repo.dto.SsmCusLgnDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @apiNote 로그아웃
 * @author 박시연
 * @since 2025-01-03
 */
@Controller
public class SsmCusLgnLot {
	@Autowired
	ISsmCusLgnSvc logout;
	@Autowired
	SvcComLgnSsn session;
	
	/**
	 * @apiNote 로그아웃
	 * @param session: 사용자 세션
	 * @return 주소
	 * @author 박시연
	 * @since 2025-01-03
	 */
	@GetMapping("/customer/logout")
	public String logout(HttpSession session) {
		SsmCusLgnDto cus = (SsmCusLgnDto) session.getAttribute("user");
		
		boolean result = logout.logout(session, cus.getId());
		
		if(result) {
			return "store/customer/SsmCusLgnLin";
		}
		
		System.out.println("error");
		
		return "store/customer/SsmCusLgnLin";
	}
}
