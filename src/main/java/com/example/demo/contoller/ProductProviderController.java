package com.example.demo.contoller;

import com.example.demo.dto.ProductProviderResponseDto;
import com.example.demo.service.ProductProviderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/provider")
public class ProductProviderController {
    private final Logger LOGGER  = LoggerFactory.getLogger(OrderController.class);
    private final ProductProviderService productProviderService;

    public ProductProviderController(ProductProviderService productProviderService) {
        this.productProviderService = productProviderService;
    }

    @GetMapping(value = "{providerId}")
    public ProductProviderResponseDto getProductProvider(@PathVariable Long providerId) {
        ProductProviderResponseDto productProvider = productProviderService.getProductProviderById(providerId);
        return productProvider;
    }
}
