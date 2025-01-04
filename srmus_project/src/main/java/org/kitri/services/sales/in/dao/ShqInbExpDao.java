package org.kitri.services.sales.in.dao;

import java.util.List;

import org.kitri.services.sales.in.entity.IntegrationInbound;
import org.kitri.services.sales.in.entity.StoreInbound;
import org.kitri.services.sales.repo.dto.ShqInbExpDto;

public interface ShqInbExpDao {

	int save(StoreInbound inbound);

	List<StoreInbound> findAll();

	List<StoreInbound> findById(String storeId);

	void approve(StoreInbound inbound);

	void update(StoreInbound entityFromDto);

	String getId(String storeId);
}
