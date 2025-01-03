package org.kitri.system.dualdata.ssm;

public interface ISsmDualDataModuleFactory {
    ISsmDualDataModule createModule(SsmDecryptedDto decryptedDto, SsmEncryptedDto encrypedDto);
}
