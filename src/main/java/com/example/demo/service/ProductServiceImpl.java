package com.example.demo.service;

import com.example.demo.dto.ProductResponseDto;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public ProductResponseDto getProductByName(String name) {
        Product product = productRepository.findByNameParam(name);
        ProductResponseDto.ProductResponseDtoBuilder builder = new ProductResponseDto.ProductResponseDtoBuilder();
        return builder.id(product.getId()).name(product.getName()).price(product.getPrice()).build();
    }
}
