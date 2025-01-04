package org.kitri.services.common.pageauth;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.kitri.services.sales.employee.dto.SvcComEmpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SvcComPgcAcpImpl implements SvcComPgcAcp {
	private final SvcComPgcRepos svcComPgcRepos;
	private final Map<String, List<String>> author = new ConcurrentHashMap<>();

	private static final String EMPLOYEE_TEMPORARY_ROLE_ID = "A";
	private static final String ERRORPAGE = "error";

	@Autowired
	public SvcComPgcAcpImpl(SvcComPgcRepos svcComPgcRepos) {
		super();
		this.svcComPgcRepos = svcComPgcRepos;
	}

	@Override
	public String handleAuthorizedPage(SvcComEmpDto svcComEmpDto, String serviceId) {
		if (hasAuthority(svcComEmpDto, serviceId)) {
			return createRequestPage(serviceId);
		} else {
			return ERRORPAGE;
		}
	}

	// 모든 권한 체크
	@Override
	public boolean hasAuthority(SvcComEmpDto svcComEmpDto, String serviceId) {
		if (isAdmin(svcComEmpDto)) {
			return true;
		}

		if (isCached(svcComEmpDto.getEmployeeId(), serviceId)) {
			return true;
		}

		if (isAuthorized(svcComEmpDto, serviceId)) {
			return true;
		}
		return false;
	}

	// 임시직책권한이 있는지 체크
	private boolean isAdmin(SvcComEmpDto svcComEmpDto) {
		return EMPLOYEE_TEMPORARY_ROLE_ID.equals(svcComEmpDto.getTemporaryRoleId());
	}

	// 캐시에 저장되어 있는지 체크
	private boolean isCached(String employeeId, String serviceId) {
		try {
			return author.containsKey(employeeId) && author.get(employeeId).contains(serviceId);
		} catch (Exception e) {
			System.out.println("캐싱 데이터 확인 중 오류: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	// 캐시 삭제
	public void invalidateCache(String employeeId) {
		author.remove(employeeId);
		System.out.println("전체 캐시 초기화");
	}

	// 데이터베이스에 저장되어 있는지 체크
	private boolean isAuthorized(SvcComEmpDto svcComEmpDto, String serviceId) {
		try {
			List<String> serviceIds = svcComPgcRepos.findServiceOnlyByGroupId(svcComEmpDto.getServiceGroupId());
			if (serviceIds != null && serviceIds.contains(serviceId)) {
				author.put(svcComEmpDto.getEmployeeId(), serviceIds);
				return true;
			}
			return false;

		} catch (Exception e) {
			System.out.println("데이터베이스 확인 중 오류: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	// 요청한 페이지 생성
	private String createRequestPage(String serviceId) {
		return svcComPgcRepos.findServiceInfoById(serviceId).getServiceName();
	}

	public SvcComPgcRepos getSvcComPgcRepos() {
		return svcComPgcRepos;
	}

}
