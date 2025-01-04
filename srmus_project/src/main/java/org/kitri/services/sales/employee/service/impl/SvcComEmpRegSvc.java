package org.kitri.services.sales.employee.service.impl;

import javax.servlet.http.HttpSession;

import org.kitri.services.common.login.session.SvcComLgnSsn;
import org.kitri.services.sales.employee.dao.ISvcComEmpRegDao;
import org.kitri.services.sales.employee.dto.SvcComEmpDto;
import org.kitri.services.sales.employee.service.ISvcComEmpRegSvc;
import org.kitri.services.sales.repo.dto.SvcComEmpLgnDto;
import org.kitri.system.encryption.EncAesUtil;
import org.kitri.system.encryption.HexConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SvcComEmpRegSvc implements ISvcComEmpRegSvc {

	@Autowired
	private ISvcComEmpRegDao iSvcComEmpRegDao;
	
	@Autowired
	private SvcComLgnSsn sessionSvc;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private EncAesUtil aes;
	
	@Override
	public String employeeRegistration(SvcComEmpDto svcComEmpRegDto) {
		System.out.println("원래 입력 연락처 = " + svcComEmpRegDto.getEmployeeContact());
		svcComEmpRegDto.setEmployeeName(
						aes.decAES256(
						toHex(svcComEmpRegDto.getEmployeeName())));
		System.out.println("복호화 = " + aes.decAES256(
							toHex(svcComEmpRegDto.getEmployeeContact())));
		svcComEmpRegDto.setEmployeeContact(aes.decAES256(
						toHex(svcComEmpRegDto.getEmployeeContact())));
		svcComEmpRegDto.setEmployeeEmail(aes.decAES256(
						toHex(svcComEmpRegDto.getEmployeeEmail())));
		
		String serviceGroupId = iSvcComEmpRegDao.serviceGroupIdRegistration(svcComEmpRegDto);
		svcComEmpRegDto.setServiceGroupId(serviceGroupId);
		int cnt = iSvcComEmpRegDao.employeeRegistration(svcComEmpRegDto);
		if(cnt > 0) {
			SvcComEmpLgnDto newEmployee = new SvcComEmpLgnDto();
			newEmployee.setEmployeeId(svcComEmpRegDto.getEmployeeId());
			sessionSvc.createEmployeeSession(session, newEmployee);
			
			
			return "정상적으로 직원이 등록되었습니다.";
		} else {
			return "직원 등록에 실패하였습니다.";
		}
	}
	
	private String toHex(String inputText) {
		byte[] inputByte = inputText.getBytes();
		
		HexConverter converter = new HexConverter();
		
		return converter.byteToHexString(inputByte);
	}

}
