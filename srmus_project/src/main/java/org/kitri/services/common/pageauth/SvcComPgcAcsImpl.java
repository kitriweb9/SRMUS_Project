package org.kitri.services.common.pageauth;

import org.kitri.services.common.data.pageauth.ServiceAssignDT;
import org.kitri.services.common.data.pageauth.ServiceGroupDT;
import org.kitri.services.common.data.pageauth.SrumsServiceDT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SvcComPgcAcsImpl implements SvcComPgcAcs {
	private final SvcComPgcRepos svcComPgcRepos;

	@Autowired
	public SvcComPgcAcsImpl(SvcComPgcRepos svcComPgcRepos) {
		super();
		this.svcComPgcRepos = svcComPgcRepos;
	}

	@Override
	public int registerService(SrumsServiceDT serviceInfo) {
		return svcComPgcRepos.registerService(serviceInfo);
	}

	@Override
	public int registerServiceGroup(ServiceGroupDT serviceGroupInfo) {
		return svcComPgcRepos.registerServiceGroup(serviceGroupInfo);
	}

	@Override
	public int registerAssgin(String serviceGroupId, String serviceId) {
		return svcComPgcRepos.registerAssign(new ServiceAssignDT(serviceGroupId, serviceId));
	}

	public SvcComPgcRepos getSvcComPgcRepos() {
		return svcComPgcRepos;
	}

}
