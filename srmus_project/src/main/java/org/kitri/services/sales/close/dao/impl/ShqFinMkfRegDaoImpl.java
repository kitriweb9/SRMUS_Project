package org.kitri.services.sales.close.dao.impl;

import org.kitri.services.sales.close.dao.ShqFinMkfRegDao;
import org.kitri.services.sales.close.entity.MarketClosing;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShqFinMkfRegDaoImpl implements ShqFinMkfRegDao {
	private final SqlSessionTemplate sqlSessionTemplate;

	@Autowired
	public ShqFinMkfRegDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		super();
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public int registMarketClosingInfo(MarketClosing marketClosing) {
		return sqlSessionTemplate.insert("MarketClosing.registMarketClose", marketClosing);
	}

}
