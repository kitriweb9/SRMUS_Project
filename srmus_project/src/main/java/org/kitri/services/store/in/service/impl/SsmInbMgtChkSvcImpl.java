package org.kitri.services.store.in.service.impl;

import java.util.List;

import org.kitri.services.store.in.dao.ISsmInbMgtChkDao;
import org.kitri.services.store.in.service.ISsmInbMgtChkSvc;
import org.kitri.services.store.repo.dto.SsmInbMgtChkDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SsmInbMgtChkSvcImpl implements ISsmInbMgtChkSvc {

    @Autowired
    private ISsmInbMgtChkDao chkDao;

    @Override
    public List<SsmInbMgtChkDto> getInboundConfirmed() {
        return chkDao.selectInboundConfirmed();
    }
}
