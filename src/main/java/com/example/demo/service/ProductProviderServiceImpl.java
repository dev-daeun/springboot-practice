package com.example.demo.service;

import com.example.demo.dto.ProductProviderResponseDto;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductProvider;
import com.example.demo.repository.ProductProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
class ProductProviderServiceImpl implements ProductProviderService {
    private final ProductProviderRepository productProviderRepository;

    @Autowired
    public ProductProviderServiceImpl(ProductProviderRepository productProviderRepository) {
        this.productProviderRepository = productProviderRepository;
    }

    public ProductProviderResponseDto getProductProviderById(Long id) {
        Optional<ProductProvider> provider = productProviderRepository.findById(id);
//        ::: <FetchType.EAGER> :::
//        Hibernate:
//        select
//        pp1_0.id,
//                pp1_0.created_at,
//                pp1_0.name,
//                pp1_0.updated_at,
//                pl1_0.product_provider_id,
//                pl1_0.id,
//                pl1_0.created_at,
//                pl1_0.name,
//                pl1_0.price,
//                pl1_0.updated_at
//        from
//        product_provider pp1_0
//        left join
//        product pl1_0
//        on pp1_0.id=pl1_0.product_provider_id
//        where
//        pp1_0.id=?

//       ::: <FetchType.LAZY> :::
//        Hibernate:
//        select
//        pp1_0.id,
//                pp1_0.created_at,
//                pp1_0.name,
//                pp1_0.updated_at
//        from
//        product_provider pp1_0
//        where
//        pp1_0.id=?
//        Hibernate:
//        select
//        pl1_0.product_provider_id,
//                pl1_0.id,
//                pl1_0.created_at,
//                pl1_0.name,
//                pl1_0.price,
//                pl1_0.updated_at
//        from
//        product pl1_0
//        where
//        pl1_0.product_provider_id=?

        List<Product> products = provider.get().getProductList();
        ProductProviderResponseDto.ProductProviderResponseDtoBuilder builder = new ProductProviderResponseDto.ProductProviderResponseDtoBuilder();
        return builder.id(provider.get().getId()).name(provider.get().getName()).products(products).build();
    }
}
