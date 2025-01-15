package org.kitri.services.sales.stock.dao.impl;

import java.util.List;

import org.kitri.services.sales.stock.dao.ShqStkHqsDao;
import org.kitri.services.sales.stock.entity.GoodsStock;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ShqStkHqsDaoImpl implements ShqStkHqsDao{
	private final SqlSessionTemplate sql;
	
	public ShqStkHqsDaoImpl(SqlSessionTemplate template) {
		sql = template;
	}
	
	public List<GoodsStock> findAll(){
		return sql.selectList("goodsStock.findAll");
	}
	
	@Override
	public void addStock(GoodsStock entity) {
		if((int)sql.selectOne("goodsStock.checkGoodsExist", entity) < 1 ) {
			sql.insert("goodsStock.newGoodsStock", entity);
		} else {
			sql.update("goodsStock.addStock", entity);
		}
		
	}

	@Override
	public void changeStock(GoodsStock entity) {
		sql.update("goodsStock.changeStock", entity);
		
	}

	@Override
	public List<GoodsStock> findByName(String goodsName) {
		return sql.selectList("goodsStock.findByName", goodsName);
	}

}
