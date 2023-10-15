package com.giri.springboottransactionconcept.service;

import com.giri.springboottransactionconcept.dto.OrderRequest;
import com.giri.springboottransactionconcept.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);
}
