package org.kitri.services.store.repo.dto;

public class SsmOrdSndDto {
	private String storeId; // 매장 ID
	private String orderId; // 주문 ID
	private String goodsId; // 상품 ID
	private int orderQuantity; // 수량

	public SsmOrdSndDto() {
	}

	public SsmOrdSndDto(String storeId, String orderId, String goodsId, int orderQuantity) {
		this.storeId = storeId;
		this.orderId = orderId;
		this.goodsId = goodsId;
		this.orderQuantity = orderQuantity;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
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
}
