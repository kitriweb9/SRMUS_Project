package org.kitri.services.store.order.service;

import java.util.List;

import org.kitri.services.store.repo.dto.SsmOrdGdoChkDto;

public interface ISsmOrdGdoChkSvc {
    List<SsmOrdGdoChkDto> getOrderList();
}
