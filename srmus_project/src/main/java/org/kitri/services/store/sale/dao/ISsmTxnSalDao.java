package org.kitri.services.store.sale.dao;

import java.util.List;

import org.kitri.services.store.repo.dto.SsmTxnSalDto;
import org.kitri.services.store.sale.entity.Sales;
import org.kitri.services.store.sale.entity.SalesDetail;
import org.mybatis.spring.SqlSessionTemplate;

public interface ISsmTxnSalDao {
	public void setSessionTemplate(SqlSessionTemplate sessionTemplate);

	public void addSales(Sales sales);
	public void addSalesDetail(SalesDetail salesDetail);
	public SsmTxnSalDto getSales(String purchaseId);
	public List<SsmTxnSalDto> getSalesList(SsmTxnSalDto salDto);
	public List<SsmTxnSalDto> getSalesCanceledList(SsmTxnSalDto salDto);
	public void updateSalStatus(SsmTxnSalDto salDto);
	public void updateSalStatusToN(SsmTxnSalDto salDto);
	public int getSalSeqNextVal();
	
}
