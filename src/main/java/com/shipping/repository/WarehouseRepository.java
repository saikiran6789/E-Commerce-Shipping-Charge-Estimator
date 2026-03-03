package com.shipping.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.shipping.model.Warehouse;
public interface WarehouseRepository extends JpaRepository<Warehouse, Long>{}