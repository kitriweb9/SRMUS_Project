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
import org.kitri.system.dualdata.core.IDualDataModule;
import org.kitri.system.dualdata.dto.EncryptedDto;
import org.kitri.system.dualdata.factory.IDualDataModuleFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShqInbExpServiceImpl implements ShqInbExpService {
	private final ShqInbExpDao dao;
	private final ShqInbImiDao hqDao;
	private final SvcComTti imageConverter;
	private IDualDataModuleFactory moduleFactory;

	@Autowired
	public ShqInbExpServiceImpl(ShqInbExpDao dao, ShqInbImiDao hqDao,
			IDualDataModuleFactory moduleFactory, SvcComTti imageConverter) {
		this.dao = dao;
		this.hqDao = hqDao;
		this.moduleFactory = moduleFactory;
		this.imageConverter = imageConverter;
	}

	@Override
	public boolean addStoreInbound(ShqInbExpDto inboundDto, String hqInboundDate) {
		StoreInbound entity = toEntityFromDto(addTime(inboundDto));
		entity.setConfirm("N");
		String inboundId = dao.getId(entity.getStoreId());
		entity.setInboundId(inboundId);

		try (IDualDataModule module = moduleFactory.createModule(entity)) {
			// DualDataModule에서 EncryptedDto 생성
			EncryptedDto encryptedDto = module.modifyToDto();
			SqlSessionTemplate sessionTemplate = module.getSqlSessionTemplate();
			// 평문 데이터 저장
			dao.save(entity);
			// 암호화 데이터 저장
			dao.encryptSave(sessionTemplate, encryptedDto);

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		hqDao.ship(new IntegrationInbound().setInboundDate(Timestamp.valueOf(hqInboundDate))
				.setGoodsId(entity.getGoodsId()));
		imageConverter.processTextToImage(toDtoFromEntity(entity), 0, inboundDto.getStoreId());
		return true;
	}

	@Override
	public List<ShqInbExpDto> findAll() {
		List<StoreInbound> entitys = dao.findAll();
		List<ShqInbExpDto> dto = new ArrayList<>();
		for (StoreInbound entity : entitys) {
			dto.add(toDtoFromEntity(entity));
		}
		return dto;
	}

	@Override
	public List<ShqInbExpDto> findById(String storeId) {
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

	private ShqInbExpDto toDtoFromEntity(StoreInbound entity) {
		return new ShqInbExpDto().setInboundId(entity.getInboundId()).setStoreId(entity.getStoreId())
				.setStoreName(entity.getStoreName()).setInboundDate(entity.getInboundDate().toString())
				.setGoodsId(entity.getGoodsId()).setGoodsName(entity.getGoodsName())
				.setInboundQuantity(entity.getInboundQuantity()).setConfirm(entity.getConfirm());
	}

	private ShqInbExpDto addTime(ShqInbExpDto inboundDto) {
		inboundDto.setInboundDate(inboundDto.getInboundDate() + " 00:00:00");
		return inboundDto;
	}

	private StoreInbound toEntityFromDto(ShqInbExpDto inboundDto) {
		Timestamp timestamp = null;
		if (inboundDto.getInboundDate() != null) {
			timestamp = Timestamp.valueOf(inboundDto.getInboundDate());
		}
		return new StoreInbound().setInboundId(inboundDto.getInboundId()).setInboundDate(timestamp)
				.setStoreId(inboundDto.getStoreId()).setInboundQuantity(inboundDto.getInboundQuantity())
				.setGoodsId(inboundDto.getGoodsId()).setConfirm(inboundDto.getConfirm());
	}
}