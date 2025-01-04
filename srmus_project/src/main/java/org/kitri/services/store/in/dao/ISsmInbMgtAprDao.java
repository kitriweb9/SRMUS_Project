package org.kitri.services.store.in.dao;

import java.util.Map;

public interface ISsmInbMgtAprDao {
    void updateInboundConfirm(String inboundId);
    void updateInboundMasterForApr(Map<String, Object> param);
}
