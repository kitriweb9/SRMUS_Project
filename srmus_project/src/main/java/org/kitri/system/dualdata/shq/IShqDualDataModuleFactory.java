package org.kitri.system.dualdata.shq;

import org.kitri.services.sales.in.entity.StoreInbound;

public interface IShqDualDataModuleFactory {
	IShqDualDataModule createModule(StoreInbound decryptedDto,
			ShqEncryptedDto encryptedDto);
}
