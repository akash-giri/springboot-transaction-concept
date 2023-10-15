package com.giri.springboottransactionconcept.repository;

import com.giri.springboottransactionconcept.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {

}
