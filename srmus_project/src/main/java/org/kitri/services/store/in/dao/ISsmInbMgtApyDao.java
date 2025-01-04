package org.kitri.services.store.in.dao;

import org.kitri.services.store.repo.dto.SsmInbMgtApyDto;

public interface ISsmInbMgtApyDao {
    SsmInbMgtApyDto findInboundDetails(String inboundId);
    void updateStockQuantity(SsmInbMgtApyDto dto);
}

