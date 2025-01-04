package org.kitri.services.store.in.service.impl;

import org.kitri.services.store.in.dao.ISsmInbMgtChgDao;
import org.kitri.services.store.in.service.ISsmInbMgtChgSvc;
import org.kitri.services.store.repo.dto.SsmInbMgtChgDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SsmInbMgtChgSvcImpl implements ISsmInbMgtChgSvc {

    @Autowired
    private ISsmInbMgtChgDao chgDao;

    @Override
    public void changeInboundQuantity(SsmInbMgtChgDto chgDto) {
        chgDao.updateInboundQuantity(chgDto);
    }
}
