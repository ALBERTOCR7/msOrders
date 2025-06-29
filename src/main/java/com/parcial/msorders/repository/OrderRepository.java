package com.parcial.msorders.repository;

import com.parcial.msorders.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByClientContaining(String client);

    List<Order> findByStatus(String status);
}
