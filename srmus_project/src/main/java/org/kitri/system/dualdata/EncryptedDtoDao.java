package org.kitri.system.dualdata;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EncryptedDtoDao {

    private final SqlSession sqlSession;

    @Autowired
    public EncryptedDtoDao(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSession = sqlSessionTemplate;
    }

    public void insertEncryptedData(EncryptedDto encryptedDto) {
        sqlSession.insert("org.kitri.system.dualdata.EncryptedDtoDao.insertEncryptedData", encryptedDto);
    }
}
