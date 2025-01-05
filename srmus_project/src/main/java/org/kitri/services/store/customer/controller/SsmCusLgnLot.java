package org.kitri.services.store.customer.controller;

import javax.servlet.http.HttpSession;

import org.kitri.services.common.login.session.SvcComLgnSsn;
import org.kitri.services.sales.repo.dto.SvcComEmpLgnDto;
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
	SvcComLgnSsn sessions;
	
	/**
	 * @apiNote 로그아웃
	 * @param session: 사용자 세션
	 * @return 주소
	 * @author 박시연
	 * @since 2025-01-03
	 */
	@GetMapping("/customer/logout")
    public String logout(HttpSession session) {
        Object user = session.getAttribute("user");

        if (user instanceof SvcComEmpLgnDto) {
            // 직원일 경우
            SvcComEmpLgnDto employee = (SvcComEmpLgnDto) user;
            boolean result = logout.logout(session, employee.getEmployeeId());
            if (result) {
                return "store/customer/SsmCusLgnLin";
            }
        } else if (user instanceof SsmCusLgnDto) {
            // 고객일 경우
            SsmCusLgnDto customer = (SsmCusLgnDto) user;
            boolean result = logout.logout(session, customer.getId());
            if (result) {
                return "store/customer/SsmCusLgnLin";
            }
        }

        // 기본 동작
        System.out.println("세션에 사용자 정보 없음 또는 로그아웃 실패");
        return "store/customer/SsmCusLgnLin";
    }
}