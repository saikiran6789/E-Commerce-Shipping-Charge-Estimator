package com.shipping.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import com.shipping.service.ShippingService;
import com.shipping.model.Warehouse;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ShippingController {

 private final ShippingService service;

 @GetMapping("/warehouse/nearest")
 public Warehouse nearest(@RequestParam Long sellerId){
  return service.getNearestWarehouse(sellerId);
 }

 @GetMapping("/shipping-charge")
 public double shipping(@RequestParam Long warehouseId,
                        @RequestParam Long customerId,
                        @RequestParam Long productId,
                        @RequestParam String deliverySpeed){
  return service.calculateShipping(warehouseId,customerId,productId,deliverySpeed);
 }

 @PostMapping("/shipping-charge/calculate")
 public Map<String,Object> calculate(@RequestBody Map<String,Object> req){
  Long sellerId=Long.valueOf(req.get("sellerId").toString());
  Long customerId=Long.valueOf(req.get("customerId").toString());
  Long productId=Long.valueOf(req.get("productId").toString());
  String speed=req.get("deliverySpeed").toString();

  Warehouse w=service.getNearestWarehouse(sellerId);
  double charge=service.calculateShipping(w.getId(),customerId,productId,speed);

  return Map.of("shippingCharge",charge,"nearestWarehouse",w);
 }
}