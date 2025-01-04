package org.kitri.services.store.customer.entity;

public class Customer {
	private String id;
	private String password;
	private String name;
	private String address;
	private String contact;
	private String email;
	private String grade;
	
	public Customer() {
		
	}
	public Customer(String id, String password, String name, String address, String contact, String email,
			String grade) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.contact = contact;
		this.email = email;
		this.grade = grade;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
}
