package org.kitri.services.sales.ordered.dto;

public class ShqIgoRegIRDto {
	private String employeeId;
	private String inboundDate;
	private String goodsId;
	private int orderQuantity;
	private int totalQuantity;

	public ShqIgoRegIRDto() {
		super();
	}

	public ShqIgoRegIRDto(String employeeId, String inboundDate, String goodsId, int orderQuantity,
			int totalQuantity) {
		super();
		this.employeeId = employeeId;
		this.inboundDate = inboundDate;
		this.goodsId = goodsId;
		this.orderQuantity = orderQuantity;
		this.totalQuantity = totalQuantity;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getInboundDate() {
		return inboundDate;
	}

	public void setInboundDate(String inboundDate) {
		this.inboundDate = inboundDate;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	@Override
	public String toString() {
		return "ShqIgoRegISIDto [employeeId=" + employeeId + ", inboundDate=" + inboundDate + ", goodsId=" + goodsId
				+ ", orderQuantity=" + orderQuantity + ", totalQuantity=" + totalQuantity + "]";
	}

	

}
