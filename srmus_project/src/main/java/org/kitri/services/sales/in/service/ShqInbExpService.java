package org.kitri.services.sales.in.service;

import java.util.List;

import org.kitri.services.sales.repo.dto.StoreInboundDto;

public interface ShqInbExpService {

	boolean addStoreInbound(StoreInboundDto inboundDto, String hqInboundDate);

	List<StoreInboundDto> findAll();

	List<StoreInboundDto> findById(String storeId);

	void approve(StoreInboundDto dto);

	void update(StoreInboundDto dto);

}
