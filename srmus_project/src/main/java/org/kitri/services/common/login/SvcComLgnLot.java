package org.kitri.services.common.login;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

@Component
public class SvcComLgnLot {

	public boolean logout(HttpSession session) {
		session.invalidate();

		return true;
	}
}
