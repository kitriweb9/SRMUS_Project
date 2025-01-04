package org.kitri.services.store.order.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.kitri.services.store.order.dao.ISsmOrdGdoAprDao;

@Repository
public class SsmOrdGdoAprDaoImpl implements ISsmOrdGdoAprDao {

    @Autowired
    private SqlSession sqlSession;
    
    private static final String NS = "SsmOrdGdoMapper";

    @Override
    public void updateOrderConfirm(String orderId) {
        sqlSession.update(NS + ".updateOrderConfirm", orderId);
    }
}
