package org.kitri.system.dualdata.ssm;

public interface ISsmDualDataModule extends AutoCloseable{
	void initialize(SsmDecryptedDto decryptedDto, SsmEncryptedDto encryptedDto);
	void saveDualData();
}
