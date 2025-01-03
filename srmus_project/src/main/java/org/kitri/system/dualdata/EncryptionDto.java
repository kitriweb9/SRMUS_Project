package org.kitri.system.dualdata;

public class EncryptionDto {
	private Customer customer;
	private Key key;
	
	public EncryptionDto() {}

	public EncryptionDto(Customer customer, Key key) {
		super();
		this.customer = customer;
		this.key = key;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}
	
}
