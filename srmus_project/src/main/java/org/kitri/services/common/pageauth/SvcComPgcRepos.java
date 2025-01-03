package org.kitri.services.common.pageauth;

import java.util.List;

import org.kitri.services.common.data.pageauth.ServiceAssignDT;
import org.kitri.services.common.data.pageauth.ServiceGroupDT;
import org.kitri.services.common.data.pageauth.SrumsServiceDT;
/**
 * SvcComPgcRepos 인터페이스는 페이지 처리와 관련된  정보를 
 * 데이터베이스로부터 데이터를 조회/등록/수정하는 메서드를 정의합니다.
 * 이 인터페이스를 구현한 클래스는 요청한 데이터를 반환해야 합니다.
 */
public interface SvcComPgcRepos {
	
	/**
	 * 요청한 서비스 그룹 ID에 대한 서비스등록정보 리스트를 반환합니다.
	 * 
	 * @param serviceGroupId 서비스 그룹 ID
	 * @return 해당 데이터가 있으면 List<ServiceAssignDT> 형태로 서비스 그룹 ID, 서비스 ID가 담긴 객체 리스트 반환
	 */
	public List<ServiceAssignDT> findAuthById(String serviceGroupId);
	
	/**
	 * 요청한 서비스그룹ID에 해당하는 서비스ID(접속가능한 페이지)만 리스트로 반환합니다.
	 * 
	 * @param serviceGroupId 서비스 그룹 ID
	 * @return 해당 데이터가 있으면 List<String> 형태로 서비스 ID만 담아서 리스트 반환
	 */
	public List<String> findServiceOnlyByGroupId(String serviceGroupId);
	
	/**
	 * 요청한 서비스ID에 해당하는 서비스 정보를 반환합니다.
	 * 
	 * @param serviceId 서비스 ID
	 * @return 해당 데이터가 있으면 SrumsServiceDT 형태로 서비스 ID, 서비스 이름이 담긴 객체 반환
	 */
	public SrumsServiceDT findServiceInfoById(String serviceId);
	
	/**
	 * 요청한 서비스 그룹ID에 대한 서비스 그룹 정보를 반환합니다.
	 * 
	 * @param serviceGroupId 서비스 그룹 ID
	 * @return 해당 데이터가 있으면 ServiceGroupDT 형태로 서비스 그룹 ID, 부서 ID, 직급ID, 직책ID, 서비스그룹이름이 담긴 객체 반환
	 */
	public ServiceGroupDT findServiceGroupInfoById(String ServiceGroupId);
	
	/**
	 * 시스템에 존재하는 페이지(서비스)를 생성하는 메소드로 
	 * 등록에 성공하면 등록한 행에 해당하는 행 개수를 반환합니다.
	 * 
	 * @param SrumsServiceDT 서비스정보
	 * @return 등록에 성공하면 등록한 행에 해당한 int 반환
	 */
	public int registerService(SrumsServiceDT serviceInfo);
	
	/**
	 * 사용자가 속할 그룹정보를 생성하는 메소드로 
	 * 등록에 성공하면 등록한 행에 해당하는 행 개수를 반환합니다.
	 * 
	 * @param ServiceGroupDT 서비스 그룹 정보
	 * @return 등록에 성공하면 등록한 행에 해당한 int 반환
	 */
	public int registerServiceGroup(ServiceGroupDT serivceGroupInfo);
	
	/**
	 * 그룹 ID와 해당 그룹이 권한을 가지는 서비스ID를 등록하는 메서드
	 * 
	 * @param ServiceAssignDT 서비스 등록 정보
	 * @return 등록에 성공하면 등록한 행에 해당한 int 반환
	 */
	public int registerAssign(ServiceAssignDT serviceAssignInfo);
}
