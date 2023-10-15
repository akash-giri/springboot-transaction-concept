package com.giri.springboottransactionconcept.dto;

import com.giri.springboottransactionconcept.entity.Order;
import com.giri.springboottransactionconcept.entity.Payment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private Order order;
    private Payment payment;
}
