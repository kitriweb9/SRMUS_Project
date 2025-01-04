package org.kitri.services.store.stock.dao;

import org.kitri.services.store.repo.dto.SsmStkMgtChgDto;

public interface ISsmStkMgtChgDao {
    void updateStock(SsmStkMgtChgDto stockDto);
}

