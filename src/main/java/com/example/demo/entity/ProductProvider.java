package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product_provider")
@Getter
@Setter
@NoArgsConstructor
public class ProductProvider extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "productProvider", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Product> productList = new ArrayList<>();
}
