package org.kitri.services.sales.stock.service;

import java.util.List;

import org.kitri.services.sales.repo.dto.GoodsStockDto;
import org.kitri.services.sales.repo.dto.StoreStockDto;

public interface ShqStkMksService {
	public void addStock(StoreStockDto dto);

	List<StoreStockDto> findAll();

	public void changeStock(StoreStockDto dto);

	public List<StoreStockDto> findByStoreId(String storeId);

}
