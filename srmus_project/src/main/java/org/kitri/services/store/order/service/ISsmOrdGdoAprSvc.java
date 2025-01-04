package org.kitri.services.store.order.service;

import java.util.List;

import org.kitri.services.store.repo.dto.SsmOrdGdoAprDto;

public interface ISsmOrdGdoAprSvc {
    void confirmOrders(List<SsmOrdGdoAprDto> aprList);
}
