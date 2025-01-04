package org.kitri.services.store.in.controller;

import org.kitri.services.store.in.service.ISsmInbMgtChgSvc;
import org.kitri.services.store.repo.dto.SsmInbMgtChgDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SsmInbMgtChgCtrl {

    @Autowired
    private ISsmInbMgtChgSvc chgSvc;

    @PostMapping("/SsmInbMgtChg/change")
    public String change(SsmInbMgtChgDto chgDto) {
        chgSvc.changeInboundQuantity(chgDto);
        return "redirect:/SsmInbMgtEChk/list";
    }
}
