package com.giri.springboottransactionconcept.service.impl;

import com.giri.springboottransactionconcept.dto.OrderRequest;
import com.giri.springboottransactionconcept.dto.OrderResponse;
import com.giri.springboottransactionconcept.entity.Order;
import com.giri.springboottransactionconcept.entity.Payment;
import com.giri.springboottransactionconcept.exception.PaymentException;
import com.giri.springboottransactionconcept.repository.OrderRepository;
import com.giri.springboottransactionconcept.repository.PaymentRepository;
import com.giri.springboottransactionconcept.service.OrderService;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository,PaymentRepository paymentRepository)
    {
        this.orderRepository=orderRepository;
        this.paymentRepository=paymentRepository;
    }
    @Override
    @Transactional
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Order order = orderRequest.getOrder();
        order.setStatus("INPROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();
        if (!payment.getType().equals("DEBIT"))
        {
            throw  new PaymentException("Payment card type do not support");
        }
        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse=new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");
        return orderResponse;
    }
}
