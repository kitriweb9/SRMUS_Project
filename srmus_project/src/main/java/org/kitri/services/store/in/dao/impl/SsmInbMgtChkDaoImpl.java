package org.kitri.services.store.in.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kitri.services.store.in.dao.ISsmInbMgtChkDao;
import org.kitri.services.store.repo.dto.SsmInbMgtChkDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SsmInbMgtChkDaoImpl implements ISsmInbMgtChkDao {

    @Autowired
    private SqlSession sqlSession;

    private static final String NS = "SsmInbMapper";

    @Override
    public List<SsmInbMgtChkDto> selectInboundConfirmed() {
        return sqlSession.selectList(NS + ".selectInboundConfirmed");
    }
}
