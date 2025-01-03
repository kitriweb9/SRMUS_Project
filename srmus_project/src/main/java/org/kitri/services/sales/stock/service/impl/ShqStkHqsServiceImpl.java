package org.kitri.services.sales.stock.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.kitri.services.sales.repo.dto.ShqStkHqsDto;
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
	public void addStock(ShqStkHqsDto dto) {
		GoodsStock entity = toEntityFromDto(dto);
		dao.addStock(entity);
	}
	
	@Override
	public List<ShqStkHqsDto> findAll(){
		List<GoodsStock> entitys = dao.findAll();
		List<ShqStkHqsDto> dtos = new ArrayList<ShqStkHqsDto>();
		for (GoodsStock e : entitys) {
			dtos.add(toDtoFromEntity(e));
		}
		return dtos;
	}
	
	@Override
	public List<ShqStkHqsDto> findByName(String goodsName) {
		List<GoodsStock> entitys = dao.findByName(goodsName);
		List<ShqStkHqsDto> dtos = new ArrayList<ShqStkHqsDto>();
		for (GoodsStock e : entitys) {
			dtos.add(toDtoFromEntity(e));
		}
		return dtos;
	}
	
	@Override
	public void changeStock(ShqStkHqsDto dto) {
		dao.changeStock(toEntityFromDto(dto));
	}

	private ShqStkHqsDto toDtoFromEntity(GoodsStock e) {
		return new ShqStkHqsDto().setGoodsId(e.getGoodsId())
				   .setGoodsName(e.getGoodsName())
				   .setQty(e.getQty())
				   .setUpdateDate(e.getUpdateDate().toString());
	}

	private GoodsStock toEntityFromDto(ShqStkHqsDto dto) {
		return new GoodsStock()
		.setGoodsId(dto.getGoodsId())
		.setQty(dto.getQty());
		
	}
}
