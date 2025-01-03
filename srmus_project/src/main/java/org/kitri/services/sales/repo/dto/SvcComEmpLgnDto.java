package org.kitri.services.sales.repo.dto;

public class SvcComEmpLgnDto {
	private String employeeId;
	private String employeePassword;
	private String employeeName;
	private String employeeContact;
	private String employeeEmail;
	private String positionName;
	private String roleName;
	private String employeeTemporaryRoleName;
	private String departmentName;
	private String serviceGroupName;

	public SvcComEmpLgnDto() {
		
	}
	public SvcComEmpLgnDto(String employeeId, String employeePassword, String employeeName, String employeeContact,
			String employeeEmail, String positionName, String roleName, String employeeTemporaryRoleName,
			String departmentName, String serviceGroupName) {
		this.employeeId = employeeId;
		this.employeePassword = employeePassword;
		this.employeeName = employeeName;
		this.employeeContact = employeeContact;
		this.employeeEmail = employeeEmail;
		this.positionName = positionName;
		this.roleName = roleName;
		this.employeeTemporaryRoleName = employeeTemporaryRoleName;
		this.departmentName = departmentName;
		this.serviceGroupName = serviceGroupName;
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
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getEmployeeTemporaryRoleName() {
		return employeeTemporaryRoleName;
	}
	public void setEmployeeTemporaryRoleName(String employeeTemporaryRoleName) {
		this.employeeTemporaryRoleName = employeeTemporaryRoleName;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getServiceGroupName() {
		return serviceGroupName;
	}
	public void setServiceGroupName(String serviceGroupName) {
		this.serviceGroupName = serviceGroupName;
	}
}
