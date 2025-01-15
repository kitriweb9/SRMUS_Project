package org.kitri.services.sales.in.dao;

import java.util.List;

import org.kitri.services.sales.in.entity.StoreInbound;

public interface ShqInbExpDao {

	int save(StoreInbound inbound);

	List<StoreInbound> findAll();

	List<StoreInbound> findById(String storeId);

	void approve(StoreInbound inbound);

	void update(StoreInbound inbound);

	String getId(String storeId);
}
