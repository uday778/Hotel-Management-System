# 🏨 Hotel Management System

The **HotelManagementSystem** is a Spring Boot project designed to manage hotels and perform CRUD operations.  
It is supported by a **HotelRating microservice**, which provides actual hotel ratings by integrating with the main service.  

---

## 🚀 Tech Stack
- **Language:** Java  
- **Framework:** Spring Boot, Spring MVC  
- **Database:** MySQL (with JPA / Hibernate ORM)  
- **Build Tool:** Maven  
- **Other Tools:** Lombok, Spring Boot DevTools  

---

## 📌 Modules

### 1. Hotel Management Service
- Perform CRUD operations on Hotels.  
- Manage hotel information such as name, address, and type.  

### 2. Hotel Rating Service (Microservice)
- Provides **actual ratings** for hotels.  
- Communicates with the main service via REST.  

---
## PostMan Collection
```
https://postman-8786.postman.co/workspace/Postman-API-Fundamentals-Studen~271585b5-c7fa-4173-b50a-451465be1169/request/31841449-f7a0de98-787c-4f4d-ae63-487f443424b9?action=share&creator=31841449&ctx=documentation
```

## ⚙️ Setup Instructions

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/uday778/Hotel-Management-System.git
cd Hotel-Management-System
```
### 2️⃣ Configure Database in ``` application.yml ```
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/your-database-name
    username: root
    password: your-password
    driver-class-name: com.mysql.cj.jdbc.Driver

  jpa:
    database-platform: org.hibernate.dialect.MySQL8Dialect
    hibernate:
      ddl-auto: update
    show-sql: true
```
3️⃣  Dependencies ``` pom.xml ```
```
<dependencies>
    <!-- Spring Boot Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Spring Data JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <!-- MySQL Driver -->
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <scope>runtime</scope>
    </dependency>

    <!-- Lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>

    <!-- DevTools -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
        <optional>true</optional>
    </dependency>

    <!-- Testing -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```
### 4️⃣ Run the Application
``` 
mvn spring-boot:run
```
## 📖 API Endpoints 

- **POST** /createhotel → Add new hotel

- **GET** /getallhotels → Get all hotels

- **GET** /gethotel/{id}} → Get hotel by ID

- **PUT** /updatehotel/{id} → Update hotel by Id

- **DELETE** /deletehotel/{id} → Delete hotel

### Hotel Rating (Microservice)

- **GET** /rating/getratingbyhotelid/{hotelid} → Get rating for a hotel

- **POST** /rating/addrating → Add a rating
