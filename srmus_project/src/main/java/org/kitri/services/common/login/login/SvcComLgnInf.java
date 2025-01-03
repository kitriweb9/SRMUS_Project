package org.kitri.services.common.login.login;

import org.kitri.services.sales.employee.dao.ISvcComLgnEmpDao;
import org.kitri.services.store.customer.dao.ISvcComLgnCusDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @apiNote 사용자 정보 불러오기
 * @author 박시연
 * @since 2024-12-23
 */
@Component
public class SvcComLgnInf {
	@Autowired
	ISvcComLgnEmpDao empDao;
	@Autowired
	ISvcComLgnCusDao cusDao;
	
	/**
	 * @apiNote 사용자 정보 불러오기
	 * @param id: 사용자의 아이디
	 * @return 아이디에 맞는 사용자 정보
	 * @author 박시연
	 * @since 2024-12-23
	 */
	
	public Object userInfo(String id) {
		Object emp = empDao.findEmployeeById(id);
		Object cus = cusDao.findCustomerById(id);
		
		if(emp == null) {
			return cus;
		}
		
		return emp;
	}
}
