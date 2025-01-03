package org.kitri.services.common.login.session;

import org.kitri.services.common.data.login.session.SessionDT;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SvcComLgnSsnDao {
	@Autowired
	private SqlSessionTemplate sqlTemplate;
	
	public SessionDT findSessionById(String id) {
		return sqlTemplate.selectOne("Session.findSessionById", id);
	}
	
	public int insertSession(SessionDT session) {
		return sqlTemplate.insert("Session.insertSession", session);
	}
	
	public int updateSession(SessionDT session) {
		return sqlTemplate.update("Session.updateSession", session);
	}
}
