package org.kitri.services.store.in.service.impl;

import java.util.List;

import org.kitri.services.store.in.dao.ISsmInbMgtEChkDao;
import org.kitri.services.store.in.service.ISsmInbMgtEChkSvc;
import org.kitri.services.store.repo.dto.SsmInbMgtEChkDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SsmInbMgtEChkSvcImpl implements ISsmInbMgtEChkSvc {

    @Autowired
    private ISsmInbMgtEChkDao eChkDao;

    @Override
    public List<SsmInbMgtEChkDto> getInboundAll() {
        return eChkDao.selectInboundAll();
    }
}
