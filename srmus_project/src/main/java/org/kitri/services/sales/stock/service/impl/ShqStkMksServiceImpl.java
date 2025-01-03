package org.kitri.services.sales.stock.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.kitri.services.sales.repo.dto.StoreStockDto;
import org.kitri.services.sales.stock.dao.ShqStkMksDao;
import org.kitri.services.sales.stock.entity.StoreStock;
import org.kitri.services.sales.stock.service.ShqStkMksService;
import org.springframework.stereotype.Service;

@Service
public class ShqStkMksServiceImpl implements ShqStkMksService {
	private final ShqStkMksDao dao;
	
	public ShqStkMksServiceImpl(ShqStkMksDao dao) {
		this.dao = dao;
	}
	@Override
	public void addStock(StoreStockDto dto) {
		StoreStock entity = toEntityFromDto(dto);
		dao.addStock(entity);
	}
	
	@Override
	public List<StoreStockDto> findAll(){
		List<StoreStock> entitys = dao.findAll();
		List<StoreStockDto> dtos = new ArrayList<StoreStockDto>();
		for (StoreStock e : entitys) {
			dtos.add(toDtoFromEntity(e));
		}
		return dtos;
	}
	
	@Override
	public List<StoreStockDto> findByStoreId(String storeId) {
		List<StoreStock> entitys = dao.findByStoreId(storeId);
		List<StoreStockDto> dtos = new ArrayList<StoreStockDto>();
		for (StoreStock e : entitys) {
			dtos.add(toDtoFromEntity(e));
		}
		return dtos;
	}
	
	@Override
	public void changeStock(StoreStockDto dto) {
		dao.changeStock(toEntityFromDto(dto));
	}

	private StoreStockDto toDtoFromEntity(StoreStock e) {
		return new StoreStockDto()
				.setStoreId(e.getStoreId())
				.setGoodsId(e.getGoodsId())
				.setGoodsName(e.getGoodsName())
				.setQty(e.getQty())
				.setUpdateDate(e.getUpdateDate().toString());
	}

	private StoreStock toEntityFromDto(StoreStockDto dto) {
		return new StoreStock()
				.setStoreId(dto.getStoreId())
				.setGoodsId(dto.getGoodsId())
				.setQty(dto.getQty());
	}
}
