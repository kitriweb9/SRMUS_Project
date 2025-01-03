package org.kitri.services.common.data.pageauth;

public class ServiceAssignDT {
	private String serviceGroupId;
	private String serviceId;

	public ServiceAssignDT() {
		super();
	}

	public ServiceAssignDT(String serviceGroupId, String serviceId) {
		super();
		this.serviceGroupId = serviceGroupId;
		this.serviceId = serviceId;
	}

	public String getServiceGroupId() {
		return serviceGroupId;
	}

	public void setServiceGroupId(String serviceGroupId) {
		this.serviceGroupId = serviceGroupId;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	@Override
	public String toString() {
		return "ServiceAssignDT [serviceGroupId=" + serviceGroupId + ", serviceId=" + serviceId + "]";
	}

}
