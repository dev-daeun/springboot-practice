package com.example.demo.dto;

import com.example.demo.entity.Product;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ProductProviderResponseDto {
    @NonNull
    private Long id;
    @NonNull private String name;
    @NonNull ArrayList<ProductResponseDto> products;

    public static ProductProviderResponseDto.ProductProviderResponseDtoBuilder builder() {
        return new ProductProviderResponseDto.ProductProviderResponseDtoBuilder();
    }

    @NoArgsConstructor
    public static class ProductProviderResponseDtoBuilder {
        private Long id;
        private String name;
        private ArrayList<ProductResponseDto> products;

        public ProductProviderResponseDto.ProductProviderResponseDtoBuilder id(Long id) {
            this.id = id;
            return this;
        };
        public ProductProviderResponseDto.ProductProviderResponseDtoBuilder name(String name) {
            this.name = name;
            return this;
        };
        public ProductProviderResponseDto.ProductProviderResponseDtoBuilder products(List<Product> products) {
            ArrayList<ProductResponseDto> productsDto = new ArrayList<>();
            for (Product p: products) {
                productsDto.add(new ProductResponseDto(p.getId(), p.getName(), p.getPrice()));
            }
            this.products = productsDto;
            return this;
        };
        public ProductProviderResponseDto build() {
            return new ProductProviderResponseDto(id, name, products);
        }
    }
}
