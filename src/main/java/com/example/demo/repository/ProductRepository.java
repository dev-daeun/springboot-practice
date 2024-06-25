package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product AS p WHERE p.name = :name")
    Product findByNameParam(@Param("name") String name);
}
