package org.kitri.system.dualdata.ssm;

public class SsmEncryptedDto {
	private String customer_id;
	private String customer_password;
	private String customer_name;
	private String customer_address;
	private String customer_contact;
	private String customer_email;
	private String customer_grade;

	public SsmEncryptedDto(String customer_id, String customer_password, String customer_name, String customer_address,
			String customer_contact, String customer_email, String customer_grade) {
		super();
		this.customer_id = customer_id;
		this.customer_password = customer_password;
		this.customer_name = customer_name;
		this.customer_address = customer_address;
		this.customer_contact = customer_contact;
		this.customer_email = customer_email;
		this.customer_grade = customer_grade;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_password() {
		return customer_password;
	}

	public void setCustomer_password(String customer_password) {
		this.customer_password = customer_password;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_address() {
		return customer_address;
	}

	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}

	public String getCustomer_contact() {
		return customer_contact;
	}

	public void setCustomer_contact(String customer_contact) {
		this.customer_contact = customer_contact;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public String getCustomer_grade() {
		return customer_grade;
	}

	public void setCustomer_grade(String customer_grade) {
		this.customer_grade = customer_grade;
	}

}
