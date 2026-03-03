# E-Commerce Shipping Charge Estimator

This project is a Spring Boot application that calculates shipping charges for a B2B e-commerce marketplace serving Kirana stores.

It implements APIs to:

1. Find the nearest warehouse for a seller
2. Calculate shipping charges from warehouse to customer
3. Calculate total shipping charges combining nearest warehouse logic

---

## 🛠 Tech Stack

- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 In-Memory Database
- Maven

---

## 🏗 Architecture

Controller → Service → Repository → Database

- Controller: Handles API requests
- Service: Business logic (distance, shipping calculation)
- Repository: Database interaction using JPA
- Util: Haversine distance calculation

---

## 📦 Entities

- Customer
- Seller
- Product
- Warehouse

Sample data is automatically loaded using `DataLoader`.

---

## 🚀 How to Run

1. Clone the repository
2. Import as **Maven Project** in Eclipse/IntelliJ
3. Run:
