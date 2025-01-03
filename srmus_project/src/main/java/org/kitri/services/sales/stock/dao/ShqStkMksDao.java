package org.kitri.services.sales.stock.dao;

import java.util.List;

import org.kitri.services.sales.stock.entity.StoreStock;

public interface ShqStkMksDao {
	List<StoreStock> findAll();

	void addStock(StoreStock entity);

	void changeStock(StoreStock entity);

	List<StoreStock> findByStoreId(String goodsName);
}
