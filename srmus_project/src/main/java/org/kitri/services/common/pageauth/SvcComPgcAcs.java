package org.kitri.services.common.pageauth;

import org.kitri.services.common.data.pageauth.ServiceGroupDT;
import org.kitri.services.common.data.pageauth.SrumsServiceDT;

public interface SvcComPgcAcs {
	public int registerService(SrumsServiceDT serviceInfo);
	public int registerServiceGroup(ServiceGroupDT serviceGroupInfo);
	public int registerAssgin(String serviceGroupId, String serviceId);
}
