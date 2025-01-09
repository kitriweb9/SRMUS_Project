package org.kitri.services.store.sreturn.dao.impl;

import java.util.List;

import org.kitri.services.store.repo.dto.SsmRtnSndDto;
import org.kitri.services.store.sreturn.dao.ISsmRtnMgtDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class SsmRtnMgtDaoImpl implements ISsmRtnMgtDao {
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	@Autowired
	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sqlSessionTemplate = sessionTemplate;

	}

	@Override
	public void addReturn(SsmRtnSndDto srdto) {
		sqlSessionTemplate.insert("salesreturn.addreturn", srdto);

	}

	@Override
	public void addReturnDetail(SsmRtnSndDto srdto) {
		sqlSessionTemplate.insert("salesreturn.addreturndetail", srdto);

	}

	@Override
	public List<SsmRtnSndDto> getReturnList() {
		return sqlSessionTemplate.selectList("salesreturn.getreturn");
	}

	@Override
	public SsmRtnSndDto getReturnModiResult(String returnId) {
		return sqlSessionTemplate.selectOne("salesreturn.getreturnbyrid",returnId);
	}
	
	@Override
	public void updateRSatus(String returnId) {
		sqlSessionTemplate.update("salesreturn.updaterstatus", returnId);

	}

	@Override
	public void updateRtnGId(SsmRtnSndDto srdto) {
		sqlSessionTemplate.update("salesreturn.updatertngid", srdto);

	}

	@Override
	public void updateRtnQty(SsmRtnSndDto srdto) {
		sqlSessionTemplate.update("salesreturn.updatertnqty", srdto);
	}

	@Override
	public void deleteReturn(String returnId) {
		sqlSessionTemplate.delete("salesreturn.deletereturn", returnId);

	}
	
	@Override
	public void deleteReturnDetail(String returnId) {
		sqlSessionTemplate.delete("salesreturn.deletereturndetail", returnId);

	}

}
