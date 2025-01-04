package org.kitri.services.store.in.controller;

import java.util.List;

import org.kitri.services.store.in.service.ISsmInbMgtChkSvc;
import org.kitri.services.store.repo.dto.SsmInbMgtChkDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SsmInbMgtChkCtrl {

    @Autowired
    private ISsmInbMgtChkSvc chkSvc;

    @GetMapping("/SsmInbMgtChk/list")
    public String list(Model model) {
        List<SsmInbMgtChkDto> list = chkSvc.getInboundConfirmed();
        model.addAttribute("confirmedList", list);
        return "store/in/SsmInbMgtChk";
    }
}
