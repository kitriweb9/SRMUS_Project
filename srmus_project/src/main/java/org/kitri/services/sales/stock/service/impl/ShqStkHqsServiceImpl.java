package org.kitri.services.sales.stock.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.kitri.services.sales.repo.dto.GoodsStockDto;
import org.kitri.services.sales.stock.dao.ShqStkHqsDao;
import org.kitri.services.sales.stock.entity.GoodsStock;
import org.kitri.services.sales.stock.service.ShqStkHqsService;
import org.springframework.stereotype.Service;

@Service
public class ShqStkHqsServiceImpl implements ShqStkHqsService {
	private final ShqStkHqsDao dao;
	
	public ShqStkHqsServiceImpl(ShqStkHqsDao dao) {
		this.dao = dao;
	}
	
	@Override
	public void addStock(GoodsStockDto dto) {
		GoodsStock entity = toEntityFromDto(dto);
		dao.addStock(entity);
	}
	
	@Override
	public List<GoodsStockDto> findAll(){
		List<GoodsStock> entitys = dao.findAll();
		List<GoodsStockDto> dtos = new ArrayList<GoodsStockDto>();
		for (GoodsStock e : entitys) {
			dtos.add(toDtoFromEntity(e));
		}
		return dtos;
	}
	
	@Override
	public List<GoodsStockDto> findByName(String goodsName) {
		List<GoodsStock> entitys = dao.findByName(goodsName);
		List<GoodsStockDto> dtos = new ArrayList<GoodsStockDto>();
		for (GoodsStock e : entitys) {
			dtos.add(toDtoFromEntity(e));
		}
		return dtos;
	}
	
	@Override
	public void changeStock(GoodsStockDto dto) {
		dao.changeStock(toEntityFromDto(dto));
	}

	private GoodsStockDto toDtoFromEntity(GoodsStock e) {
		return new GoodsStockDto().setGoodsId(e.getGoodsId())
				   .setGoodsName(e.getGoodsName())
				   .setQty(e.getQty())
				   .setUpdateDate(e.getUpdateDate().toString());
	}

	private GoodsStock toEntityFromDto(GoodsStockDto dto) {
		return new GoodsStock()
		.setGoodsId(dto.getGoodsId())
		.setQty(dto.getQty());
		
	}
}
