package org.kitri.services.store.customer.service.impl;

import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.http.HttpSession;

import org.kitri.services.common.login.login.SvcComLgnInf;
import org.kitri.services.common.login.login.SvcComLgnLin;
import org.kitri.services.common.login.login.SvcComLgnLot;
import org.kitri.services.common.login.session.SvcComLgnSsn;
import org.kitri.services.store.customer.dao.ISsmCusLgnCusDao;
import org.kitri.services.store.customer.service.ISsmCusLgnSvc;
import org.kitri.services.store.repo.dto.SsmCusLgnDto;
import org.kitri.system.dualdata.ssm.ISsmDualDataModule;
import org.kitri.system.dualdata.ssm.ISsmDualDataModuleFactory;
import org.kitri.system.dualdata.ssm.SsmDecryptedDto;
import org.kitri.system.dualdata.ssm.SsmEncryptedDto;
import org.kitri.system.encryption.EncAesUtil;
import org.kitri.system.encryption.HexConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SsmCusLgnSvcImpl implements ISsmCusLgnSvc {
	@Autowired
	private ISsmDualDataModuleFactory moduleFactory;
	@Autowired
	private ISsmCusLgnCusDao cusDao;
	@Autowired
	private SvcComLgnSsn svcComLgnSsn;
	@Autowired
	private SvcComLgnLin svcComLgnLin;
	@Autowired
	private SvcComLgnLot svcComLgnLot;
	@Autowired
	private SvcComLgnInf svcComLgnInf;
	@Autowired
	private EncAesUtil aes;
	
	public boolean register(SsmCusLgnDto customer) throws SQLIntegrityConstraintViolationException {
		if( (cusDao.findCustomerById(customer.getId())) != null) {
			throw new SQLIntegrityConstraintViolationException();
		}
		
		customer = new SsmCusLgnDto(customer.getId(), customer.getPwd(), toHex(customer.getName()), toHex(customer.getAddress()), toHex(customer.getContact()), toHex(customer.getEmail()), customer.getGrade());
		
//		EncAesUtil aes = new EncAesUtil();
		
		SsmDecryptedDto decDto = new SsmDecryptedDto(customer.getId(), customer.getPwd(), aes.decAES256(customer.getName()), aes.decAES256(customer.getAddress()), aes.decAES256(customer.getContact()), aes.decAES256(customer.getEmail()), customer.getGrade());
		
		System.out.println(customer.getAddress());
		System.out.println(customer.getContact());
		System.out.println(customer.getEmail());
		
		System.out.println(decDto.getCustomer_contact());
		System.out.println(decDto.getCustomer_address());
		System.out.println(decDto.getCustomer_email());
		
		SsmEncryptedDto encDto = new SsmEncryptedDto(customer.getId(), customer.getPwd(), aes.encAES256Re(decDto.getCustomer_name()), aes.encAES256Re(decDto.getCustomer_address()), aes.encAES256Re(decDto.getCustomer_contact()), aes.encAES256Re(decDto.getCustomer_email()), customer.getGrade());
		
		try (ISsmDualDataModule module = moduleFactory.createModule(decDto, encDto)) {
			module.saveDualData(); // 데이터 저장
		} catch (Exception e) {
			System.out.println("예외 발생: " + e.getMessage());
		}
		
		return true;
	}
	
	private String toHex(String inputText) {
		byte[] inputByte = inputText.getBytes();
		
		HexConverter converter = new HexConverter();
		
		return converter.byteToHexString(inputByte);
	}

	@Override
	public boolean login(HttpSession session, String id, String pwd) {
		return svcComLgnLin.login(session, id, pwd);
	}

	@Override
	public boolean logout(HttpSession session, String id) {
		if(svcComLgnSsn.isLogin(session)) {
			svcComLgnLot.logout(svcComLgnSsn.getSession(session.getId()));
			return true;
		}
		return false;
	}

	@Override
	public SsmCusLgnDto userInfo(String id) {
		return (SsmCusLgnDto) svcComLgnInf.userInfo(id);
	}

}
