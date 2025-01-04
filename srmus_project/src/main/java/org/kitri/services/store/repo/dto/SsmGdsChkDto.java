package org.kitri.services.store.repo.dto;

public class SsmGdsChkDto {
	private String id;
	private String category;
	private String name;
	private int price;
	private String unit;
	private String factory;
	
	public SsmGdsChkDto() {}
	public SsmGdsChkDto(String id, String category, String name, int price, String unit, String factory) {
		this.id = id;
		this.category = category;
		this.name = name;
		this.price = price;
		this.unit = unit;
		this.factory = factory;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getFactory() {
		return factory;
	}
	public void setFactory(String factory) {
		this.factory = factory;
	}
}
