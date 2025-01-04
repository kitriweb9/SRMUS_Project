package org.kitri.services.store.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.kitri.services.store.order.service.ISsmOrdGdoChkSvc;
import org.kitri.services.store.repo.dto.SsmOrdGdoChkDto;

@Controller
public class SsmOrdGdoChkCtrl {
    
    @Autowired
    private ISsmOrdGdoChkSvc chkSvc;
    
    @GetMapping("/SsmOrdGdoChk/list")
    public String list(Model model) {
        List<SsmOrdGdoChkDto> orderList = chkSvc.getOrderList();
        model.addAttribute("orderList", orderList);

        return "store/order/SsmOrdGdoChk";
    }
}
