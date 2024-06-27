package com.example.demo.entity.mappingPractice;

import com.example.demo.entity.BaseEntity;
import com.example.demo.entity.Product;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product_detail")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ProductDetail extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    // JoinColumn 컬럼 선언하지 않으면 자동으로 매핑테이블 새로 만들기 때문에 선언해줘야 한다.
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
