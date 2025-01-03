package org.kitri.services.sales.employee.dto;

public class SvcComEmpRegDto {
	private String employeeId;
	private String employeePassword;
	private String employeeName;
	private String employeeContact;
	private String employeeEmail;
	private String positionId;
	private String roleId;
	private String employeeTemporaryRoleId;
	private String departmentId;
	private String serviceGroupId;

	public SvcComEmpRegDto() {
		super();
	}

	public SvcComEmpRegDto(String employeeId, String employeePassword, String employeeName, String employeeContact,
			String employeeEmail, String positionId, String roleId, String employeeTemporaryRoleId, String departmentId, String serviceGroupId) {
		super();
		this.employeeId = employeeId;
		this.employeePassword = employeePassword;
		this.employeeName = employeeName;
		this.employeeContact = employeeContact;
		this.employeeEmail = employeeEmail;
		this.positionId = positionId;
		this.roleId = roleId;
		this.employeeTemporaryRoleId = employeeTemporaryRoleId;
		this.departmentId = departmentId;
		this.serviceGroupId = serviceGroupId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeContact() {
		return employeeContact;
	}

	public void setEmployeeContact(String employeeContact) {
		this.employeeContact = employeeContact;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getPositionId() {
		return positionId;
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getEmployeeTemporaryRoleId() {
		return employeeTemporaryRoleId;
	}

	public void setEmployeeTemporaryRoleId(String employeeTemporaryRoleId) {
		this.employeeTemporaryRoleId = employeeTemporaryRoleId;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getServiceGroupId() {
		return serviceGroupId;
	}

	public void setServiceGroupId(String serviceGroupId) {
		this.serviceGroupId = serviceGroupId;
	}
	

}
