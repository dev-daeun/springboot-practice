package com.example.demo.dto;

public class PostOrderDto {
    private int zoneId;
    private String deliveryVendor;
    private String orderNumber;

    public int getZoneId() {
        return zoneId;
    }

    public void setZoneId(int zoneId) {
        this.zoneId = zoneId;
    }

    public String getDeliveryVendor() {
        return deliveryVendor;
    }

    public void setDeliveryVendor(String deliveryVendor) {
        this.deliveryVendor = deliveryVendor;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public String toString() {
        return String.format("PostOrderDto(zoneId=%d, deliveryVendor=%s, orderNumber=%s", zoneId, deliveryVendor, orderNumber);
    }
}
