package org.kitri.services.sales.stock.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.kitri.services.sales.repo.dto.ShqStkMksDto;
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
	public void addStock(ShqStkMksDto dto) {
		StoreStock entity = toEntityFromDto(dto);
		dao.addStock(entity);
	}
	
	@Override
	public List<ShqStkMksDto> findAll(){
		List<StoreStock> entitys = dao.findAll();
		List<ShqStkMksDto> dtos = new ArrayList<ShqStkMksDto>();
		for (StoreStock e : entitys) {
			dtos.add(toDtoFromEntity(e));
		}
		return dtos;
	}
	
	@Override
	public List<ShqStkMksDto> findByStoreId(String storeId) {
		List<StoreStock> entitys = dao.findByStoreId(storeId);
		List<ShqStkMksDto> dtos = new ArrayList<ShqStkMksDto>();
		for (StoreStock e : entitys) {
			dtos.add(toDtoFromEntity(e));
		}
		return dtos;
	}
	
	@Override
	public void changeStock(ShqStkMksDto dto) {
		dao.changeStock(toEntityFromDto(dto));
	}

	private ShqStkMksDto toDtoFromEntity(StoreStock e) {
		return new ShqStkMksDto()
				.setStoreId(e.getStoreId())
				.setGoodsId(e.getGoodsId())
				.setGoodsName(e.getGoodsName())
				.setQty(e.getQty())
				.setUpdateDate(e.getUpdateDate().toString());
	}

	private StoreStock toEntityFromDto(ShqStkMksDto dto) {
		return new StoreStock()
				.setStoreId(dto.getStoreId())
				.setGoodsId(dto.getGoodsId())
				.setQty(dto.getQty());
	}
}
