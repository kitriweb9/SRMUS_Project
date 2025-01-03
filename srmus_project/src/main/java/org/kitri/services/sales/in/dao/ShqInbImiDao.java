package org.kitri.services.sales.in.dao;

import java.util.List;

import org.kitri.services.sales.in.entity.IntegrationInbound;

public interface ShqInbImiDao {
	int save(IntegrationInbound entity);
	int update(IntegrationInbound entity);
	List<IntegrationInbound> findAll();
	IntegrationInbound findById(IntegrationInbound findEntity);
	List<IntegrationInbound> findByGoodsId(String goodsId);
	List<IntegrationInbound> findByStatus(String status);
	void approve(IntegrationInbound entity);
	void ship(IntegrationInbound entity);
}
