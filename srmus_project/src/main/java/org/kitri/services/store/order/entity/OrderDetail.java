package org.kitri.services.store.order.entity;

public class OrderDetail {
    private String orderId;
    private String goodsId;
    private int orderQuantity;
    
    public OrderDetail() {}

    public OrderDetail(String orderId, String goodsId, int orderQuantity) {
        this.orderId = orderId;
        this.goodsId = goodsId;
        this.orderQuantity = orderQuantity;
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
