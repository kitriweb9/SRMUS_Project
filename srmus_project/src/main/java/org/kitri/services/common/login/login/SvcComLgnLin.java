package org.kitri.services.common.login.login;

import javax.servlet.http.HttpSession;

import org.kitri.services.common.login.session.SvcComLgnSsn;
import org.kitri.services.sales.employee.dao.ISvcComLgnEmpDao;
import org.kitri.services.sales.employee.dto.SvcComEmpDto;
import org.kitri.services.store.customer.dao.ISvcComLgnCusDao;
import org.kitri.services.store.repo.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @apiNote 로그인
 * @author 박시연
 * @since 2024-12-23
 */
@Component
public class SvcComLgnLin {
	@Autowired
	SvcComLgnSsn session;
	@Autowired
	ISvcComLgnEmpDao empDao;
	@Autowired
	ISvcComLgnCusDao cusDao;
	
	/**
	 * @apiNote 로그인
	 * @param id: 입력한 아이디
	 * @param pwd: 입력한 비밀번호
	 * @param inputSession: 사용자 세션
	 * @return 로그인 결과에 대한 불리언 값
	 * @author 박시연
	 * @since 2024-12-23
	 */
	public boolean login(HttpSession inputSession, String id, String pwd) {
		SvcComEmpDto emp = empDao.findEmployeeById(id);
		CustomerDto cus = cusDao.findCustomerById(id);
		
		if(cus != null && cus.getPwd().equals(pwd)) {
			System.out.println();
			session.updateCustomerSession(inputSession, cus);
			return true;
		}
		
		if(emp != null && emp.getEmployeePassword().equals(pwd)) {
			session.updateEmployeeSession(inputSession, emp);
			return true;
		}
		
		return false;
	}
}
