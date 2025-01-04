package org.kitri.services.store.stock.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.kitri.services.store.repo.dto.SsmStkMgtChgDto;
import org.kitri.services.store.stock.dao.ISsmStkMgtChgDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SsmStkMgtChgDaoImpl implements ISsmStkMgtChgDao {

	@Autowired
	private SqlSession sqlSession;

	private static final String NS = "StockMapper";

	@Override
	public void updateStock(SsmStkMgtChgDto stockDto) {
		sqlSession.update(NS + ".updateStock", stockDto);
	}
}
