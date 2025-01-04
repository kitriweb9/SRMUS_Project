package org.kitri.services.store.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.kitri.services.store.order.dao.ISsmOrdGdoChgDao;
import org.kitri.services.store.order.service.ISsmOrdGdoChgSvc;
import org.kitri.services.store.repo.dto.SsmOrdGdoChgDto;

@Service
public class SsmOrdGdoChgSvcImpl implements ISsmOrdGdoChgSvc {

    @Autowired
    private ISsmOrdGdoChgDao chgDao;

    @Override
    public void changeOrderDetail(SsmOrdGdoChgDto chgDto) {
        // 수량이 0이면 삭제, 아니면 수량 업데이트
        if (chgDto.getOrderQuantity() <= 0) {
            chgDao.deleteOrderDetail(chgDto);
        } else {
            chgDao.updateOrderDetailQuantity(chgDto);
        }
        // 마스터의 등록일시 갱신
        chgDao.updateOrderRegisterDate(chgDto.getOrderId());
    }
}
