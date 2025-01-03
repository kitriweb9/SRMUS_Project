package org.kitri.services.sales.store.dao.impl;

import java.util.List;

import org.kitri.services.sales.store.dao.ShqMktMkiChkDao;
import org.kitri.services.sales.store.entity.Store;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShqMktMkiChkDaoImpl implements ShqMktMkiChkDao {

	private final SqlSessionTemplate sqlSessionTemplate;

	@Autowired
	public ShqMktMkiChkDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		super();
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public List<Store> findStoreList() {
		return sqlSessionTemplate.selectList("Store.readStoreList");
	}

}
