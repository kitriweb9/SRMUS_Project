package org.kitri.services.common.pageauth;

public class EmployeeDto {
	private String employeeId;
	private String employeeTemporaryRoleId;
	private String serviceGroupId;

	public EmployeeDto() {
		super();
	}

	public EmployeeDto(String employeeId, String employeeTemporaryRoleId, String serviceGroupId) {
		super();
		this.employeeId = employeeId;
		this.employeeTemporaryRoleId = employeeTemporaryRoleId;
		this.serviceGroupId = serviceGroupId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeTemporaryRoleId() {
		return employeeTemporaryRoleId;
	}

	public void setEmployeeTemporaryRoleId(String employeeTemporaryRoleId) {
		this.employeeTemporaryRoleId = employeeTemporaryRoleId;
	}

	public String getServiceGroupId() {
		return serviceGroupId;
	}

	public void setServiceGroupId(String serviceGroupId) {
		this.serviceGroupId = serviceGroupId;
	}

}
