package org.kitri.services.store.order.service.impl;

import java.util.List;

import org.kitri.services.common.Setting;
import org.kitri.services.common.file.txttoimg.SvcComTti;
import org.kitri.services.store.order.service.ISsmOrdSndSvc;
import org.kitri.services.store.repo.dto.SsmOrdGdoChkDto;
import org.kitri.services.store.repo.dto.SsmOrdSndDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SsmOrdSndSvcImpl implements ISsmOrdSndSvc {
	
	@Autowired
	private SvcComTti imageConverter;

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
    	imageConverter.processTextToImage(sndDto, 1, Setting.getStoreId());
    }
}
