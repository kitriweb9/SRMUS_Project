package org.kitri.services.common.data.pageauth;

public class ServiceGroupDT {
	private String serviceGroupId;
	private String departmentId;
	private String employeePosition;
	private String employeeRole;
	private String serviceGroupName;

	public ServiceGroupDT() {
		super();
	}

	public ServiceGroupDT(String serviceGroupId, String departmentId, String employeePosition, String employeeRole,
			String serviceGroupName) {
		super();
		this.serviceGroupId = serviceGroupId;
		this.departmentId = departmentId;
		this.employeePosition = employeePosition;
		this.employeeRole = employeeRole;
		this.serviceGroupName = serviceGroupName;
	}

	public String getServiceGroupId() {
		return serviceGroupId;
	}

	public void setServiceGroupId(String serviceGroupId) {
		this.serviceGroupId = serviceGroupId;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getEmployeePosition() {
		return employeePosition;
	}

	public void setEmployeePosition(String employeePosition) {
		this.employeePosition = employeePosition;
	}

	public String getEmployeeRole() {
		return employeeRole;
	}

	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}

	public String getServiceGroupName() {
		return serviceGroupName;
	}

	public void setServiceGroupName(String serviceGroupName) {
		this.serviceGroupName = serviceGroupName;
	}

	@Override
	public String toString() {
		return "ServiceGroupDT [serviceGroupId=" + serviceGroupId + ", departmentId=" + departmentId
				+ ", employeePosition=" + employeePosition + ", employeeRole=" + employeeRole + ", serviceGroupName="
				+ serviceGroupName + "]";
	}

}
