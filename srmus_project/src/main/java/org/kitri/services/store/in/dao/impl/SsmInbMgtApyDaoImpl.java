package org.kitri.services.store.in.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.kitri.services.store.in.dao.ISsmInbMgtApyDao;
import org.kitri.services.store.repo.dto.SsmInbMgtApyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SsmInbMgtApyDaoImpl implements ISsmInbMgtApyDao {

    @Autowired
    private SqlSession sqlSession;

    private static final String NS = "SsmInbMapper";

    @Override
    public SsmInbMgtApyDto findInboundDetails(String inboundId) {
        // Inbound ID로 상세 정보 조회
        return sqlSession.selectOne(NS + ".findInboundDetails", inboundId);
    }

    @Override
    public void updateStockQuantity(SsmInbMgtApyDto dto) {
        // 재고 수량 업데이트
        sqlSession.update(NS + ".updateStockQuantity", dto);
    }
}

