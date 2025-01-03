package org.kitri.system.dualdata.ssm;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SsmDecryptedAccessor {
	private final SqlSessionTemplate sessionTemplate;

	@Autowired
	public SsmDecryptedAccessor(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}

	public boolean insertDecryptedData(SsmDecryptedDto decryptedDto) {
		return sessionTemplate.insert("DecryptedMapper.insertDecryptedDataSsm", decryptedDto) > 0;
	}
}
