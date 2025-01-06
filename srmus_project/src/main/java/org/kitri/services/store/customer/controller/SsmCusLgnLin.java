package org.kitri.services.store.customer.controller;

import javax.servlet.http.HttpSession;

import org.kitri.services.common.login.login.SvcComLgnLin;
import org.kitri.system.encryption.EncShaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @apiNote 로그인
 * @author 박시연
 * @since 2025-01-03
 */
@Controller
public class SsmCusLgnLin {
	@Autowired
	SvcComLgnLin loginSvc;

	@GetMapping("/")
	public String welcome() {
		return "store/customer/SsmCusLgnLin";
	}

	/**
	 * @apiNote 로그인(get)
	 * @return 주소
	 * @author 박시연
	 * @since 2025-01-03
	 */
	@GetMapping("/customer/login")
	public String login() {
		return "store/customer/SsmCusLgnLin";
	}

	/**
	 * @apiNote 로그인(post)
	 * @param session: 사용자 세션
	 * @param id:      사용자가 입력한 id
	 * @param pwd:     사용자가 입력한 pwd
	 * @return 주소
	 * @author 박시연
	 * @since 2025-01-03
	 */
	@PostMapping("/customer/login")
	public String login(HttpSession session, @RequestParam String id, @RequestParam String pwd) {
		if (id.isEmpty() || pwd.isEmpty()) {
			return "store/customer/SsmCusLgnLin";
		}
		EncShaUtil sha = new EncShaUtil();

		pwd = sha.sha256(pwd);

		if (loginSvc.login(session, id, pwd)) {
			return "redirect: goods";
		}

		return "store/customer/SsmCusLgnLin";
	}
}
