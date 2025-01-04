package org.kitri.services.store.in.dao;

import java.util.List;
import org.kitri.services.store.repo.dto.SsmInbMgtEChkDto;

public interface ISsmInbMgtEChkDao {
    List<SsmInbMgtEChkDto> selectInboundAll();
}
