package org.kitri.services.sales.stock.dao;

import java.util.List;

import org.kitri.services.sales.stock.entity.GoodsStock;

public interface ShqStkHqsDao {

	List<GoodsStock> findAll();

	void addStock(GoodsStock entity);

	void changeStock(GoodsStock entityFromDto);

	List<GoodsStock> findByName(String goodsName);

}
