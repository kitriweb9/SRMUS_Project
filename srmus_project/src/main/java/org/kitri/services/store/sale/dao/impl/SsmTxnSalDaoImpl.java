package org.kitri.services.store.sale.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kitri.services.store.repo.dto.SsmTxnPurRegDto;
import org.kitri.services.store.repo.dto.SsmTxnSalDto;
import org.kitri.services.store.sale.dao.ISsmTxnSalDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SsmTxnSalDaoImpl implements ISsmTxnSalDao {
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	@Autowired
	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sqlSessionTemplate = sessionTemplate;

	}

	@Override
	public String addSales(SsmTxnSalDto sdto) {
		sqlSessionTemplate.insert("salesmapper.addsales", sdto);
		return sdto.getSalesId();
	}

	@Override
	public void addSalesDetail(String salesId, List<SsmTxnPurRegDto> pdlist) {
		 // SqlSession을 사용하여 MyBatis XML 쿼리 실행
        Map<String, Object> params = new HashMap<>();
        params.put("salesId", salesId);
        params.put("pdlist", pdlist);

		sqlSessionTemplate.insert("salesmapper.addsalesdetail", params);
	}
	
	@Override
	public void updateSalQty(SsmTxnSalDto sdto) {
		sqlSessionTemplate.update("salesmapper.updatesalqty", sdto);
	}

	@Override
	public void updateSalAmount(SsmTxnSalDto sdto) {
		sqlSessionTemplate.update("salesmapper.updatesalamount", sdto);
		
	}

	@Override
	public void updateSalStatus(String salesId) {
		sqlSessionTemplate.update("salesmapper.updatesalstatus", salesId);
	}

	@Override
	public List<SsmTxnSalDto> getSalesList() {
		return sqlSessionTemplate.selectList("salesmapper.getsaleslist");
	}

	@Override
	public List<SsmTxnSalDto> getSalesListByStore(String storeId) {
		return sqlSessionTemplate.selectList("salesmapper.getsaleslistbystore", storeId);
	}
	
	@Override
	public String getSIdByPId(String purchaseId) {
		String sid = sqlSessionTemplate.selectOne("salesmapper.getsidbypid", purchaseId);
		return sid;
	}
//
//	@Override
//	public int getSalSeqNextVal() {
//		int salseq = sqlSessionTemplate.selectOne("salesmapper.getSalesSeqCurrVal");
//		return salseq;
//	}
//
//	@Override
//	public List<SsmTxnSalDto> getSalesDetailList(String storeId) {
//		List<SsmTxnPurRegDto> pdlist =sqlSessionTemplate.selectList("salesmapper.getsaleslistbystore", storeId);
//		List<SsmTxnSalDto> slist = new 
//		return slist;
//	}
}
