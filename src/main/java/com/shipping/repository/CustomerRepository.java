package com.shipping.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.shipping.model.Customer;
public interface CustomerRepository extends JpaRepository<Customer, Long>{}