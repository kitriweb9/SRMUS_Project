package org.kitri.services.store.stock.service;

import org.kitri.services.store.repo.dto.SsmStkMgtChgDto;

public interface ISsmStkMgtChgSvc {
	void updateStock(SsmStkMgtChgDto stockDto);
}
