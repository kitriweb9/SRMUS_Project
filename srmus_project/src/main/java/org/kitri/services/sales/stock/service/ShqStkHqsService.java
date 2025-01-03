package org.kitri.services.sales.stock.service;

import java.util.List;

import org.kitri.services.sales.repo.dto.GoodsStockDto;
import org.kitri.services.sales.stock.entity.GoodsStock;
import org.springframework.stereotype.Service;

@Service
public interface ShqStkHqsService {

	public void addStock(GoodsStockDto dto);

	List<GoodsStockDto> findAll();

	public void changeStock(GoodsStockDto dto);

	public List<GoodsStockDto> findByName(String goodsName);

}
