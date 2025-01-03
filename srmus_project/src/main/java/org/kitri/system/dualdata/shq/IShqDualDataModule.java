package org.kitri.system.dualdata.shq;

import org.kitri.services.sales.in.entity.StoreInbound;

public interface IShqDualDataModule extends AutoCloseable {
	void initialize(StoreInbound decryptedDto, ShqEncryptedDto encryptedDto);
	void saveDualData();
}
