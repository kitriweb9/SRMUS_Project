package org.kitri.services.store.order.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.kitri.services.store.order.dao.ISsmOrdGdoRegDao;
import org.kitri.services.store.order.entity.Order;
import org.kitri.services.store.order.entity.OrderDetail;

@Repository
public class SsmOrdGdoRegDaoImpl implements ISsmOrdGdoRegDao {

    @Autowired
    private SqlSession sqlSession;

    private static final String NS = "SsmOrdGdoMapper";

    @Override
    public int getOrderSeqNextVal() {
        return sqlSession.selectOne(NS + ".getOrderSeqNextVal");
    }

    @Override
    public void insertOrderMaster(Order orderEntity) {
        sqlSession.insert(NS + ".insertOrderMaster", orderEntity);
    }

    @Override
    public void insertOrderDetail(OrderDetail detailEntity) {
        sqlSession.insert(NS + ".insertOrderDetail", detailEntity);
    }
}
