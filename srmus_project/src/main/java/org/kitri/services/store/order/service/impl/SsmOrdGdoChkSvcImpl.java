package org.kitri.services.store.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.kitri.services.store.order.dao.ISsmOrdGdoChkDao;
import org.kitri.services.store.order.service.ISsmOrdGdoChkSvc;
import org.kitri.services.store.repo.dto.SsmOrdGdoChkDto;

@Service
public class SsmOrdGdoChkSvcImpl implements ISsmOrdGdoChkSvc {

    @Autowired
    private ISsmOrdGdoChkDao chkDao;

    @Override
    public List<SsmOrdGdoChkDto> getOrderList() {
        return chkDao.selectOrderList();
    }
}
