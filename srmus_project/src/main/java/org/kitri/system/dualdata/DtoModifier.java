package org.kitri.system.dualdata;

import org.kitri.system.encryption.EncAesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DtoModifier {

    private final EncAesUtil encAesUtil;

    @Autowired
    public DtoModifier(EncAesUtil encAesUtil) {
        this.encAesUtil = encAesUtil;
    }

    public Map<String, String> modify(Map<String, String> fieldMap) {
        Map<String, String> encryptedMap = new HashMap<>();
        fieldMap.forEach((key, value) -> encryptedMap.put(key, encAesUtil.encAES256(value)));
        return encryptedMap;
    }
}
