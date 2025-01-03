package org.kitri.system.dualdata.shq;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShqEncryptedAccessor {
	private final SqlSessionTemplate sessionTemplate;

	@Autowired
	public ShqEncryptedAccessor(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}

	public boolean insertEncrypedData(ShqEncryptedDto encryptedDto) {
		return sessionTemplate.insert("EncryptedMapper.insertEncryptedDataShq", encryptedDto) > 0;
	}
}
