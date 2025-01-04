package org.kitri.services.store.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.kitri.services.store.order.dao.ISsmOrdGdoAprDao;
import org.kitri.services.store.order.service.ISsmOrdGdoAprSvc;
import org.kitri.services.store.repo.dto.SsmOrdGdoAprDto;

@Service
public class SsmOrdGdoAprSvcImpl implements ISsmOrdGdoAprSvc {

    @Autowired
    private ISsmOrdGdoAprDao aprDao;

    @Override
    public void confirmOrders(List<SsmOrdGdoAprDto> aprList) {
        for (SsmOrdGdoAprDto dto : aprList) {
            aprDao.updateOrderConfirm(dto.getOrderId());
        }
    }
}
