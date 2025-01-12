package org.kitri.system.dualdata.core;

import org.kitri.system.dualdata.dto.EncryptedDto;
import org.mybatis.spring.SqlSessionTemplate;

public interface IDualDataModule extends AutoCloseable {
    void initialize(Object dto);
    EncryptedDto modifyToDto();
    SqlSessionTemplate getSqlSessionTemplate();
}
