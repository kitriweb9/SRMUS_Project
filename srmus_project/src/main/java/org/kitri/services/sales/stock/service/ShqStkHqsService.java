package org.kitri.services.sales.stock.service;

import java.util.List;

import org.kitri.services.sales.repo.dto.ShqStkHqsDto;
import org.kitri.services.sales.stock.entity.GoodsStock;
import org.springframework.stereotype.Service;

@Service
public interface ShqStkHqsService {

	public void addStock(ShqStkHqsDto dto);

	List<ShqStkHqsDto> findAll();

	public void changeStock(ShqStkHqsDto dto);

	public List<ShqStkHqsDto> findByName(String goodsName);

}
