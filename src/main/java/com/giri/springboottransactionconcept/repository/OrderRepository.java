package com.giri.springboottransactionconcept.repository;

import com.giri.springboottransactionconcept.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
