package org.kitri.services.store.repo.dto;

public class SsmCusLgnDto {
	private String id;
	private String pwd;
	private String name;
	private String address;
	private String contact;
	private String email;
	private String grade;
	
	public SsmCusLgnDto() {
		
	}
	public SsmCusLgnDto(String id, String pwd, String name, String address, String contact, String email, String grade) {
		this.id = id;
		this.pwd = pwd;
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
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
