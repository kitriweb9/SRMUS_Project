package org.kitri.services.sales.stock.service;

import java.util.List;

import org.kitri.services.sales.repo.dto.ShqStkMksDto;

public interface ShqStkMksService {
	public void addStock(ShqStkMksDto dto);

	List<ShqStkMksDto> findAll();

	public void changeStock(ShqStkMksDto dto);

	public List<ShqStkMksDto> findByStoreId(String storeId);

}
