package org.kitri.services.sales.goods.dao.impl;

import java.util.List;

import org.kitri.services.sales.goods.dao.ShqPdtPdiChkDao;
import org.kitri.services.sales.repo.dto.ShqPdtPdiChkDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShqPdtPdiChkDaoImpl implements ShqPdtPdiChkDao {
	private final SqlSessionTemplate sqlSessionTemplate;

	@Autowired
	public ShqPdtPdiChkDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		super();
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public List<ShqPdtPdiChkDto> getGoodsList() {
		return sqlSessionTemplate.selectList("Goods.readGoodsList");
	}

}
