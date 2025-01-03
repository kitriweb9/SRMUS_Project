package org.kitri.system.dualdata.ssm;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SsmEncryptedAccessor {
	private final SqlSessionTemplate sessionTemplate;

	@Autowired
	public SsmEncryptedAccessor(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}

	public boolean insertEncrypedData(SsmEncryptedDto encryptedDto) {
		return sessionTemplate.insert("EncryptedMapper.insertEncryptedDataSsm", encryptedDto) > 0;
	}
}
