package org.kitri.services.sales.close.dao.impl;

import org.kitri.services.sales.close.dao.ShqFinHqfRegDao;
import org.kitri.services.sales.repo.dto.ShqFinHqfRegDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShqFinHqfRegDaoImpl implements ShqFinHqfRegDao {
	private final SqlSessionTemplate sqlSessionTemplate;

	@Autowired
	public ShqFinHqfRegDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		super();
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public int registHqClosingInfo(ShqFinHqfRegDto hqClosing) {
		return sqlSessionTemplate.insert("HqClosing.registHqClose", hqClosing);
	}

	
	
}
