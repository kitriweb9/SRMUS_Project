package org.kitri.services.store.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.kitri.services.store.order.service.ISsmOrdGdoChgSvc;
import org.kitri.services.store.repo.dto.SsmOrdGdoChgDto;

@Controller
public class SsmOrdGdoChgCtrl {
    
    @Autowired
    private ISsmOrdGdoChgSvc chgSvc;
    
    @PostMapping("/SsmOrdGdoChg/change")
    public String change(SsmOrdGdoChgDto chgDto) {
        // JSP에서 orderId, goodsId, orderQuantity 받음
        chgSvc.changeOrderDetail(chgDto);
        
        // 변경 후 목록 JSP
        return "redirect:/SsmOrdGdoChk/list";
    }
}
