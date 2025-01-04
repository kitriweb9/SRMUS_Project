package org.kitri.services.store.stock.service;

import java.util.List;
import org.kitri.services.store.repo.dto.SsmStkMgtChkDto;

public interface ISsmStkMgtChkSvc {
	List<SsmStkMgtChkDto> getAllStocks();
}
