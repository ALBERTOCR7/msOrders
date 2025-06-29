package com.parcial.msorders.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductClient {

    private final RestTemplate restTemplate;

    public ProductClient() {
        this.restTemplate = new RestTemplate();
    }

    @CircuitBreaker(name = "productService", fallbackMethod = "fallbackStock")
    public Integer getProductStock(Long productId) {
        String url = "http://localhost:8081/products/" + productId;
        ProductResponse response = restTemplate.getForObject(url, ProductResponse.class);
        return response != null ? response.getStock() : -1;
    }

    public Integer fallbackStock(Long productId, Throwable t) {
        System.out.println("FALLBACK ejecutado: " + t.getMessage());
        return -1; // Stock desconocido
    }
}
