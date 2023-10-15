package com.giri.springboottransactionconcept.controller;

import com.giri.springboottransactionconcept.dto.OrderRequest;
import com.giri.springboottransactionconcept.dto.OrderResponse;
import com.giri.springboottransactionconcept.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService)
    {
        this.orderService=orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> placeOrder(OrderRequest orderRequest)
    {
        return ResponseEntity.ok(orderService.placeOrder(orderRequest));
    }

}
