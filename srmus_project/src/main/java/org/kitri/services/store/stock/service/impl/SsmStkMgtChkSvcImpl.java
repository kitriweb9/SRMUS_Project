package org.kitri.services.store.stock.service.impl;



import java.util.List;
import java.util.stream.Collectors;

import org.kitri.services.store.repo.dto.SsmStkMgtChkDto;
import org.kitri.services.store.stock.dao.ISsmStkMgtChkDao;
import org.kitri.services.store.stock.entity.Stock;
import org.kitri.services.store.stock.service.ISsmStkMgtChkSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SsmStkMgtChkSvcImpl implements ISsmStkMgtChkSvc {

    @Autowired
    private ISsmStkMgtChkDao chkDao;

    @Override
    public List<SsmStkMgtChkDto> getAllStocks() {
        List<Stock> stocks = chkDao.selectAllStocks();
        // Entity → DTO 변환
        return stocks.stream().map(stock -> {
            SsmStkMgtChkDto dto = new SsmStkMgtChkDto();
            dto.setGoodsId(stock.getGoodsId());
            dto.setStoreId(stock.getStoreId());
            dto.setStockQuantity(stock.getStockQuantity());
            dto.setStockSafetyQuantity(stock.getStockSafetyQuantity());
            return dto;
        }).collect(Collectors.toList());
    }
}
