package org.kitri.services.store.customer.service.impl;

import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.http.HttpSession;

import org.kitri.services.common.login.login.SvcComLgnInf;
import org.kitri.services.store.customer.dao.ISsmCusLgnCusDao;
import org.kitri.services.store.customer.service.ISsmCusLgnSvc;
import org.kitri.services.store.repo.dto.SsmCusLgnDto;
import org.kitri.system.dualdata.core.IDualDataModule;
import org.kitri.system.dualdata.dto.EncryptedDto;
import org.kitri.system.dualdata.factory.IDualDataModuleFactory;
import org.kitri.system.encryption.EncAesUtil;
import org.kitri.system.encryption.HexConverter;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SsmCusLgnSvcImpl implements ISsmCusLgnSvc {
	@Autowired
	private IDualDataModuleFactory moduleFactory;
	@Autowired
	private ISsmCusLgnCusDao cusDao;
	@Autowired
	private SvcComLgnInf svcComLgnInf;
	@Autowired
	private EncAesUtil aes;

	@Transactional
	public boolean register(SsmCusLgnDto customer) throws SQLIntegrityConstraintViolationException {
		if ((cusDao.findCustomerById(customer.getId())) != null) {
			throw new SQLIntegrityConstraintViolationException();
		}

		customer = new SsmCusLgnDto(customer.getId(), customer.getPwd(), toHex(customer.getName()),
				toHex(customer.getAddress()), toHex(customer.getContact()), toHex(customer.getEmail()),
				customer.getGrade());

		customer = new SsmCusLgnDto(customer.getId(), customer.getPwd(), aes.decAES256(customer.getName()),
				aes.decAES256(customer.getAddress()), aes.decAES256(customer.getContact()),
				aes.decAES256(customer.getEmail()), customer.getGrade());

		try (IDualDataModule module = moduleFactory.createModule(customer)) {
			// DualDataModule에서 EncryptedDto 생성
			EncryptedDto encryptedDto = module.modifyToDto();
			SqlSessionTemplate sessionTemplate = module.getSqlSessionTemplate();
			// 평문 데이터 저장
			cusDao.insertCustomer(customer);
			// 암호화 데이터 저장
			cusDao.insertEncryptedCustomer(sessionTemplate, encryptedDto);

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return true;
	}

	private String toHex(String inputText) {
		byte[] inputByte = inputText.getBytes();

		HexConverter converter = new HexConverter();

		return converter.byteToHexString(inputByte);
	}

	@Override
	public boolean logout(HttpSession session, String id) {
		session.invalidate();
		return true;
	}

	@Override
	public SsmCusLgnDto userInfo(String id) {
		return (SsmCusLgnDto) svcComLgnInf.userInfo(id);
	}

}
