package org.kitri.services.store.order.entity;

import java.sql.Timestamp;

public class Order {
    private String orderId;
    private String storeId;
    private Timestamp orderRegisterDate;
    private Timestamp orderConfirmDate;
    private String orderConfirmStatus; // 'N' or 'Y'
    
    public Order() {}

    public Order(String orderId, String storeId, Timestamp orderRegisterDate,
                       Timestamp orderConfirmDate, String orderConfirmStatus) {
        this.orderId = orderId;
        this.storeId = storeId;
        this.orderRegisterDate = orderRegisterDate;
        this.orderConfirmDate = orderConfirmDate;
        this.orderConfirmStatus = orderConfirmStatus;
    }

    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public String getStoreId() {
        return storeId;
    }
    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }
    public Timestamp getOrderRegisterDate() {
        return orderRegisterDate;
    }
    public void setOrderRegisterDate(Timestamp orderRegisterDate) {
        this.orderRegisterDate = orderRegisterDate;
    }
    public Timestamp getOrderConfirmDate() {
        return orderConfirmDate;
    }
    public void setOrderConfirmDate(Timestamp orderConfirmDate) {
        this.orderConfirmDate = orderConfirmDate;
    }
    public String getOrderConfirmStatus() {
        return orderConfirmStatus;
    }
    public void setOrderConfirmStatus(String orderConfirmStatus) {
        this.orderConfirmStatus = orderConfirmStatus;
    }
}
