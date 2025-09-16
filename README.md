# Employee Management System (EMS)

## 📌 Description
The **Employee Management System (EMS)** is a RESTful web service built with **Spring Boot**, **Spring Data JPA/Hibernate**, and a **PostgreSQL** database.  
It provides APIs to manage employee entities, supporting **CRUD operations** (Create, Read, Update, Delete) with fields such as **first name, last name, and email**.

This project demonstrates clean layered architecture using **Controller-Service-Repository pattern**, DTO mapping, and exception handling.  

---

## ✨ Features
- Add a new employee
- Retrieve an employee by ID
- List all employees
- Update employee details
- Delete employee records
- PostgreSQL persistence with Docker support
- DTO mapping for clean API responses

---

## 🚀 Tech Stack
- **Java 17+**
- **Spring Boot**
- **Spring Data JPA / Hibernate**
- **PostgreSQL (Dockerized)**
- **Lombok**
- **Maven**

---

## 🐳 Docker Setup
The database runs in a **Docker container**.

### Run PostgreSQL with Docker Compose:
```bash
docker-compose up -d
