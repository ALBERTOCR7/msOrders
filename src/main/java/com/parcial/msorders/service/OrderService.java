package com.parcial.msorders.service;

import com.parcial.msorders.model.Order;
import com.parcial.msorders.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public Order save(Order o) {
        return repository.save(o);
    }

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Optional<Order> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<Order> findByClient(String client) {
        return repository.findByClientContaining(client);
    }

    public List<Order> findByStatus(String status) {
        return repository.findByStatus(status);
    }
}
