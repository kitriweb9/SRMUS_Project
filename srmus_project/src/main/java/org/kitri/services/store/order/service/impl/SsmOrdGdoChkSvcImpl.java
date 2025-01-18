package org.kitri.services.store.order.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.kitri.services.store.order.dao.ISsmOrdGdoChkDao;
import org.kitri.services.store.order.service.ISsmOrdGdoChkSvc;
import org.kitri.services.store.repo.dto.SsmOrdGdoChkDto;

@Service
public class SsmOrdGdoChkSvcImpl implements ISsmOrdGdoChkSvc {

    @Autowired
    private ISsmOrdGdoChkDao chkDao;

    @Override
    public List<SsmOrdGdoChkDto> getOrderList() {
    	// 전체 주문 목록 가져옴
        List<SsmOrdGdoChkDto> allList = chkDao.selectOrderList();
        // Y 상태만 필터
        List<SsmOrdGdoChkDto> yList = allList.stream()
                .filter(o -> "Y".equals(o.getOrderConfirmStatus()))
                .collect(Collectors.toList());
        return yList;
    }
}
