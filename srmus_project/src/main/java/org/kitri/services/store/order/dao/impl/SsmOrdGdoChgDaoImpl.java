package org.kitri.services.store.order.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.kitri.services.store.order.dao.ISsmOrdGdoChgDao;
import org.kitri.services.store.repo.dto.SsmOrdGdoChgDto;

@Repository
public class SsmOrdGdoChgDaoImpl implements ISsmOrdGdoChgDao {
    
    @Autowired
    private SqlSession sqlSession;
    
    private static final String NS = "SsmOrdGdoMapper";

    @Override
    public void updateOrderDetailQuantity(SsmOrdGdoChgDto dto) {
        sqlSession.update(NS + ".updateOrderDetailQuantity", dto);
    }

    @Override
    public void deleteOrderDetail(SsmOrdGdoChgDto dto) {
        sqlSession.delete(NS + ".deleteOrderDetail", dto);
    }

    @Override
    public void updateOrderRegisterDate(String orderId) {
        sqlSession.update(NS + ".updateOrderRegisterDate", orderId);
    }
}
