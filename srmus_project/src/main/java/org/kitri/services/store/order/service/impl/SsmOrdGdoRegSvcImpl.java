package org.kitri.services.store.order.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.kitri.services.store.order.dao.ISsmOrdGdoRegDao;
import org.kitri.services.store.order.entity.OrderDetail;
import org.kitri.services.store.order.entity.Order;
import org.kitri.services.store.order.service.ISsmOrdGdoRegSvc;
import org.kitri.services.store.repo.dto.SsmOrdGdoRegDto;

@Service
public class SsmOrdGdoRegSvcImpl implements ISsmOrdGdoRegSvc {

    @Autowired
    private ISsmOrdGdoRegDao regDao;

    @Override
    public void registerOrder(SsmOrdGdoRegDto regDto) {
        // 1) order_id 생성: yyyyMMdd + "ssm001" + seq
        String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
        int seq = regDao.getOrderSeqNextVal();
        String seqStr = String.format("%03d", seq);
        String orderId = currentDate + "ST001" + seqStr;

        // 2) 마스터 INSERT
        Order orderEntity = new Order();
        orderEntity.setOrderId(orderId);
        orderEntity.setStoreId("ST001");
        orderEntity.setOrderRegisterDate(new Timestamp(System.currentTimeMillis()));
        orderEntity.setOrderConfirmDate(null);
        orderEntity.setOrderConfirmStatus("N");
        
        regDao.insertOrderMaster(orderEntity);

        // 3) 디테일 INSERT
        OrderDetail detailEntity = new OrderDetail();
        detailEntity.setOrderId(orderId);
        detailEntity.setGoodsId(regDto.getGoodsId());
        detailEntity.setOrderQuantity(regDto.getOrderQuantity());
        
        regDao.insertOrderDetail(detailEntity);
    }
}
