package org.kitri.services.sales.goods.dao.impl;

import org.kitri.services.sales.goods.dao.ShqPdtPdiRegDao;
import org.kitri.services.sales.repo.dto.ShqPdtPdiChgDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShqPdtPdiRegDaoImpl implements ShqPdtPdiRegDao {
	private final SqlSessionTemplate sqlSessionTemplate;

	@Autowired
	public ShqPdtPdiRegDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		super();
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public int registGoodsInfo(ShqPdtPdiChgDto shqPdtPdiChgDto) {
		return sqlSessionTemplate.insert("Goods.registGoods", shqPdtPdiChgDto);
	}

}
