package org.kitri.services.store.customer.dao;

import org.kitri.services.store.repo.dto.SsmCusLgnDto;
import org.kitri.system.dualdata.dto.EncryptedDto;
import org.mybatis.spring.SqlSessionTemplate;

public interface ISsmCusLgnCusDao {
	public SsmCusLgnDto findCustomerById(String id);
	public int insertCustomer(SsmCusLgnDto customer);
	public int insertEncryptedCustomer(SqlSessionTemplate sqlSessionTemplate, EncryptedDto encryptedDto);
}
