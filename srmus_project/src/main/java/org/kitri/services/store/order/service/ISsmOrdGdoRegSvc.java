package org.kitri.services.store.order.service;

import org.kitri.services.store.repo.dto.SsmOrdGdoRegDto;

public interface ISsmOrdGdoRegSvc {
    void registerOrder(SsmOrdGdoRegDto regDto);
}
