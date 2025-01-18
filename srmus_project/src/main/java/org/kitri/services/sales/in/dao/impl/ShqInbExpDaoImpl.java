package org.kitri.services.sales.in.dao.impl;

import java.util.List;

import org.kitri.services.sales.in.dao.ShqInbExpDao;
import org.kitri.services.sales.in.entity.StoreInbound;
import org.kitri.system.dualdata.dto.EncryptedDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShqInbExpDaoImpl implements ShqInbExpDao {
	private final SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	public ShqInbExpDaoImpl(SqlSessionTemplate sqlSession) {
		sqlSessionTemplate = sqlSession;
	}

	
	@Override
	public String getId(String storeId) {
		return sqlSessionTemplate.selectOne("storeInbound.generateInboundId", storeId);
	}
	
	@Override
	public int save(StoreInbound inbound) {
		return sqlSessionTemplate.insert("storeInbound.save", inbound);
	}

	@Override
	public List<StoreInbound> findAll(){
		return sqlSessionTemplate.selectList("storeInbound.findAll");
	}

	@Override
	public List<StoreInbound> findById(String storeId){
		return sqlSessionTemplate.selectList("storeInbound.findById", storeId);
	}

	@Override
	public void approve(StoreInbound inbound) {
		sqlSessionTemplate.update("storeInbound.approve", inbound);
		
	}

	@Override
	public void update(StoreInbound inbound) {
		sqlSessionTemplate.update("storeInbound.update", inbound);
	}


	@Override
	public int encryptSave(SqlSessionTemplate encryptTemplate, EncryptedDto encryptedDto) {
		return encryptTemplate.insert("storeInbound.encryptSave", encryptedDto);
	}
}
