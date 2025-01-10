package org.kitri.services.store.purchase.dao.impl;

import java.util.List;

import org.kitri.services.store.purchase.dao.ISsmTxnPurDao;
import org.kitri.services.store.purchase.entity.Purchase;
import org.kitri.services.store.purchase.entity.PurchaseDetail;
import org.kitri.services.store.repo.dto.SsmTxnPurDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SsmTxnPurDaoImpl implements ISsmTxnPurDao {
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	@Autowired
	public void setSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public void addPurchase(Purchase purchase) {
		sqlSessionTemplate.insert("purchasemapper.insertpurchase", purchase);
	}

	@Override
	public void addPurchaseDetail(PurchaseDetail purchaseDetail) {
		sqlSessionTemplate.insert("purchasemapper.insertpurchasedetail", purchaseDetail);

	}

	@Override
	public List<SsmTxnPurDto> getPurchaseByCIdAndStatus(SsmTxnPurDto pdto) {
		List<SsmTxnPurDto> plist = sqlSessionTemplate.selectList("purchasemapper.selectlist", pdto);
		return plist;
	}

	@Override
	public void modifyPurchaseStatus(SsmTxnPurDto pdto) {
		sqlSessionTemplate.update("purchasemapper.updatestatus", pdto);
	}

	@Override
	public void deletePurchase(String purchaseId) {
		sqlSessionTemplate.delete("purchasemapper.deletepurchase", purchaseId);
	}

	@Override
	public int getPurSeqNextVal() {
		return sqlSessionTemplate.selectOne("purchasemapper.getssmpurseqnextval");
	}

}
