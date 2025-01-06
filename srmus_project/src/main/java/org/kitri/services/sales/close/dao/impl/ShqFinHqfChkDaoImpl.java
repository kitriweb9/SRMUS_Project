package org.kitri.services.sales.close.dao.impl;

import java.util.List;

import org.kitri.services.sales.close.dao.ShqFinHqfChkDao;
import org.kitri.services.sales.repo.dto.ShqFinHqfChkDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShqFinHqfChkDaoImpl implements ShqFinHqfChkDao {
	private SqlSessionTemplate sqlSessionTemplate;

	@Autowired
	public ShqFinHqfChkDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		super();
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public List<ShqFinHqfChkDto> getHqClosingInfo() {
		return sqlSessionTemplate.selectList("HqClosing.readHqClosingList");
	}
	
	

}
