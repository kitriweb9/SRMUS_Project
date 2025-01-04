package org.kitri.services.store.in.service;

import java.util.List;
import org.kitri.services.store.repo.dto.SsmInbMgtChkDto;

public interface ISsmInbMgtChkSvc {
    List<SsmInbMgtChkDto> getInboundConfirmed();
}
