package org.kitri.services.store.order.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.kitri.services.store.order.service.ISsmOrdGdoChkSvc;
import org.kitri.services.store.order.service.ISsmOrdSndSvc;
import org.kitri.services.store.repo.dto.SsmOrdGdoChkDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SsmOrdSndCtrl {

    @Autowired
    private ISsmOrdGdoChkSvc chkSvc;   // 목록 조회 (기존 Service)
    
    @Autowired
    private ISsmOrdSndSvc sndSvc;      // 전송 Service

    // 1) GET: Y 상태 주문만 보여주는 JSP
    @GetMapping("/SsmOrdSnd/beforeSend")
    public String beforeSend(Model model) {
        // (예) 전체 주문 목록 가져옴
        List<SsmOrdGdoChkDto> allList = chkSvc.getOrderList();
        // Y 상태만 필터
        List<SsmOrdGdoChkDto> yList = allList.stream()
                .filter(o -> "Y".equals(o.getOrderConfirmStatus()))
                .collect(Collectors.toList());

        model.addAttribute("yList", yList);
        return "store/order/SsmOrdSndCheck"; 
        // => /WEB-INF/views/store/order/SsmOrdSndCheck.jsp
    }

    // 2) POST: 실제 전송
    @PostMapping("/SsmOrdSnd/submit")
    public String submitOrders(String[] orderIds) {
        if (orderIds == null || orderIds.length == 0) {
            // 아무것도 선택 안하면 -> 목록 이동
            return "redirect:/SsmOrdGdoChk/list";
        }
        
        // 2-1) 전체 목록 중에서 해당 orderIds만 추려냄
        List<SsmOrdGdoChkDto> allList = chkSvc.getOrderList(); // 또는 DAO에서 IN 쿼리
        List<String> selected = Arrays.asList(orderIds);

        List<SsmOrdGdoChkDto> confirmedOrders = new ArrayList<>();
        for (SsmOrdGdoChkDto dto : allList) {
            // 상태가 Y 이면서, 체크된 orderId에 포함되는지
            if ("Y".equals(dto.getOrderConfirmStatus()) && selected.contains(dto.getOrderId())) {
                confirmedOrders.add(dto);
            }
        }

        // 2-2) 서비스 호출
        sndSvc.sendOrders(confirmedOrders);

        // 2-3) 끝나면 목록으로 리다이렉트
        return "redirect:/SsmOrdGdoChk/list";
    }
}
