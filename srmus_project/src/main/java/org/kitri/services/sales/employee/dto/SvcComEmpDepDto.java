package org.kitri.services.sales.employee.dto;

public class SvcComEmpDepDto {
	private String departmentId;
	private String departmentName;

	public SvcComEmpDepDto() {
		super();
	}

	public SvcComEmpDepDto(String departmentId, String departmentName) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	
	
}
