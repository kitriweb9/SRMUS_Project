package org.kitri.services.store.sale.dao.impl;

import java.util.List;

import org.kitri.services.store.repo.dto.SsmTxnSalDto;
import org.kitri.services.store.sale.dao.ISsmTxnSalDao;
import org.kitri.services.store.sale.entity.Sales;
import org.kitri.services.store.sale.entity.SalesDetail;
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
	public void addSales(Sales sales) {
		sqlSessionTemplate.insert("salesmapper.addsales", sales);
		
	}

	@Override
	public void addSalesDetail(SalesDetail salesDetail) {
		sqlSessionTemplate.insert("salesmapper.addsalesdetail", salesDetail);
		
	}
	public SsmTxnSalDto getSales(String purchaseId) {
		return sqlSessionTemplate.selectOne("salesmapper.getsales", purchaseId);
	}

	@Override
	public List<SsmTxnSalDto> getSalesList(SsmTxnSalDto salDto) {
		List<SsmTxnSalDto> salList = sqlSessionTemplate.selectList("salesmapper.getsaleslist", salDto);
		return salList;
	}
	
	@Override
	public List<SsmTxnSalDto> getSalesCanceledList(SsmTxnSalDto salDto) {
		List<SsmTxnSalDto> salList = sqlSessionTemplate.selectList("salesmapper.getsalescanceledlist", salDto);
		return salList;
	}
	
	@Override
	public void updateSalStatus(SsmTxnSalDto salDto) {
		sqlSessionTemplate.update("salesmapper.updatesalstatus", salDto);
		
	}
	@Override
	public void updateSalStatusToN(SsmTxnSalDto salDto) {
		sqlSessionTemplate.update("salesmapper.updatesalstatuston", salDto);
		
	}

	@Override
	public int getSalSeqNextVal() {
		return sqlSessionTemplate.selectOne("salesmapper.getssmsalseqnextval");
	}
}
