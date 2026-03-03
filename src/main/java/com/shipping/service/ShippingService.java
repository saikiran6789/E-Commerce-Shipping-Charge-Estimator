package com.shipping.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.shipping.repository.*;
import com.shipping.model.*;
import com.shipping.util.DistanceUtil;

@Service
@RequiredArgsConstructor
public class ShippingService {

 private final SellerRepository sellerRepo;
 private final WarehouseRepository warehouseRepo;
 private final CustomerRepository customerRepo;
 private final ProductRepository productRepo;

 public Warehouse getNearestWarehouse(Long sellerId){
  Seller seller=sellerRepo.findById(sellerId)
   .orElseThrow(()->new RuntimeException("Seller not found"));
  return warehouseRepo.findAll().stream()
   .min((w1,w2)->Double.compare(
    DistanceUtil.calculateDistance(seller.getLatitude(),seller.getLongitude(),w1.getLatitude(),w1.getLongitude()),
    DistanceUtil.calculateDistance(seller.getLatitude(),seller.getLongitude(),w2.getLatitude(),w2.getLongitude())
   )).orElseThrow(()->new RuntimeException("No warehouse found"));
 }

 public double calculateShipping(Long warehouseId,Long customerId,Long productId,String speed){
  Warehouse w=warehouseRepo.findById(warehouseId)
   .orElseThrow(()->new RuntimeException("Warehouse not found"));
  Customer c=customerRepo.findById(customerId)
   .orElseThrow(()->new RuntimeException("Customer not found"));
  Product p=productRepo.findById(productId)
   .orElseThrow(()->new RuntimeException("Product not found"));

  double distance=DistanceUtil.calculateDistance(
   w.getLatitude(),w.getLongitude(),c.getLatitude(),c.getLongitude());

  double rate=distance<=100?3:distance<=500?2:1;
  double charge=distance*rate*p.getWeightKg()+10;
  if("express".equalsIgnoreCase(speed))
   charge+=1.2*p.getWeightKg();
  return charge;
 }
}