package org.kitri.services.store.order.service.impl;

import java.util.List;

import org.kitri.services.store.order.service.ISsmOrdSndSvc;
import org.kitri.services.store.repo.dto.SsmOrdGdoChkDto;
import org.kitri.services.store.repo.dto.SsmOrdSndDto;
import org.springframework.stereotype.Service;

@Service
public class SsmOrdSndSvcImpl implements ISsmOrdSndSvc {

    @Override
    public void sendOrders(List<SsmOrdGdoChkDto> confirmedOrderList) {
        // 0) 방어 로직
        if (confirmedOrderList == null || confirmedOrderList.isEmpty()) {
            System.out.println("[SsmOrdSndSvcImpl] 전송할 확정 주문이 없습니다.");
            return;
        }

        // 1) for문으로 반복, 한 건씩 "SsmOrdSndDto"를 만들고, 모듈 호출
        for (SsmOrdGdoChkDto order : confirmedOrderList) {
            // 1-1) 변환
            SsmOrdSndDto sndDto = new SsmOrdSndDto();
            sndDto.setStoreId(order.getStoreId());
            sndDto.setOrderId(order.getOrderId());
            sndDto.setGoodsId(order.getGoodsId());
            sndDto.setOrderQuantity(order.getOrderQuantity());

            // 1-2) 외부 모듈 호출
            callExternalModule(sndDto);
        }
    }

    private void callExternalModule(SsmOrdSndDto sndDto) {
        System.out.println("[SsmOrdSndSvcImpl] callExternalModule() 호출");
        System.out.println("storeId=" + sndDto.getStoreId() 
            + ", orderId=" + sndDto.getOrderId() 
            + ", goodsId=" + sndDto.getGoodsId() 
            + ", quantity=" + sndDto.getOrderQuantity());
        // 실제 로직: REST API 통신, DB Insert, MQ 발행 등
    }
}
