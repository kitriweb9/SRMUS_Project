package org.kitri.services.store.sreturn.dao;

import java.util.List;

import org.kitri.services.store.repo.dto.SsmRtnSndDto;
import org.mybatis.spring.SqlSessionTemplate;

public interface ISsmRtnMgtDao {
	public void setSessionTemplate(SqlSessionTemplate sessionTemplate);
	public void addReturn(SsmRtnSndDto srdto);
	public void addReturnDetail(SsmRtnSndDto srdto);
	public List<SsmRtnSndDto> getReturnList();
	public SsmRtnSndDto getReturnModiResult(String returnId);
	public void updateRSatus(String returnId);
	public void updateRtnGId(SsmRtnSndDto srdto);
	public void updateRtnQty(SsmRtnSndDto srdto);
	public void deleteReturn(String returnId);
	public void deleteReturnDetail(String returnId);
	
	//반품등록 반품조회 반품수정 반품승인 
	//반품내역서 전송
}
