package com.shipping.model;
import jakarta.persistence.*;
import lombok.Data;
@Entity @Data
public class Seller {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
 private Long id;
 private String name;
 private double latitude;
 private double longitude;
}