package org.kitri.services.store.in.service;

import java.util.List;
import org.kitri.services.store.repo.dto.SsmInbMgtEChkDto;

public interface ISsmInbMgtEChkSvc {
    List<SsmInbMgtEChkDto> getInboundAll();

}
