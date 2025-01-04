package org.kitri.services.store.in.controller;

import java.util.List;

import org.kitri.services.store.in.service.ISsmInbMgtEChkSvc;
import org.kitri.services.store.repo.dto.SsmInbMgtEChkDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SsmInbMgtEChkCtrl {

    @Autowired
    private ISsmInbMgtEChkSvc eChkSvc;

    @GetMapping("/SsmInbMgtEChk/list")
    public String list(Model model) {
        List<SsmInbMgtEChkDto> list = eChkSvc.getInboundAll();
        model.addAttribute("inboundList", list);
        return "store/in/SsmInbMgtEChk";
    }
}
