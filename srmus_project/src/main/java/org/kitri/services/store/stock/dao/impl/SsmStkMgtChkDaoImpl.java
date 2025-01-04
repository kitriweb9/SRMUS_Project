package org.kitri.services.store.stock.dao.impl;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.kitri.services.store.stock.dao.ISsmStkMgtChkDao;
import org.kitri.services.store.stock.entity.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SsmStkMgtChkDaoImpl implements ISsmStkMgtChkDao {

	@Autowired
	private SqlSession sqlSession;
	private static final String NS = "StockMapper";

	@Override
	public List<Stock> selectAllStocks() {
		return sqlSession.selectList(NS + ".selectAllStocks");
	}
}
