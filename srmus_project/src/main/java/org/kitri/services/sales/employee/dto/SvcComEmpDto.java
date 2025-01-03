package org.kitri.services.sales.employee.dto;

public class SvcComEmpDto {
	private String employeeId;
	private String employeePassword;
	private String employeeName;
	private String employeeContact;
	private String employeeEmail;
	private String positionId;
	private String positionName;
	private String roleId;
	private String roleName;
	private String temporaryRoleId;
	private String temporaryRoleName;
	private String departmentId;
	private String departmentName;
	private String serviceGroupId;

	public String getEmployeeId() {
		return employeeId;
	}

	public SvcComEmpDto setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
		return this;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public SvcComEmpDto setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
		return this;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public SvcComEmpDto setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
		return this;
	}

	public String getEmployeeContact() {
		return employeeContact;
	}

	public SvcComEmpDto setEmployeeContact(String employeeContact) {
		this.employeeContact = employeeContact;
		return this;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public SvcComEmpDto setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
		return this;
	}

	public String getPositionId() {
		return positionId;
	}

	public SvcComEmpDto setPositionId(String positionId) {
		this.positionId = positionId;
		return this;
	}

	public String getPositionName() {
		return positionName;
	}

	public SvcComEmpDto setPositionName(String positionName) {
		this.positionName = positionName;
		return this;
	}

	public String getRoleId() {
		return roleId;
	}

	public SvcComEmpDto setRoleId(String roleId) {
		this.roleId = roleId;
		return this;
	}
	public String getTemporaryRoleName() {
		return temporaryRoleName;
	}
	
	public SvcComEmpDto setTemporaryRoleName(String roleName) {
		this.temporaryRoleName = roleName;
		return this;
	}

	public String getRoleName() {
		return roleName;
	}

	public SvcComEmpDto setRoleName(String roleName) {
		this.roleName = roleName;
		return this;
	}

	public String getTemporaryRoleId() {
		return temporaryRoleId;
	}

	public SvcComEmpDto setTemporaryRoleId(String temporaryRoleId) {
		this.temporaryRoleId = temporaryRoleId;
		return this;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public SvcComEmpDto setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
		return this;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public SvcComEmpDto setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
		return this;
	}

	public String getServiceGroupId() {
		return serviceGroupId;
	}

	public SvcComEmpDto setServiceGroupId(String serviceGroupId) {
		this.serviceGroupId = serviceGroupId;
		return this;
	}

}
