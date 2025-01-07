package org.kitri.services.store.sreturn.entity;

import java.util.Date;

public class Return {
	private String returnId;
	private String storeId;
	private String employeeId;
	private Date returnRegisterDate;
	
	public Return() {}

	public Return(String returnId, String storeId, String employeeId, Date returnRegisterDate) {
		super();
		this.returnId = returnId;
		this.storeId = storeId;
		this.employeeId = employeeId;
		this.returnRegisterDate = returnRegisterDate;
	}

	public String getReturnId() {
		return returnId;
	}

	public void setReturnId(String returnId) {
		this.returnId = returnId;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public Date getReturnRegisterDate() {
		return returnRegisterDate;
	}

	public void setReturnRegisterDate(Date returnRegisterDate) {
		this.returnRegisterDate = returnRegisterDate;
	}
	
	
	
}
