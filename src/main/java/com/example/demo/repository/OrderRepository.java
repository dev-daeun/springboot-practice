package com.example.demo.repository;

import com.example.demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


// Jpa 리퍼지토리를 상속받으려면 대상엔티티와 엔티티의 PK 타입을 명시해야 한다.
public interface OrderRepository extends JpaRepository<Order, Long> {

    public Order findByOrderNumber(String orderNumber);

    public List<Order> findByDeliveryVendor(String deliveryVendor);

    public List<Order> findByZoneIdOrderByIdDesc(int zoneId);

}
