**1. Khởi tạo Source Code Backend**

Cấu trúc thư mục:

backend/

│

├── src

│   └── main

│       ├── java/com/bluemoon

│       │

│       ├── config

│       │     └── DatabaseConfig.java

│       │

│       ├── model

│       │     └── BaseModel.java

│       │

│       └── BlueMoonApplication.java

│

└── resources

&#x20;   └── application.properties









**2. Cấu hình thư viện**

<dependencies>



&#x20;   <dependency>

&#x20;       <groupId>

&#x20;           org.springframework.boot

&#x20;       </groupId>



&#x20;       <artifactId>

&#x20;           spring-boot-starter-web

&#x20;       </artifactId>

&#x20;   </dependency>





&#x20;   <dependency>

&#x20;       <groupId>

&#x20;           org.springframework.boot

&#x20;       </groupId>



&#x20;       <artifactId>

&#x20;           spring-boot-starter-data-jpa

&#x20;       </artifactId>

&#x20;   </dependency>





&#x20;   <dependency>

&#x20;       <groupId>

&#x20;           com.mysql

&#x20;       </groupId>



&#x20;       <artifactId>

&#x20;           mysql-connector-j

&#x20;       </artifactId>

&#x20;   </dependency>





&#x20;   <dependency>

&#x20;       <groupId>

&#x20;           org.springframework.boot

&#x20;       </groupId>



&#x20;       <artifactId>

&#x20;           spring-boot-starter-validation

&#x20;       </artifactId>

&#x20;   </dependency>





&#x20;   <dependency>

&#x20;       <groupId>

&#x20;           org.projectlombok

&#x20;       </groupId>



&#x20;       <artifactId>

&#x20;           lombok

&#x20;       </artifactId>

&#x20;   </dependency>



</dependencies>

&#x20; 









**3. Thiết lập kết nối JDBC tới MySQL**

Tạo database:

CREATE DATABASE bluemoon;

File:

application.properties

spring.datasource.url=

jdbc:mysql://localhost:3306/bluemoon

?serverTimezone=Asia/Ho\_Chi\_Minh

\&characterEncoding=UTF-8





spring.datasource.username=root



spring.datasource.password=123456





spring.datasource.driver-class-name=

com.mysql.cj.jdbc.Driver





spring.jpa.hibernate.ddl-auto=update





spring.jpa.show-sql=true





spring.jpa.properties.hibernate.format\_sql=true





spring.jpa.open-in-view=false





server.port=8080









**4. Cấu hình kết nối**

File:

config/DatabaseConfig.java



package com.bluemoon.config;



import org.springframework.context.annotation.Configuration;







@Configuration

public class DatabaseConfig {



} 





**5. Xây dựng Base Model**

File:

model/BaseModel.java

package com.bluemoon.model;



import jakarta.persistence.\*;



import lombok.Getter;



import lombok.Setter;



import java.time.LocalDateTime;





@Getter

@Setter



@MappedSuperclass



public abstract class BaseModel {





&#x20;   @Id



&#x20;   @GeneratedValue(

&#x20;           strategy =

&#x20;           GenerationType.IDENTITY

&#x20;   )



&#x20;   private Long id;





&#x20;   @Column(

&#x20;           updatable = false

&#x20;   )



&#x20;   private LocalDateTime createdAt;





&#x20;   private LocalDateTime updatedAt;





&#x20;   @PrePersist

&#x20;   protected void prePersist() {



&#x20;       createdAt =

&#x20;               LocalDateTime.now();



&#x20;       updatedAt =

&#x20;               LocalDateTime.now();



&#x20;   }





&#x20;   @PreUpdate

&#x20;   protected void preUpdate() {



&#x20;       updatedAt =

&#x20;               LocalDateTime.now();



&#x20;   }



}   









**6. Ví dụ sử dụng BaseModel**

@Entity



@Getter

@Setter



public class HoGiaDinh

&#x20;       extends BaseModel {



&#x20;   private String chuHo;



&#x20;   private String canHo;



&#x20;   private Double dienTich;



}



