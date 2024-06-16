package com.example.demo.dto;

public class GetOrderDto {
    private int zoneId;
    private String deliveryVendor;

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

    @Override
    public String toString() {
        return String.format("GetOrderDto(zoneId=%d, deliveryVendor=%s)", zoneId, deliveryVendor);
    }
}
