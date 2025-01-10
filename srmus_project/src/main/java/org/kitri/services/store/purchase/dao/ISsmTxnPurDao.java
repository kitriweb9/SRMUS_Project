package org.kitri.services.store.purchase.dao;

import java.util.List;

import org.kitri.services.store.purchase.entity.Purchase;
import org.kitri.services.store.purchase.entity.PurchaseDetail;
import org.kitri.services.store.repo.dto.SsmTxnPurDto;
import org.mybatis.spring.SqlSessionTemplate;

public interface ISsmTxnPurDao {
	public void setSessionTemplate(SqlSessionTemplate sqlSessionTemplate);


	public void addPurchase(Purchase purchase);
	public void addPurchaseDetail(PurchaseDetail purchaseDetail);
	public List<SsmTxnPurDto> getPurchaseByCIdAndStatus(SsmTxnPurDto pdto);
	public void modifyPurchaseStatus(SsmTxnPurDto pdto);
	public void deletePurchase(String purchaseId);
	public int getPurSeqNextVal();
	
}