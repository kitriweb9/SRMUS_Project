package org.kitri.services.store.order.dao;

import org.kitri.services.store.order.entity.Order;
import org.kitri.services.store.order.entity.OrderDetail;

public interface ISsmOrdGdoRegDao {
    int getOrderSeqNextVal();
    void insertOrderMaster(Order orderEntity);
    void insertOrderDetail(OrderDetail detailEntity);
}
