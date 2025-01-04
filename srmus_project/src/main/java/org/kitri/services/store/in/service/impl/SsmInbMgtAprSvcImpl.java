package org.kitri.services.store.in.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.kitri.services.store.in.dao.ISsmInbMgtAprDao;
import org.kitri.services.store.in.service.ISsmInbMgtAprSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SsmInbMgtAprSvcImpl implements ISsmInbMgtAprSvc {

    @Autowired
    private ISsmInbMgtAprDao aprDao;

    @Override
    public void confirmAll(String[] inboundIds) {
        for (String inboundId : inboundIds) {
            // Inbound 확정 처리
            aprDao.updateInboundConfirm(inboundId);

            // Employee 정보와 확정 날짜 업데이트
            Map<String, Object> params = new HashMap<>();
            params.put("inboundId", inboundId);
            params.put("employeeId", "EMP999"); // 예시: 하드코딩된 값
            aprDao.updateInboundMasterForApr(params);
        }
    }
}


