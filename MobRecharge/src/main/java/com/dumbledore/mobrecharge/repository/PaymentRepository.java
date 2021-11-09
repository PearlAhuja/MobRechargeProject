package com.dumbledore.mobrecharge.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dumbledore.mobrecharge.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment ,Integer> {

}
