package org.kitri.services.store.in.service.impl;

import org.kitri.services.store.in.dao.ISsmInbMgtApyDao;
import org.kitri.services.store.in.service.ISsmInbMgtApySvc;
import org.kitri.services.store.repo.dto.SsmInbMgtApyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SsmInbMgtApySvcImpl implements ISsmInbMgtApySvc {

    @Autowired
    private ISsmInbMgtApyDao apyDao;

    @Override
    public void applyStock(String[] inboundIds) {
        for (String inboundId : inboundIds) {
            // 입고 상세 정보 조회
            SsmInbMgtApyDto detail = apyDao.findInboundDetails(inboundId);

            // Store ID 기본값 설정
            detail.setStoreId("ST001");

            // 재고 업데이트
            apyDao.updateStockQuantity(detail);
        }
    }
}
