package org.kitri.system.dualdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DualDataController {

    private final DualDataService dualDataService;

    @Autowired
    public DualDataController(DualDataService dualDataService) {
        this.dualDataService = dualDataService;
    }

    @PostMapping("/processData")
    public String processData() {
        dualDataService.executeModule();
        return ""; // 결과를 표시할 JSP 파일 (result.jsp)로 이동
    }
}
