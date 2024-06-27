package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product_provider")
public class ProductProvider extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
}
