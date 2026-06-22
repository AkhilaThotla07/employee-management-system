# 🏢 Employee Management System

A RESTful backend application built with **Spring Boot** to manage departments and employees efficiently. This project demonstrates a clean layered architecture with full CRUD operations, MySQL integration, and industry-standard API design.

---

## 🚀 Getting Started

### Prerequisites
- Java 17+
- Maven 3.6+
- MySQL 8.0+
- Postman (optional, for API testing)


## ✅ Features

- **Department CRUD** — Create, read, update, and delete departments via REST APIs
- **Layered Architecture** — Clean separation of concerns across Controller, Service, DAO, and Repository layers
- **MySQL Integration** — Persistent data storage with Spring Data JPA and Hibernate
- **REST API Design** — Standard HTTP methods and status codes throughout

---

## 🏗️ Project Architecture

```
Client (Postman / Frontend)
        ↓
   Controller Layer       ← Handles HTTP requests & responses
        ↓
   Service Layer          ← Business logic
        ↓
   DAO Layer              ← Data access abstraction
        ↓
   Repository Layer       ← Spring Data JPA interfaces
        ↓
   MySQL Database
```

---

## 🛠️ Tech Stack

| Technology       | Purpose                        |
| ---------------- | ------------------------------ |
| Java             | Core programming language      |
| Spring Boot      | Application framework          |
| Spring Data JPA  | ORM and repository abstraction |
| Hibernate        | JPA implementation             |
| MySQL            | Relational database            |
| Maven            | Build and dependency management|

---

## 📡 API Endpoints

### Department APIs

| Method   | Endpoint            | Description             | Status |
| -------- | ------------------- | ----------------------- | ------ |
| `POST`   | `/departments`      | Create new department   | ✅ Done |
| `GET`    | `/departments`      | Fetch all departments   | ✅ Done |
| `GET`    | `/departments/{id}` | Fetch department by ID  | ✅ Done |
| `PUT`    | `/departments/{id}` | Update department       | ✅ Done |
| `DELETE` | `/departments/{id}` | Delete department       | ✅ Done |

---

## 📋 Sample Request & Response

### POST `/departments`

**Request Body**
```json
{
  "departmentName": "Development",
  "managerName": "Pavan Kumar",
  "location": "Hyderabad"
}
```

**Response `201 Created`**
```json
{
  "id": 1,
  "departmentName": "Development",
  "managerName": "Pavan Kumar",
  "location": "Hyderabad"
}
```

### GET `/departments/1`

**Response `200 OK`**
```json
{
  "id": 1,
  "departmentName": "Development",
  "managerName": "Pavan Kumar",
  "location": "Hyderabad"
}
```

### DELETE `/departments/1`

**Response `200 OK`**
```json
{
  "message": "Department deleted successfully"
}
```
---

## 💡 What I'm Learning

This project is helping me build hands-on experience with:
- REST API design principles
- Spring Boot project structure and auto-configuration
- JPA, Hibernate, and ORM concepts
- Entity relationships and database schema design
- Layered architecture for maintainability

---

## 👩‍💻 Author

**Akhila**  
[GitHub](https://github.com/AkhilaThotla07) • [LinkedIn](https://www.linkedin.com/in/akhila-thotla))
