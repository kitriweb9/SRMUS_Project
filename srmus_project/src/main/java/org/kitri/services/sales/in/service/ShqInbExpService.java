package org.kitri.services.sales.in.service;

import java.util.List;

import org.kitri.services.sales.repo.dto.ShqInbExpDto;

public interface ShqInbExpService {

	boolean addStoreInbound(ShqInbExpDto inboundDto, String hqInboundDate);

	List<ShqInbExpDto> findAll();

	List<ShqInbExpDto> findById(String storeId);

	void approve(ShqInbExpDto dto);

	void update(ShqInbExpDto dto);

}
