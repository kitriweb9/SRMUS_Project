package org.kitri.services.sales.in.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.kitri.services.common.file.txttoimg.SvcComTti;
import org.kitri.services.sales.in.dao.ShqInbExpDao;
import org.kitri.services.sales.in.dao.ShqInbImiDao;
import org.kitri.services.sales.in.entity.IntegrationInbound;
import org.kitri.services.sales.in.entity.StoreInbound;
import org.kitri.services.sales.in.service.ShqInbExpService;
import org.kitri.services.sales.repo.dto.ShqInbExpDto;
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
	private final SvcComTti imageConverter;
	private IShqDualDataModuleFactory moduleFactory;
	
	@Autowired
	public ShqInbExpServiceImpl(ShqInbExpDao dao, ShqInbImiDao hqDao,
			 					EncAesUtil aesUtil, IShqDualDataModuleFactory moduleFactory,
			 					SvcComTti imageConverter) {
		this.dao = dao;
		this.hqDao = hqDao;
		this.aesUtil = aesUtil;
		this.moduleFactory = moduleFactory;
		this.imageConverter = imageConverter;
	}
	
	@Override
	public boolean addStoreInbound(ShqInbExpDto inboundDto, String hqInboundDate) {
		StoreInbound entity = toEntityFromDto(addTime(inboundDto));
		entity.setConfirm("N");
		ShqEncryptedDto encryptEntity = encryptEntity(entity);
		String inboundId = dao.getId(entity.getStoreId());
		entity.setInboundId(inboundId);
		encryptEntity.setInboundId(inboundId);
		IShqDualDataModule saveModule = moduleFactory.createModule(entity, encryptEntity);
		saveModule.saveDualData();
		hqDao.ship(new IntegrationInbound()
						.setInboundDate(Timestamp.valueOf(hqInboundDate))
						.setGoodsId(entity.getGoodsId()));
		imageConverter.processTextToImage(toDtoFromEntity(entity), 0);
		return true;
	}

	@Override
	public List<ShqInbExpDto> findAll(){
		List<StoreInbound> entitys = dao.findAll();
		List<ShqInbExpDto> dto = new ArrayList<>();
		for (StoreInbound entity : entitys) {
			dto.add(toDtoFromEntity(entity));
		}
		return dto;
	}


	@Override
	public List<ShqInbExpDto> findById(String storeId){
		List<StoreInbound> entitys = dao.findById(storeId);
		List<ShqInbExpDto> dto = new ArrayList<>();
		for (StoreInbound entity : entitys) {
			dto.add(toDtoFromEntity(entity));
		}
		return dto;
	}
	
	@Override
	public void approve(ShqInbExpDto dto) {
		dao.approve(toEntityFromDto(dto));
		
	}

	@Override
	public void update(ShqInbExpDto dto) {
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
	private ShqInbExpDto toDtoFromEntity(StoreInbound entity) {
		return new ShqInbExpDto()
				  .setInboundId(entity.getInboundId())
				  .setStoreId(entity.getStoreId())
				  .setStoreName(entity.getStoreName())
				  .setInboundDate(entity.getInboundDate().toString())
				  .setGoodsId(entity.getGoodsId())
				  .setGoodsName(entity.getGoodsName())
				  .setInboundQuantity(entity.getInboundQuantity())
				  .setConfirm(entity.getConfirm());
	}

	private ShqInbExpDto addTime(ShqInbExpDto inboundDto) {
		inboundDto.setInboundDate(inboundDto.getInboundDate() + " 00:00:00");
		return inboundDto;
	}
	private StoreInbound toEntityFromDto(ShqInbExpDto inboundDto) {
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