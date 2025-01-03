package org.kitri.services.sales.stock.dao.impl;

import java.util.List;

import org.kitri.services.sales.stock.dao.ShqStkMksDao;
import org.kitri.services.sales.stock.entity.StoreStock;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ShqStkMksDaoImpl implements ShqStkMksDao{
	private final SqlSessionTemplate sql;
	
	public ShqStkMksDaoImpl(SqlSessionTemplate template) {
		sql = template;
	}
	
	public List<StoreStock> findAll(){
		return sql.selectList("storeStock.findAll");
	}
	
	@Override
	public void addStock(StoreStock entity) {
		if((int)sql.selectOne("storeStock.checkGoodsExist", entity) < 1 ) {
			sql.insert("storeStock.newGoodsStock", entity);
		} else {
			sql.update("storeStock.addStock", entity);
		}
		
	}

	@Override
	public void changeStock(StoreStock entity) {
		sql.update("storeStock.changeStock", entity);
		
	}

	@Override
	public List<StoreStock> findByStoreId(String storeId) {
		return sql.selectList("storeStock.findByStoreId", storeId);
	}

}
