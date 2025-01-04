package org.kitri.services.common.pageauth;

import java.util.List;
import java.util.Map;

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
	 * 수정 및 등록버튼에 대해 동적 페이지 구성을 위한 권한을 체크하는 메소드로 키값에 해당하는 "edit" 또는 "reg"에 따라 true,
	 * false 값을 통해 페이지에서 동적으로 버튼을 숨길 수 있다.
	 * 
	 * @param SvcComEmpRegDto 직원 정보
	 * @param serviceId       서비스 ID (요청)
	 * @return Map<String, Boolean> Key -> "edit", "reg" / value -> true or false
	 */
	public Map<String, Boolean> hasAuthorityForView(SvcComEmpDto svcComEmpDto, String serviceId);

	/**
	 * 사용자가 접속가능한 서비스 목록을 반환해주는 메소드
	 * 
	 * @param SvcComEmpRegDto 직원 정보
	 * @return List<String>
	 */
	public List<String> getServiceIds(SvcComEmpDto svcComEmpDto);

	/**
	 * 사용자 권한 여부와 사용자가 접속가능한 서비스 모두 반환하는 메소드로
	 * Key 값으로 "hasAuthority" 에는 value 값에 boolean이 담겨있고,
	 * Key 값으로 "serviceIds" 에는 value 값에 List<String>으로 접속 가능한 서비스ID 목록이 담겨있음,
	 * 사용시 다운캐스팅
	 * example)
	 * Map<String, Object> authorityResult = svcComPgcAcpImpl.hasAuthority(svcComEmpDto, serviceId);
	 * boolean hasAuthority = (boolean) authorityResult.get("hasAuthority");
	 * List<String> serviceIds = (List<String>) authorityResult.get("serviceIds");
	 * 
	 * 
	 * @param SvcComEmpRegDto 직원 정보
	 * @param serviceId       서비스 ID (요청)
	 * @return List<String>
	 */
	public Map<String, Object> checkAuthority(SvcComEmpDto svcComEmpDto, String serviceId);

	/**
	 * 직원ID에 해당하는 데이터가 저장되어 있는 캐시를 삭제합니다.
	 *
	 * @param employeeId 직원ID
	 * 
	 */
	public void invalidateCache(String employeeId);
}
