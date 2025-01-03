package org.kitri.services.common.login.session;

import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.kitri.services.common.data.login.session.SessionDT;
import org.kitri.services.sales.employee.dto.SvcComEmpDto;
import org.kitri.services.sales.repo.dto.SvcComEmpLgnDto;
import org.kitri.services.store.repo.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @apiNote 세션 관련
 * @author 박시연
 * @since 2024-12-23
 */
@Component
@WebListener
public class SvcComLgnSsn implements HttpSessionListener{
	private final String SESSION_LOGIN_KEY = "loginUser";
	private static ConcurrentHashMap<String, HttpSession> sessions = new ConcurrentHashMap<String, HttpSession>();
	private static String invalidateSessionId = null;
	@Autowired
	private SvcComLgnSsnDao sessionDao;
	
	/**
	 * @apiNote 세션이 지워질 때(로그아웃)
	 * @param session: 사용자 세션
	 * @author 박시연
	 * @since 2024-12-23
	 */
	public void deleteSession(HttpSession session) {
        sessions.remove(session.getId());
        session.invalidate();
	}
	
	/**
	 * @apiNote Employee 세션이 만들어질 때(회원가입)
	 * @param emp: 사용자 Dto
	 * @param session: 사용자 세션
	 * @return 세션 생성 성공에 대한 불리언 값
	 * @author 박시연
	 * @since 2024-12-23
	 */
	public boolean createEmployeeSession(HttpSession session, SvcComEmpLgnDto emp) {
		session.setAttribute(SESSION_LOGIN_KEY, emp);
		SessionDT sessionData = new SessionDT(session.getId(), emp.getEmployeeId());
		
		int result = sessionDao.insertSession(sessionData);
		
		if(result == 1) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * @apiNote Customer 세션이 만들어질 때(회원가입)
	 * @param cus: 사용자 Dto
	 * @param session: 사용자 세션
	 * @return 세션 생성 성공에 대한 불리언 값
	 * @author 박시연
	 * @since 2024-12-23
	 */
	public boolean createCustomerSession(HttpSession session, CustomerDto cus) {
		session.setAttribute(SESSION_LOGIN_KEY, cus);
			
		sessions.put(session.getId(), session);
		
		return true;
	}
	
	/**
	 * @apiNote 세션 아이디를 바꿀 때(로그인)
	 * @param emp: 사용자 Dto
	 * @param session: 사용자 세션
	 * @return 세션 변경에 대한 불리언 값
	 * @author 박시연
	 * @since 2024-12-23
	 */
	public boolean updateEmployeeSession(HttpSession session, SvcComEmpDto emp) {
		session.setAttribute(SESSION_LOGIN_KEY, emp);
		SessionDT sessionData = new SessionDT(session.getId(), emp.getEmployeeId());
		sessions.put(session.getId(), session);
		
		int result = sessionDao.updateSession(sessionData);
		
		if(result == 1) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * @apiNote 세션 아이디를 바꿀 때(로그인)
	 * @param cus: 사용자 Dto
	 * @param session: 사용자 세션
	 * @return 세션 변경에 대한 불리언 값
	 * @author 박시연
	 * @since 2024-12-23
	 */
	public boolean updateCustomerSession(HttpSession session, CustomerDto cus) {
		session.setAttribute(SESSION_LOGIN_KEY, cus);
			
		sessions.put(session.getId(), session);
			
		return true;
	}
	
	/**
	 * @apiNote 세션 아이디를 통해 세션 가져오기
	 * @param sessionId: 세션 아이디
	 * @return 사용자 세션
	 * @author 박시연
	 * @since 2024-12-23
	 */
	public static HttpSession getSession(String sessionId) {
		HttpSession session = sessions.get(sessionId);

        if( session == null ) {
        	return null;
        }
        
        return session;
    }
	
	/**
	 * @apiNote 세션에 값 추가
	 * @param session: 세션
	 * @param attName: attribute 이름
	 * @param attVal: attribute 값
	 * @author 박시연
	 * @since 2025-01-02
	 */
	public void setValue(HttpSession session, String attName, Object attVal) {
		session.setAttribute(attName, attVal);
	}
	
	/**
	 * @apiNote 세션 값 불러오기
	 * @param session: 세션
	 * @param attName: attribute 이름
	 * @return attribute 값
	 * @author 박시연
	 * @since 2025-01-02
	 */
	public Object getValue(HttpSession session, String attName) {
		return session.getAttribute(attName);
	}
	
	/**
	 * @apiNote 로그인 체크
	 * @param user: 사용자 Dto
	 * @return 로그인 유무에 따른 불리언 
	 * @author 박시연
	 * @since 2024-12-23
	 */
	public boolean isLogin(HttpSession inputSession) {
		for(String key : sessions.keySet()) {
			HttpSession session = sessions.get(key);
			Object userData = session.getAttribute(session.getId());
			
			if(userData instanceof SvcComEmpLgnDto) {
				if(inputSession.equals(session)) {
					return true;
				}
			} else if(userData instanceof CustomerDto) {
				if(inputSession.equals(session)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * @apiNote세션 종료 시 자동으로 삭제
	 * @param se: 세션 이벤트 처리
	 * @author 박시연
	 * @since 2024-12-23
	 */
	@Override
    public void sessionDestroyed(HttpSessionEvent se) {
    	invalidateSessionId = se.getSession().getId();
    	
    	sessions.remove(invalidateSessionId);
    }
}
