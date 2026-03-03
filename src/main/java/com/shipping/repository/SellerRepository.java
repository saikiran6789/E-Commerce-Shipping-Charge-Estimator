package com.shipping.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.shipping.model.Seller;
public interface SellerRepository extends JpaRepository<Seller, Long>{}