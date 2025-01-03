package org.kitri.services.sales.in.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.kitri.services.sales.in.dao.ShqInbExpDao;
import org.kitri.services.sales.in.dao.ShqInbImiDao;
import org.kitri.services.sales.in.entity.IntegrationInbound;
import org.kitri.services.sales.in.entity.StoreInbound;
import org.kitri.services.sales.in.service.ShqInbExpService;
import org.kitri.services.sales.repo.dto.StoreInboundDto;
import org.kitri.system.dualdata.shq.IShqDualDataModule;
import org.kitri.system.dualdata.shq.IShqDualDataModuleFactory;
import org.kitri.system.dualdata.shq.ShqEncryptedDto;
import org.kitri.system.encryption.EncAesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShqInbExpServiceImpl implements ShqInbExpService{
	private final ShqInbExpDao dao;
	private final ShqInbImiDao hqDao;
	private final EncAesUtil aesUtil;
	private IShqDualDataModuleFactory moduleFactory;
	
	@Autowired
	public ShqInbExpServiceImpl(ShqInbExpDao dao, ShqInbImiDao hqDao,
			 					EncAesUtil aesUtil, IShqDualDataModuleFactory moduleFactory) {
		this.dao = dao;
		this.hqDao = hqDao;
		this.aesUtil = aesUtil;
		this.moduleFactory = moduleFactory;
	}
	
	@Override
	public boolean addStoreInbound(StoreInboundDto inboundDto, String hqInboundDate) {
		StoreInbound entity = toEntityFromDto(addTime(inboundDto));
		IShqDualDataModule saveModule = moduleFactory.createModule(entity, encryptEntity(entity));
		saveModule.saveDualData();
		hqDao.ship(new IntegrationInbound()
						.setInboundDate(Timestamp.valueOf(hqInboundDate))
						.setGoodsId(entity.getGoodsId()));
		return true;
	}

	@Override
	public List<StoreInboundDto> findAll(){
		List<StoreInbound> entitys = dao.findAll();
		List<StoreInboundDto> dto = new ArrayList<>();
		for (StoreInbound entity : entitys) {
			dto.add(toDtoFromEntity(entity));
		}
		return dto;
	}


	@Override
	public List<StoreInboundDto> findById(String storeId){
		List<StoreInbound> entitys = dao.findById(storeId);
		List<StoreInboundDto> dto = new ArrayList<>();
		for (StoreInbound entity : entitys) {
			dto.add(toDtoFromEntity(entity));
		}
		return dto;
	}
	
	@Override
	public void approve(StoreInboundDto dto) {
		dao.approve(toEntityFromDto(dto));
		
	}

	@Override
	public void update(StoreInboundDto dto) {
		dao.update(toEntityFromDto(dto));
	}

	private ShqEncryptedDto encryptEntity(StoreInbound inbound) {
		ShqEncryptedDto encryptDto = new ShqEncryptedDto()
								  .setInboundId(toEncrypt(inbound.getInboundId()))
								  .setStoreId(toEncrypt(inbound.getStoreId()))
								  .setStoreName(toEncrypt(inbound.getStoreName()))
								  .setInboundDate(toEncrypt(inbound.getInboundDate().toString()))
								  .setGoodsId(toEncrypt(inbound.getGoodsId()))
								  .setGoodsName(toEncrypt(inbound.getGoodsName()))
								  .setInboundQuantity(toEncrypt(Integer.toString(inbound.getInboundQuantity())))
								  .setConfirm(toEncrypt(inbound.getConfirm()));
		return encryptDto;
	}
	
	private String toEncrypt(String text) {
		if(text != null) {
			return aesUtil.encAES256(text);
		} else {
			return null;
		}
	}
	private StoreInboundDto toDtoFromEntity(StoreInbound entity) {
		return new StoreInboundDto()
				  .setInboundId(entity.getInboundId())
				  .setStoreId(entity.getStoreId())
				  .setStoreName(entity.getStoreName())
				  .setInboundDate(entity.getInboundDate().toString())
				  .setGoodsId(entity.getGoodsId())
				  .setGoodsName(entity.getGoodsName())
				  .setInboundQuantity(entity.getInboundQuantity())
				  .setConfirm(entity.getConfirm());
	}

	private StoreInboundDto addTime(StoreInboundDto inboundDto) {
		inboundDto.setInboundDate(inboundDto.getInboundDate() + " 00:00:00");
		return inboundDto;
	}
	private StoreInbound toEntityFromDto(StoreInboundDto inboundDto) {
		Timestamp timestamp = null;
		if(inboundDto.getInboundDate() != null) {
			timestamp = Timestamp.valueOf(inboundDto.getInboundDate());
		}
		return new StoreInbound()
								.setInboundId(inboundDto.getInboundId())
								.setInboundDate(timestamp)
								.setStoreId(inboundDto.getStoreId())
								.setInboundQuantity(inboundDto.getInboundQuantity())
								.setGoodsId(inboundDto.getGoodsId())
								.setConfirm(inboundDto.getConfirm());
	}	
}