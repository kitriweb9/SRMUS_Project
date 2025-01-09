package org.kitri.services.common.login.login;

import javax.servlet.http.HttpSession;

import org.kitri.services.sales.employee.dao.ISvcComLgnEmpDao;
import org.kitri.services.sales.repo.dto.SvcComEmpLgnDto;
import org.kitri.services.store.customer.dao.ISsmCusLgnCusDao;
import org.kitri.services.store.repo.dto.SsmCusLgnDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @apiNote 로그인
 * @author 박시연
 * @since 2024-12-23
 */
@Component
public class SvcComLgnLin {
	ISvcComLgnEmpDao empDao;

	ISsmCusLgnCusDao cusDao;

	@Autowired
	public SvcComLgnLin(ISvcComLgnEmpDao empDao, ISsmCusLgnCusDao cusDao) {
		super();
		this.empDao = empDao;
		this.cusDao = cusDao;
	}

	/**
	 * @apiNote 로그인
	 * @param id:           입력한 아이디
	 * @param pwd:          입력한 비밀번호
	 * @param inputSession: 사용자 세션
	 * @return 로그인 결과에 대한 불리언 값
	 * @author 박시연
	 * @since 2024-12-23
	 */
	public boolean login(HttpSession inputSession, String id, String pwd, String loginType) {
		if ("employee".equals(loginType)) {
			return employeeLogin(id, pwd, inputSession);
		}

		if ("customer".equals(loginType)) {
			return customerLogin(id, pwd, inputSession);
		}
		
		return false;
	}

	private boolean employeeLogin(String id, String pwd, HttpSession inputSession) {
		SvcComEmpLgnDto emp = empDao.findEmployeeById(id);

		if (emp != null && pwd.equals(emp.getEmployeePassword())) {
			inputSession.setAttribute("employee", emp);
			return true;
		}

		return false;
	}

	private boolean customerLogin(String id, String pwd, HttpSession inputSession) {
		SsmCusLgnDto cus = cusDao.findCustomerById(id);

		if (cus != null && pwd.equals(cus.getPwd())) {
			inputSession.setAttribute("user", cus);
			return true;
		}

		return false;
	}
}
