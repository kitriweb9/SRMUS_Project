package org.kitri.services.store.in.controller;

import org.kitri.services.store.in.service.ISsmInbMgtAprSvc;
import org.kitri.services.store.in.service.ISsmInbMgtApySvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SsmInbMgtAprCtrl {

    @Autowired
    private ISsmInbMgtAprSvc aprSvc;

    @Autowired
    private ISsmInbMgtApySvc apySvc;

    @PostMapping("/SsmInbMgtApr/confirmThenStock")
    public String confirmThenStock(String[] inboundIds) {
        // Inbound 확정 처리
        aprSvc.confirmAll(inboundIds);

        // 재고 반영
        apySvc.applyStock(inboundIds);

        return "redirect:/SsmInbMgtChk/list";
    }
}

