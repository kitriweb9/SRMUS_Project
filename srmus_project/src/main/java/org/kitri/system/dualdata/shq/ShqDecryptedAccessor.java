package org.kitri.system.dualdata.shq;

import org.kitri.services.sales.in.entity.StoreInbound;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShqDecryptedAccessor {
	private final SqlSessionTemplate sessionTemplate;

	@Autowired
	public ShqDecryptedAccessor(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}

	public boolean insertDecryptedData(StoreInbound decryptedDto) {
		return sessionTemplate.insert("DecryptedMapper.insertDecryptedDataShq", decryptedDto) > 0;
	}
}
