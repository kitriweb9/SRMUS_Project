package org.kitri.services.store.goods.dao.impl;

import java.util.List;

import org.kitri.services.store.goods.dao.ISsmGdsChkDao;
import org.kitri.services.store.repo.dto.SsmGdsChkDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SsmGdsChkDaoImpl implements ISsmGdsChkDao {
	@Autowired
	SqlSessionTemplate sqlTemplate;
	
	@Override
	public List<SsmGdsChkDto> findGoodsAll() {
		return sqlTemplate.selectList("Goods.findGoodsAll");
	}

}
