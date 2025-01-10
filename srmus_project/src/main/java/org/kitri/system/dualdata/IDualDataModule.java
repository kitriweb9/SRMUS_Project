package org.kitri.system.dualdata;

import org.mybatis.spring.SqlSessionTemplate;

public interface IDualDataModule extends AutoCloseable {
    void initialize(Object dto);
    EncryptedDto modifyToDto();
    SqlSessionTemplate getSqlSessionTemplate();
}
