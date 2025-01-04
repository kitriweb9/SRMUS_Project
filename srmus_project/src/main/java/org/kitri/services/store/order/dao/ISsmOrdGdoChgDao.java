package org.kitri.services.store.order.dao;

import org.kitri.services.store.repo.dto.SsmOrdGdoChgDto;

public interface ISsmOrdGdoChgDao {
    void updateOrderDetailQuantity(SsmOrdGdoChgDto dto);
    void deleteOrderDetail(SsmOrdGdoChgDto dto);
    void updateOrderRegisterDate(String orderId);
}
