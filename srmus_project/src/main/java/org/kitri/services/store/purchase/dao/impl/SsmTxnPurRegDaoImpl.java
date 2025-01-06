package org.kitri.services.store.purchase.dao.impl;

import java.util.List;

import org.kitri.services.store.purchase.dao.ISsmTxnPurRegDao;
import org.kitri.services.store.repo.dto.SsmTxnPurRegDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SsmTxnPurRegDaoImpl implements ISsmTxnPurRegDao {
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	@Autowired
	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sqlSessionTemplate = sessionTemplate;

	}

	@Override
	public void addPurchase(SsmTxnPurRegDto pdto) {
		sqlSessionTemplate.insert("purchasemapper.addpurchase", pdto);

	}

	@Override
	public void addPurchaseDetail(SsmTxnPurRegDto pdto) {
		sqlSessionTemplate.insert("purchasemapper.addpurchasedetail", pdto);

	}

	@Override
	public String getPIdByCid(String customerId) {
		String pid = sqlSessionTemplate.selectOne("purchasemapper.getpidbycid", customerId);
		return pid;
	}

	@Override
	public String getStatusByPid(String purchaseId) {
		String status = sqlSessionTemplate.selectOne("purchasemapper.getstatusbypid", purchaseId);
		return status;
	}

	@Override
	public String getPidByCidAndDate(String customerId) {
		String pid = sqlSessionTemplate.selectOne("purchasemapper.getpidbycidwithdate", customerId);
		return pid;
	}

	@Override
	public Integer getGoodsQtyByPidAndGid(SsmTxnPurRegDto pdto) {
		Integer qty = sqlSessionTemplate.selectOne("purchasemapper.getgoodsqtybypidandgid", pdto);
		return qty;
	}

	@Override
	public void updateGoodsQty(SsmTxnPurRegDto pdto) {
		sqlSessionTemplate.update("purchasemapper.updategoodsqty", pdto);

	}

	@Override
	public void updateAmount(SsmTxnPurRegDto pdto) {
		sqlSessionTemplate.update("purchasemapper.updateamount", pdto);

	}

	@Override
	public void updatePurchaseAmount(SsmTxnPurRegDto pdto) {
		sqlSessionTemplate.update("purchasemapper.updatepurchaseamount", pdto);

	}

	@Override
	public void updatePStatusToY(String purchaseId) {
		sqlSessionTemplate.update("purchasemapper.updatepstatus", purchaseId);

	}

	@Override
	public SsmTxnPurRegDto getPurchaseByPId(String purchaseId) {
		return sqlSessionTemplate.selectOne("purchasemapper.getpurchasebypid",
				purchaseId);

	}
	
	
	@Override
	public List<SsmTxnPurRegDto> getPurchaseDetailByPId(String purchaseId) {
		return sqlSessionTemplate.selectList("purchasemapper.getpurchasedetailbypid",
				purchaseId);

	}
	@Override
	public List<SsmTxnPurRegDto> getCartByPId(String purchaseId) {
		return sqlSessionTemplate.selectList("purchasemapper.getcartbypid",
				purchaseId);

	}
}
