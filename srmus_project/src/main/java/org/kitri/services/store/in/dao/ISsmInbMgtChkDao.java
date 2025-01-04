package org.kitri.services.store.in.dao;

import java.util.List;
import org.kitri.services.store.repo.dto.SsmInbMgtChkDto;

public interface ISsmInbMgtChkDao {
    List<SsmInbMgtChkDto> selectInboundConfirmed();
}
