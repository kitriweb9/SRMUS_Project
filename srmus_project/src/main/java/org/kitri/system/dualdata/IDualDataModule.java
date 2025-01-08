package org.kitri.system.dualdata;

public interface IDualDataModule extends AutoCloseable {
    void initialize(Object dto);
    EncryptedDto modifyToDto();
}
