package org.kitri.services.store.order.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.kitri.services.store.order.dao.ISsmOrdGdoChkDao;
import org.kitri.services.store.repo.dto.SsmOrdGdoChkDto;

@Repository
public class SsmOrdGdoChkDaoImpl implements ISsmOrdGdoChkDao {
    
    @Autowired
    private SqlSession sqlSession;
    
    private static final String NS = "SsmOrdGdoMapper";

    @Override
    public List<SsmOrdGdoChkDto> selectOrderList() {
        return sqlSession.selectList(NS + ".selectOrderList");
    }
}
