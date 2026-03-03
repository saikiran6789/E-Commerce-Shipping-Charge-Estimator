package com.shipping.model;
import jakarta.persistence.*;
import lombok.Data;
@Entity @Data
public class Product {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
 private Long id;
 private String name;
 private double price;
 private double weightKg;
 private double lengthCm;
 private double widthCm;
 private double heightCm;
 @ManyToOne
 private Seller seller;
}