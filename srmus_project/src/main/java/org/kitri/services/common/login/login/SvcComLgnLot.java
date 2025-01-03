package org.kitri.services.common.login.login;

import javax.servlet.http.HttpSession;

import org.kitri.services.common.login.session.SvcComLgnSsn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @apiNote 로그아웃
 * @author 박시연
 * @since 2024-12-23
 */
@Component
public class SvcComLgnLot {
	@Autowired
	SvcComLgnSsn session;
	
	/**
	 * @apiNote 로그아웃
	 * @param session: 사용자 세션
	 * @return: 로그아웃 성공에 대한 불리언 값
	 * @author 박시연
	 * @since 2024-12-23
	 */
	public boolean logout(HttpSession session) {
		if(this.session.isLogin(session)) {
			this.session.deleteSession(session);
			return true;
		}
		
		return false;
	}
}
