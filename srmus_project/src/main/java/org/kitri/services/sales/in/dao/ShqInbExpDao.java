package org.kitri.services.sales.in.dao;

import java.util.List;

import org.kitri.services.sales.in.entity.StoreInbound;
import org.kitri.system.dualdata.dto.EncryptedDto;
import org.mybatis.spring.SqlSessionTemplate;

public interface ShqInbExpDao {

	int save(StoreInbound inbound);

	List<StoreInbound> findAll();

	List<StoreInbound> findById(String storeId);

	void approve(StoreInbound inbound);

	void update(StoreInbound inbound);

	String getId(String storeId);

	int encryptSave(SqlSessionTemplate sessionTemplate, EncryptedDto encryptedDto);
}
