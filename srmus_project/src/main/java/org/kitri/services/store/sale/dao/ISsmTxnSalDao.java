package org.kitri.services.store.sale.dao;

import java.util.List;

import org.kitri.services.store.repo.dto.SsmTxnPurRegDto;
import org.kitri.services.store.repo.dto.SsmTxnSalDto;
import org.kitri.services.store.sale.entity.SalesDetail;
import org.mybatis.spring.SqlSessionTemplate;

public interface ISsmTxnSalDao {
	public void setSessionTemplate(SqlSessionTemplate sessionTemplate);

	public String addSales(SsmTxnSalDto sdto);
	public void addSalesDetail(String salesId, List<SsmTxnPurRegDto> pdlist);
	public void updateSalQty(SsmTxnSalDto sdto);
	public void updateSalAmount(SsmTxnSalDto sdto);
	public void updateSalStatus(String salesId);
	public List<SsmTxnSalDto> getSalesList();
	public List<SsmTxnSalDto> getSalesListByStore(String storeId);
	public String getSIdByPId(String purchaseId);
//	public int getSalSeqNextVal();
//	public List<SalesDetail> getSalesDetailList();
	
}
