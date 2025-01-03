package org.kitri.services.sales.employee.dto;

public class SvcComEmpRolDto {
	private String roleId;
	private String roleName;

	public SvcComEmpRolDto() {
		super();
	}

	public SvcComEmpRolDto(String roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	
	
}
