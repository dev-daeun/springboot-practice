package com.example.demo.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class ProductResponseDto {
    @NonNull private Long id;
    @NonNull private String name;
    @NonNull private int price;

    public static ProductResponseDtoBuilder builder() {
        return new ProductResponseDtoBuilder();
    }

    @NoArgsConstructor
    public static class ProductResponseDtoBuilder {
        private Long id;
        private String name;
        private int price;

        public ProductResponseDtoBuilder id(Long id) {
            this.id = id;
            return this;
        };
        public ProductResponseDtoBuilder name(String name) {
            this.name = name;
            return this;
        };
        public ProductResponseDtoBuilder price(int price) {
            this.price = price;
            return this;
        };
        public ProductResponseDto build() {
            return new ProductResponseDto(id, name, price);
        }
    }
}
