package org.kitri.services.sales.repo.dto;

public class SvcComEmpInqDto {
	private String employeeId;
	private String positionName;
	private String roleName;
	private String departmentName;
	private String employeeName;
	private String employeeContact;
	private String employeeEmail;

	public SvcComEmpInqDto() {
		super();
	}

	public SvcComEmpInqDto(String employeeId, String positionName, String roleName, String departmentName,
			String employeeName, String employeeContact, String employeeEmail) {
		super();
		this.employeeId = employeeId;
		this.positionName = positionName;
		this.roleName = roleName;
		this.departmentName = departmentName;
		this.employeeName = employeeName;
		this.employeeContact = employeeContact;
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
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

	@Override
	public String toString() {
		return "SvcComEmpInqDto [employeeId=" + employeeId + ", positionName=" + positionName + ", roleName=" + roleName
				+ ", departmentName=" + departmentName + ", employeeName=" + employeeName + ", employeeContact="
				+ employeeContact + ", employeeEmail=" + employeeEmail + "]";
	}

}
