package com.example.demo.service;

import com.example.demo.dto.ProductResponseDto;

public interface ProductService {
    public ProductResponseDto getProductByName(String name);
}
