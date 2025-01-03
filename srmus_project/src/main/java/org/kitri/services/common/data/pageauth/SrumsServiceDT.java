package org.kitri.services.common.data.pageauth;

public class SrumsServiceDT {
	private String serviceId;
	private String serviceName;

	public SrumsServiceDT() {
		super();
	}

	public SrumsServiceDT(String serviceId, String serviceName) {
		super();
		this.serviceId = serviceId;
		this.serviceName = serviceName;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	@Override
	public String toString() {
		return "SrumsService [serviceId=" + serviceId + ", serviceName=" + serviceName + "]";
	}

}
