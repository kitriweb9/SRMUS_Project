package org.kitri.services.store.stock.dao;

import java.util.List;
import org.kitri.services.store.stock.entity.Stock;

public interface ISsmStkMgtChkDao {
	List<Stock> selectAllStocks();
}
