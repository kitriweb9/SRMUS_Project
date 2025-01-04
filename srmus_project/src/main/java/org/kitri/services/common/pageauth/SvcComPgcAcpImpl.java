package org.kitri.services.common.pageauth;

import java.util.HashMap;
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

	// 권한 체크 후 요청 페이지 리턴
	@Override
	public String handleAuthorizedPage(SvcComEmpDto svcComEmpDto, String serviceId) {
		if (hasAuthority(svcComEmpDto, serviceId)) {
			return createRequestPage(serviceId);
		} else {
			return ERRORPAGE;
		}
	}

	// 수정/등록 권한 체크
	@Override
	public Map<String, Boolean> hasAuthorityForView(SvcComEmpDto svcComEmpDto, String serviceId) {
		Map<String, Boolean> authorityMap = new HashMap<>();
		authorityMap.put("canEdit", hasAuthority(svcComEmpDto, serviceId + ".edit"));
		authorityMap.put("canRegister", hasAuthority(svcComEmpDto, serviceId + ".register"));
		return authorityMap;
	}

	// 캐시된 서비스 목록을 반환하고, 없으면 데이터베이스에서 가져오는 메소드
	@Override
	public List<String> getServiceIds(SvcComEmpDto svcComEmpDto) {
		try {
			// 캐시에서 서비스 목록을 먼저 조회
			List<String> cachedServiceIds = getCachedServiceIds(svcComEmpDto.getEmployeeId());
			if (cachedServiceIds != null) {
				return cachedServiceIds; // 캐시에 있으면 캐시된 목록 반환
			}

			// 캐시에 없으면 데이터베이스에서 서비스 목록을 조회
			List<String> authorizedServiceIds = getAuthorizedServiceIds(svcComEmpDto);
			if (authorizedServiceIds != null) {
				// 데이터를 캐시에 저장
				author.put(svcComEmpDto.getEmployeeId(), authorizedServiceIds);
				return authorizedServiceIds;
			}

			return null; // 데이터베이스에도 없으면 null 반환
		} catch (Exception e) {
			System.out.println("서비스 목록을 가져오는 중 오류: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	// 권한이 있는 서비스 ID 목록을 반환하는 메소드
	private List<String> getAuthorizedServiceIds(SvcComEmpDto svcComEmpDto) {
		try {
			// 서비스 그룹 ID를 사용하여 권한이 있는 서비스 목록을 가져옴
			return svcComPgcRepos.findServiceOnlyByGroupId(svcComEmpDto.getServiceGroupId());
		} catch (Exception e) {
			System.out.println("권한이 있는 서비스 목록을 가져오는 중 오류: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	// 캐시된 서비스 목록을 반환하는 메소드
	private List<String> getCachedServiceIds(String employeeId) {
		try {
			// 캐시에 저장된 서비스 ID 목록을 반환
			return author.get(employeeId);
		} catch (Exception e) {
			System.out.println("캐시에서 서비스 목록을 가져오는 중 오류: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
    public Map<String, Object> checkAuthority(SvcComEmpDto svcComEmpDto, String serviceId) {
        Map<String, Object> result = new HashMap<>();
        result.put("hasAuthority", hasAuthority(svcComEmpDto, serviceId));
        result.put("serviceIds", getAuthorizedServiceIds(svcComEmpDto));
        return result;
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
