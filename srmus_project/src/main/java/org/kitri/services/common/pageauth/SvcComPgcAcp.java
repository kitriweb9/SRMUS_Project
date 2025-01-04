package org.kitri.services.common.pageauth;

import org.kitri.services.sales.employee.dto.SvcComEmpDto;

/**
 * SvcComPgcAcp 인터페이스는 서비스 권한을 처리하고 인증된 페이지를 반환하는 메서드를 정의합니다. 이 인터페이스를 구현하는 클래스는
 * 사용자의 권한에 맞는 페이지를 반환해야 합니다.
 */
public interface SvcComPgcAcp {
	/**
	 * 사용자의 권한을 확인하여 권한이 있으면 true, 없으면 false를 반환
	 * 
	 * @param SvcComEmpRegDto 직원 정보
	 * @param serviceId       서비스 ID (요청페이지)
	 * @return 권한이 있으면 true, 없으면 false를 반환
	 */
	public boolean hasAuthority(SvcComEmpDto svcComEmpDto, String serviceId);
	
	/**
	 * 사용자의 권한을 확인하여 권한이 있으면 해당 서비스를 요청하는 페이지를 반환하고, 권한이 없으면 "error" 페이지를 반환합니다.
	 * 
	 * @param SvcComEmpRegDto 직원 정보
	 * @param serviceId       서비스 ID
	 * @return 권한이 있으면 서비스 페이지를, 없으면 "error" 페이지를 반환
	 */
	public String handleAuthorizedPage(SvcComEmpDto svcComEmpDto, String serviceId);

	/**
	 * 직원ID에 해당하는 데이터가 저장되어 있는 캐시를 삭제합니다.
	 *
	 * @param employeeId 직원ID
	 * 
	 */
	public void invalidateCache(String employeeId);
}
