package com.example.demo.contoller;

import com.example.demo.dto.ProductResponseDto;
import com.example.demo.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final Logger LOGGER  = LoggerFactory.getLogger(OrderController.class);
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ProductResponseDto getProduct(@RequestParam String name) {
        ProductResponseDto product = productService.getProductByName(name);
        return product;
    }
}
