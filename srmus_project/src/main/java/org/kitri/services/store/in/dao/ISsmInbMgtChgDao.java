package org.kitri.services.store.in.dao;

import org.kitri.services.store.repo.dto.SsmInbMgtChgDto;

public interface ISsmInbMgtChgDao {
    void updateInboundQuantity(SsmInbMgtChgDto chgDto);
}
