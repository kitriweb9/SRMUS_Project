package org.kitri.services.store.in.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kitri.services.store.in.dao.ISsmInbMgtEChkDao;
import org.kitri.services.store.repo.dto.SsmInbMgtEChkDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SsmInbMgtEChkDaoImpl implements ISsmInbMgtEChkDao {

    @Autowired
    private SqlSession sqlSession;

    private static final String NS = "SsmInbMapper";

    @Override
    public List<SsmInbMgtEChkDto> selectInboundAll() {
        return sqlSession.selectList(NS + ".selectInboundAll");
    }
}
