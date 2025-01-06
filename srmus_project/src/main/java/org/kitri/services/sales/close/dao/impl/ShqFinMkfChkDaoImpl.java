package org.kitri.services.sales.close.dao.impl;

import java.util.List;

import org.kitri.services.sales.close.dao.ShqFinMkfChkDao;
import org.kitri.services.sales.repo.dto.ShqFinMkfChkDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

@Repository
public class ShqFinMkfChkDaoImpl implements ShqFinMkfChkDao {
	private final SqlSessionTemplate sqlSessionTemplate;

	@Autowired
	public ShqFinMkfChkDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		super();
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public List<ShqFinMkfChkDto> getMarketClosingInfo() {
		return sqlSessionTemplate.selectList("MarketClosing.readmarketClosingList");
	}

	@Override
	public List<ShqFinMkfChkDto> findClosingInfoFilterByDate(String requestDate) {
		return sqlSessionTemplate.selectList("MarketClosing.readClosureFilterByDate", requestDate);
	}

}
