A full-stack pet shop web application built with Java, Spring Boot, Spring Security, Spring Data JPA, Thymeleaf, and PostgreSQL.

The project demonstrates authentication, authorization, product management, purchasing, balance operations, and an admin panel using a layered Spring Boot architecture.

## Features

## User
- User registration and authentication
- Secure password hashing with Spring Security
- Login and logout functionality
- Personal balance management
- Purchase pets and products
- Purchase history
- Responsive web interface using Thymeleaf
## Administrator
- Add new products
- Edit existing products
- Delete products
- Upload product images
- Manage store inventory

## Tech Stack

- Java 17
- Spring Boot
- Spring MVC
- Spring Security
- Spring Data JPA
- Hibernate
- PostgreSQL
- Thymeleaf
- Maven
- HTML
- CSS
- Bootstrap

## Screenshots

- Login Page
<img width="1600" height="860" alt="image" src="https://github.com/user-attachments/assets/57779d9d-541d-4f9e-a36b-868cbb9d8157" />

- Register Page
<img width="1600" height="860" alt="image" src="https://github.com/user-attachments/assets/c6099bf3-2d36-4e58-9040-c91ef443d36e" />

- Main Dashboard
<img width="1600" height="854" alt="image" src="https://github.com/user-attachments/assets/cb1f30be-be1f-4c66-9869-ed435e2a0c17" />

- Money Transfer
<img width="1600" height="856" alt="image" src="https://github.com/user-attachments/assets/5081bb79-be6a-4846-b010-dfbc42ea5506" />

- Transaction History
<img width="1600" height="867" alt="image" src="https://github.com/user-attachments/assets/d36f9768-ea81-4e00-8d4a-9a7585afa4e6" />

- Search user Page
<img width="1600" height="856" alt="image" src="https://github.com/user-attachments/assets/d88b4a5f-0062-48bd-9a02-3d8c2173fb26" />

- Chat page
<img width="1600" height="860" alt="image" src="https://github.com/user-attachments/assets/30072fef-57d8-436f-b625-f1e218951487" />




## Project Structure

```text
src
├── controller
├── service
├── repository
├── model
├── config
├── templates
├── static
└── resources
```

## Installation

Clone the repository

git clone https://github.com/JustAdik/petshop.git

Go to the project directory

cd petshop

Configure PostgreSQL in

application.properties

Run

mvn spring-boot:run

Open

http://localhost:8080
```
