package org.kitri.services.store.in.dao.impl;

import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.kitri.services.store.in.dao.ISsmInbMgtAprDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SsmInbMgtAprDaoImpl implements ISsmInbMgtAprDao {

    @Autowired
    private SqlSession sqlSession;

    private static final String NS = "SsmInbMapper";

    @Override
    public void updateInboundConfirm(String inboundId) {
        // Inbound 확정 처리 (확정 상태 변경)
        sqlSession.update(NS + ".updateInboundConfirm", inboundId);
    }

    @Override
    public void updateInboundMasterForApr(Map<String, Object> param) {
        // Employee ID와 확정 날짜 업데이트
        sqlSession.update(NS + ".updateInboundMasterForApr", param);
    }
}

