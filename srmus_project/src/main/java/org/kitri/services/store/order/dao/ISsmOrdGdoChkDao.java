package org.kitri.services.store.order.dao;

import java.util.List;

import org.kitri.services.store.repo.dto.SsmOrdGdoChkDto;

public interface ISsmOrdGdoChkDao {
    List<SsmOrdGdoChkDto> selectOrderList();
}
