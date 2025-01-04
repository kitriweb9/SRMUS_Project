package org.kitri.services.store.in.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.kitri.services.store.in.dao.ISsmInbMgtChgDao;
import org.kitri.services.store.repo.dto.SsmInbMgtChgDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SsmInbMgtChgDaoImpl implements ISsmInbMgtChgDao {

    @Autowired
    private SqlSession sqlSession;

    private static final String NS = "SsmInbMapper";

    @Override
    public void updateInboundQuantity(SsmInbMgtChgDto chgDto) {
        sqlSession.update(NS + ".updateInboundQuantity", chgDto);
    }
}
