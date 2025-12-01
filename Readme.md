# Distributed Task Management System

A **microservices-based Task Management system** built using **Spring Boot**, demonstrating **JWT-based authentication, role–permission-based authorization, service discovery, event-driven communication, and caching**.

This project focuses on **distributed system concepts and backend architecture**, while keeping business logic intentionally simple (User & Task CRUD).

---

## 🚀 Tech Stack

- **Backend**: Java, Spring Boot
- **Security**: Spring Security, JWT (stateless authentication)
- **Database**: PostgreSQL
- **Messaging**: Apache Kafka
- **Caching**: Redis
- **Service Discovery**: Netflix Eureka
- **ORM**: Hibernate (JPA)

---

## 🏗️ High-Level Architecture

- **User Service**
    - Manages users, roles, and permissions
    - Generates JWT tokens on user creation/login
    - Publishes `USER_UPDATED` events to Kafka

- **Task Service**
    - Handles task CRUD operations
    - Uses Redis to cache user-related data
    - Listens to Kafka events and updates cache asynchronously

- **Eureka Server**
    - Provides service registry and discovery for microservices

---

## 🔐 Authentication & Authorization

- **JWT-based stateless authentication**
- Tokens are issued on **user creation**
- Authorization is **permission-based**, not role-based at runtime

