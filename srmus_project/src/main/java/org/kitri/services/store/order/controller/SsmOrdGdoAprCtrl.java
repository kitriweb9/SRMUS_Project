package org.kitri.services.store.order.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.kitri.services.store.order.service.ISsmOrdGdoAprSvc;
import org.kitri.services.store.repo.dto.SsmOrdGdoAprDto;

@Controller
public class SsmOrdGdoAprCtrl {
    
    @Autowired
    private ISsmOrdGdoAprSvc aprSvc;
    
    @PostMapping("/SsmOrdGdoApr/confirm")
    public String confirm(String[] orderIds) {
        // orderIds[]: 체크된 orderId들
        List<SsmOrdGdoAprDto> aprList = new ArrayList<>();
        if (orderIds != null) {
            for (String orderId : orderIds) {
                aprList.add(new SsmOrdGdoAprDto(orderId));
            }
        }
        
        aprSvc.confirmOrders(aprList);

        // 확정 후 목록으로
        return "redirect:/SsmOrdGdoChk/list";
    }
}
