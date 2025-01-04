package org.kitri.services.store.order.service;

import org.kitri.services.store.repo.dto.SsmOrdGdoChgDto;

public interface ISsmOrdGdoChgSvc {
    void changeOrderDetail(SsmOrdGdoChgDto chgDto);
}
