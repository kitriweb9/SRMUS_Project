package org.kitri.services.sales.in.dao.impl;

import java.util.List;

import org.kitri.services.sales.in.dao.ShqInbImiDao;
import org.kitri.services.sales.in.entity.IntegrationInbound;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("shqInbImiDao")
public class ShqInbImiDaoImpl implements ShqInbImiDao {
	private final SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	public ShqInbImiDaoImpl(SqlSessionTemplate sqlSession) {
		sqlSessionTemplate = sqlSession;
	}

	@Override
	public int save(IntegrationInbound entity) {
		return sqlSessionTemplate.insert("hqinbound.save", entity);
	}

	@Override
	public int update(IntegrationInbound entity) {
		IntegrationInbound findById = findById(entity);
		if(findById == null) {
			System.out.println("데이터 베이스에 없는 정보입니다.");
			return 0;
		}
		return sqlSessionTemplate.update("hqinbound.update", entity);
	}
	
	@Override
	public IntegrationInbound findById(IntegrationInbound findEntity) {
		return sqlSessionTemplate.selectOne("hqinbound.findById", findEntity);
	}

	@Override
	public List<IntegrationInbound> findAll() {
		return sqlSessionTemplate.selectList("hqinbound.findAll");
	}

	@Override
	public List<IntegrationInbound> findByGoodsId(String goodsId) {
		return sqlSessionTemplate.selectList("hqinbound.findByGoodsId", goodsId);
	}
	
	@Override
	public List<IntegrationInbound> findByStatus(String status) {
		return sqlSessionTemplate.selectList("hqinbound.findByStatus", status);
	}

	@Override
	public void approve(IntegrationInbound entity) {
		sqlSessionTemplate.update("hqinbound.approve", entity);
	}
	
	@Override
	public void ship(IntegrationInbound entity) {
		sqlSessionTemplate.update("hqinbound.ship", entity);
	}
}
