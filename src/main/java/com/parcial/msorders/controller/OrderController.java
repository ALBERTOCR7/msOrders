package com.parcial.msorders.controller;

import com.parcial.msorders.client.ProductClient;
import com.parcial.msorders.model.Order;
import com.parcial.msorders.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;
    private final ProductClient productClient;

    public OrderController(OrderService service, ProductClient productClient) {
        this.service = service;
        this.productClient = productClient;
    }

    // Crear nueva orden
    @PostMapping
    public ResponseEntity<Order> save(@Valid @RequestBody Order o) {
        return ResponseEntity.ok(service.save(o));
    }

    // Obtener todas las órdenes
    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Buscar orden por ID
    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar orden por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Buscar órdenes por nombre de cliente
    @GetMapping("/client")
    public ResponseEntity<List<Order>> byClient(@RequestParam String name) {
        return ResponseEntity.ok(service.findByClient(name));
    }

    // Buscar órdenes por estado
    @GetMapping("/status")
    public ResponseEntity<List<Order>> byStatus(@RequestParam String status) {
        return ResponseEntity.ok(service.findByStatus(status));
    }

    // Consultar stock desde el microservicio de productos con fallback incluido
    @GetMapping("/stock-check/{productId}")
    public ResponseEntity<String> checkProductStock(@PathVariable Long productId) {
        Integer stock = productClient.getProductStock(productId);
        return ResponseEntity.ok("Stock recibido: " + stock);
    }
}
