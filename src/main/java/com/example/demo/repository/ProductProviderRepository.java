package com.example.demo.repository;

import com.example.demo.entity.ProductProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface ProductProviderRepository extends JpaRepository<ProductProvider, Long> {
    public Optional<ProductProvider> findById(Long id);
}
