package org.kitri.services.sales.store.dao.impl;

import org.kitri.services.sales.repo.dto.ShqMktMkiChgDto;
import org.kitri.services.sales.store.dao.ShqMktMkiChgDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShqMktMkiChgDaoImpl implements ShqMktMkiChgDao {
	private final SqlSessionTemplate sqlSessionTemplate;

	@Autowired
	public ShqMktMkiChgDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		super();
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public int updateStoreInfo(ShqMktMkiChgDto shqMktMkiChgDto) {
		return sqlSessionTemplate.update("Store.updateStoreInfo", shqMktMkiChgDto);
	}

}
