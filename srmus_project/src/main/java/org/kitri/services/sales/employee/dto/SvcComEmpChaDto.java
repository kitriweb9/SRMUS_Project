package org.kitri.services.sales.employee.dto;

public class SvcComEmpChaDto {
	private String employeeId;
	private String employeePassword;
	private String employeeNewPassword;

	public SvcComEmpChaDto() {
		super();
	}

	public SvcComEmpChaDto(String employeeId, String employeePassword, String employeeNewPassword) {
		super();
		this.employeeId = employeeId;
		this.employeePassword = employeePassword;
		this.employeeNewPassword = employeeNewPassword;
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

	public String getEmployeeNewPassword() {
		return employeeNewPassword;
	}

	public void setEmployeeNewPassword(String employeeNewPassword) {
		this.employeeNewPassword = employeeNewPassword;
	}

	
}
