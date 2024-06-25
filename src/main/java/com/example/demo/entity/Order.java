package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "zone_id", nullable = false)
    private int zoneId;

    @Column(name = "delivery_vendor")
    private String deliveryVendor;

    @Column(name = "order_number", nullable = false, unique = true)
    private String orderNumber;

}
