package org.kitri.services.sales.store.dao.impl;

import org.kitri.services.sales.repo.dto.ShqMktMkiChgDto;
import org.kitri.services.sales.store.dao.ShqMktMkiRegDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShqMktMkiRegDaoImpl implements ShqMktMkiRegDao {
	private final SqlSessionTemplate sqlSessionTemplate;

	@Autowired
	public ShqMktMkiRegDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		super();
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public int registStoreInfo(ShqMktMkiChgDto shqMktMkiChgDto) {
		return sqlSessionTemplate.insert("Store.registStore", shqMktMkiChgDto);
	}

}
