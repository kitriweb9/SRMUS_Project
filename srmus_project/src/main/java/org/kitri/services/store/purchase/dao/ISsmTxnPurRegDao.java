package org.kitri.services.store.purchase.dao;

import java.util.List;

import org.kitri.services.store.purchase.entity.Purchase;
import org.kitri.services.store.purchase.entity.PurchaseDetail;
import org.kitri.services.store.repo.dto.SsmTxnPurRegDto;
import org.mybatis.spring.SqlSessionTemplate;

public interface ISsmTxnPurRegDao {
	public void setSessionTemplate(SqlSessionTemplate sessionTemplate);


	public void addPurchase(SsmTxnPurRegDto pdto);
	public void addPurchaseDetail(SsmTxnPurRegDto pdto);
	public String getPIdByCid(String customerId);
	public String getPidByCidAndDate(String customerId);
	public Integer getGoodsQtyByPidAndGid(SsmTxnPurRegDto pdto);
	public String getStatusByPid(String purchaseId);
	public void updateGoodsQty(SsmTxnPurRegDto pdto);
	public void updateAmount(SsmTxnPurRegDto pdto);
	public void updatePurchaseAmount(SsmTxnPurRegDto pdto);
	public void updatePStatusToY(String purchaseId);
	public SsmTxnPurRegDto getPurchaseByPId(String purchaseId);
	public List<SsmTxnPurRegDto> getPurchaseDetailByPId(String purchaseId);
	public List<SsmTxnPurRegDto> getCartByPId(String purchaseId);
}
