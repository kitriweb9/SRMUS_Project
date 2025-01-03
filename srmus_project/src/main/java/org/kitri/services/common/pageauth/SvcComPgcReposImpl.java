package org.kitri.services.common.pageauth;

import java.util.List;

import org.kitri.services.common.data.pageauth.ServiceAssignDT;
import org.kitri.services.common.data.pageauth.ServiceGroupDT;
import org.kitri.services.common.data.pageauth.SrumsServiceDT;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SvcComPgcReposImpl implements SvcComPgcRepos {
	private final SqlSessionTemplate sqlSessionTemplate;

	@Autowired
	public SvcComPgcReposImpl(SqlSessionTemplate sqlSessionTemplate) {
		super();
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public List<ServiceAssignDT> findAuthById(String serviceGroupId) {
		return sqlSessionTemplate.selectList("ServiceAssignMapper.readAssignByGroupId", serviceGroupId);
	}

	@Override
	public List<String> findServiceOnlyByGroupId(String serviceGroupId) {
		return sqlSessionTemplate.selectList("ServiceAssignMapper.readOnlyAssignByGroupId", serviceGroupId);
	}

	@Override
	public SrumsServiceDT findServiceInfoById(String serviceId) {
		return sqlSessionTemplate.selectOne("SrumsSerivceMapper.readServiceById", serviceId);
	}

	@Override
	public ServiceGroupDT findServiceGroupInfoById(String serviceGroupId) {
		return sqlSessionTemplate.selectOne("ServiceGroupMapper.readServiceGroupById", serviceGroupId);
	}

	@Override
	public int registerService(SrumsServiceDT serviceInfo) {
		return sqlSessionTemplate.insert("SrumsSerivceMapper.registerSrumsService", serviceInfo);
	}

	@Override
	public int registerServiceGroup(ServiceGroupDT serivceGroupInfo) {
		return sqlSessionTemplate.insert("ServiceGroupMapper.registerSerivceGroup", serivceGroupInfo);
	}

	@Override
	public int registerAssign(ServiceAssignDT serviceAssignInfo) {
		return sqlSessionTemplate.insert("ServiceAssignMapper.registerAssign", serviceAssignInfo);
	}

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

}
