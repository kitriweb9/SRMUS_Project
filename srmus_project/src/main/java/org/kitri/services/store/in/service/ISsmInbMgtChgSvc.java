package org.kitri.services.store.in.service;

import org.kitri.services.store.repo.dto.SsmInbMgtChgDto;

public interface ISsmInbMgtChgSvc {
    void changeInboundQuantity(SsmInbMgtChgDto chgDto);
}
