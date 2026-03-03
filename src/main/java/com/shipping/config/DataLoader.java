package com.shipping.config;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.shipping.repository.*;
import com.shipping.model.*;

@Component
@RequiredArgsConstructor
public class DataLoader {

 private final CustomerRepository customerRepo;
 private final SellerRepository sellerRepo;
 private final ProductRepository productRepo;
 private final WarehouseRepository warehouseRepo;

 @PostConstruct
 public void load(){
  Customer c=new Customer();
  c.setName("Shree Kirana");
  c.setPhone("9999999999");
  c.setLatitude(13.08);
  c.setLongitude(77.60);
  customerRepo.save(c);

  Seller s=new Seller();
  s.setName("Nestle Seller");
  s.setLatitude(12.99);
  s.setLongitude(77.59);
  sellerRepo.save(s);

  Product p=new Product();
  p.setName("Maggie 500g");
  p.setPrice(10);
  p.setWeightKg(0.5);
  p.setLengthCm(10);
  p.setWidthCm(10);
  p.setHeightCm(10);
  p.setSeller(s);
  productRepo.save(p);

  Warehouse w1=new Warehouse();
  w1.setName("BLR Warehouse");
  w1.setLatitude(12.95);
  w1.setLongitude(77.55);
  warehouseRepo.save(w1);

  Warehouse w2=new Warehouse();
  w2.setName("MUMB Warehouse");
  w2.setLatitude(19.07);
  w2.setLongitude(72.87);
  warehouseRepo.save(w2);
 }
}