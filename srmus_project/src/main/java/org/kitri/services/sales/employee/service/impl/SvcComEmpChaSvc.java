package org.kitri.services.sales.employee.service.impl;

import org.kitri.services.sales.employee.dao.ISvcComEmpChaDao;
import org.kitri.services.sales.employee.dto.SvcComEmpChaDto;
import org.kitri.services.sales.employee.service.ISvcComEmpChaSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SvcComEmpChaSvc implements ISvcComEmpChaSvc{

	@Autowired
	private ISvcComEmpChaDao iSvcComEmpChaDao;

	@Override
	public String changByEmpPwd(SvcComEmpChaDto svcComEmpChaDto) {
		int cnt = iSvcComEmpChaDao.changByEmpPwd(svcComEmpChaDto);
		if(cnt > 0) {
			return "비밀번호 변경 성공"; 
		} else {
			return "비밀번호 변경 실패";
		}
	}
}
