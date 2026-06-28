<img width="1635" height="808" alt="Снимок экрана 2026-06-28 060647" src="https://github.com/user-attachments/assets/530797bf-4694-42c2-b673-8df4bf59421f" />A full-stack pet shop web application built with Java, Spring Boot, Spring Security, Spring Data JPA, Thymeleaf, and PostgreSQL.

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

- User Page
<img width="1600" height="794" alt="image" src="https://github.com/user-attachments/assets/82776aba-6217-47ef-91c6-30b0ca80ccf1" />

- Admin Page
<img width="1600" height="790" alt="image" src="https://github.com/user-attachments/assets/93f7133c-bf0f-4798-909e-45483e645905" />


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
