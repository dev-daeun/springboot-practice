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

//mysql> show columns from product_detail;
//        +-------------+--------------+------+-----+---------+----------------+
//        | Field       | Type         | Null | Key | Default | Extra          |
//        +-------------+--------------+------+-----+---------+----------------+
//        | id          | bigint       | NO   | PRI | NULL    | auto_increment |
//        | created_at  | datetime(6)  | YES  |     | NULL    |                |
//        | updated_at  | datetime(6)  | YES  |     | NULL    |                |
//        | description | varchar(255) | YES  |     | NULL    |                |
//        | product_id  | bigint       | YES  | UNI | NULL    |                |
//        +-------------+--------------+------+-----+---------+----------------+
//        5 rows in set (0.03 sec)
//mysql> show index from product_detail;
//+----------------+------------+-----------------------------+--------------+-------------+-----------+-------------+----------+--------+------+------------+---------+---------------+---------+------------+
//| Table          | Non_unique | Key_name                    | Seq_in_index | Column_name | Collation | Cardinality | Sub_part | Packed | Null | Index_type | Comment | Index_comment | Visible | Expression |
//+----------------+------------+-----------------------------+--------------+-------------+-----------+-------------+----------+--------+------+------------+---------+---------------+---------+------------+
//| product_detail |          0 | PRIMARY                     |            1 | id          | A         |           0 |     NULL |   NULL |      | BTREE      |         |               | YES     | NULL       |
//| product_detail |          0 | UKn0poneags4pq2e3u2mlv7h29n |            1 | product_id  | A         |           0 |     NULL |   NULL | YES  | BTREE      |         |               | YES     | NULL       |
//+----------------+------------+-----------------------------+--------------+-------------+-----------+-------------+----------+--------+------+------------+---------+---------------+---------+------------+
