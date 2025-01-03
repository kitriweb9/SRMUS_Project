package org.kitri.services.sales.goods.dao.impl;

import java.util.List;

import org.kitri.services.sales.goods.dao.ShqPdtPdiChgDao;
import org.kitri.services.sales.repo.dto.ShqPdtPdiChgCtgDto;
import org.kitri.services.sales.repo.dto.ShqPdtPdiChgDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShqPdtPdiChgDaoImpl implements ShqPdtPdiChgDao {
	private final SqlSessionTemplate sqlSessionTemplate;

	@Autowired
	public ShqPdtPdiChgDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		super();
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public List<ShqPdtPdiChgCtgDto> getCategories() {
		return sqlSessionTemplate.selectList("Category.readCategoryList");
	}

	@Override
	public int updateGoodsInfo(ShqPdtPdiChgDto shqPdtPdiChgCtgDto) {
		return sqlSessionTemplate.update("Goods.updateGoodsInfo", shqPdtPdiChgCtgDto);
	}

}
