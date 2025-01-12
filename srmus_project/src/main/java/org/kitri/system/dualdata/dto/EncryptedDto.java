package org.kitri.system.dualdata.dto;

import java.util.Map;

public class EncryptedDto {
    private Map<String, String> encryptedFields;

    public EncryptedDto(Map<String, String> encryptedFields) {
        this.encryptedFields = encryptedFields;
    }

    public Map<String, String> getEncryptedFields() {
        return encryptedFields;
    }

    public void setEncryptedFields(Map<String, String> encryptedFields) {
        this.encryptedFields = encryptedFields;
    }
}
