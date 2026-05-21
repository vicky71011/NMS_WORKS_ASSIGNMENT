# 🎓 Student Result Management System
### Spring Boot | REST API | JPA | Thymeleaf | MVC | MySQL

---

## 📋 Table of Contents

1. [Project Overview](#project-overview)
2. [Features](#features)
3. [Technologies Used](#technologies-used)
4. [Project Structure](#project-structure)
5. [Dependencies Explained](#dependencies-explained)
6. [System Architecture](#system-architecture)
7. [Setup and Run](#setup-and-run)
8. [REST API Reference](#rest-api-reference)
9. [Thymeleaf Annotations Explained](#thymeleaf-annotations-explained)
10. [Spring Boot Annotations Explained](#spring-boot-annotations-explained)
11. [Database Schema](#database-schema)
12. [How It Differs from J2EE Project](#how-it-differs-from-j2ee-project)
13. [Common Errors and Fixes](#common-errors-and-fixes)

---

# Project Overview

The **Student Result Management System** is a full-stack web application for managing student examination results.

It demonstrates:

- Spring Boot
- REST API Development
- Spring MVC
- Spring Data JPA
- Hibernate ORM
- Thymeleaf Templating
- MVC Architecture

The application allows users to:

- Add student results
- Update student results
- Delete records
- Filter by department
- View top performers
- Test REST APIs using Postman

---

# Features

| Feature | Description |
|---|---|
| Add Result | Add student marks and details |
| Auto Calculation | Percentage, Grade, Pass/Fail automatically calculated |
| View Results | Display all student results |
| Update Result | Edit student details and marks |
| Delete Result | Remove a student record |
| Filter by Department | View department-wise results |
| Top Performers | View students scoring ≥ 75 |
| REST API | Full CRUD APIs for Postman testing |

---

# Technologies Used

| Technology | Purpose |
|---|---|
| Java 17 | Programming language |
| Spring Boot | Main framework |
| Spring MVC | Web application layer |
| Spring Data JPA | Database access layer |
| Hibernate | ORM framework |
| Thymeleaf | Frontend template engine |
| MySQL | Database |
| Maven | Dependency management |
| HTML/CSS | Frontend UI |
| Bean Validation | Form validation |

---

# Project Structure

```text
student-result-system
│
├── pom.xml
├── README.md
├── student_result_db.sql
│
└── src/
    └── main/
        ├── java/
        │   └── com/studentresult/
        │       │
        │       ├── StudentResultSystemApplication.java
        │       │
        │       ├── model/
        │       │   └── Student.java
        │       │
        │       ├── repository/
        │       │   └── StudentRepository.java
        │       │
        │       ├── service/
        │       │   └── StudentService.java
        │       │
        │       └── controller/
        │           ├── StudentController.java
        │           └── StudentApiController.java
        │
        └── resources/
            ├── application.properties
            │
            ├── templates/
            │   ├── index.html
            │   ├── add-student.html
            │   └── update-student.html
            │
            └── static/
                └── css/
                    └── style.css
```

---

# Dependencies Explained

## 1. spring-boot-starter-web

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

### Purpose

Provides:

- Spring MVC
- Embedded Tomcat
- DispatcherServlet
- REST API support
- JSON conversion

Required for:

- `@Controller`
- `@RestController`
- `@GetMapping`
- `@PostMapping`

---

## 2. spring-boot-starter-data-jpa

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

### Purpose

Provides:

- Spring Data JPA
- Hibernate ORM
- EntityManager

Enables:

- `JpaRepository`
- Automatic table mapping
- CRUD operations without SQL

---

## 3. spring-boot-starter-thymeleaf

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

### Purpose

Used for:

- Dynamic HTML rendering
- Thymeleaf template processing
- Server-side rendering

Supports:

- `th:text`
- `th:href`
- `th:each`
- `th:if`

---

## 4. spring-boot-starter-validation

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```

### Purpose

Provides validation annotations:

- `@NotBlank`
- `@Min`
- `@Max`
- `@Size`

Used with:

```java
@Valid
```

---

## 5. mysql-connector-j

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
</dependency>
```

### Purpose

JDBC driver for MySQL database connection.

---

# System Architecture

```text
Browser / Postman
        │
        ▼
Controller Layer
        │
        ▼
Service Layer
        │
        ▼
Repository Layer
        │
        ▼
MySQL Database
```

---

# Setup and Run

## Step 1 — Install Requirements

Required:

- Java 17
- Maven
- MySQL
- IntelliJ IDEA

---

## Step 2 — Create Database

```sql
CREATE DATABASE student_result_db;
```

---

## Step 3 — Configure Database

Open:

```text
src/main/resources/application.properties
```

Update:

```properties
spring.datasource.username=root
spring.datasource.password=your_password
```

---

## Step 4 — Build Project

```bash
mvn clean package
```

---

## Step 5 — Run Project

```bash
mvn spring-boot:run
```

OR run:

```text
StudentResultSystemApplication.java
```

---

## Step 6 — Open Browser

```text
http://localhost:8080
```

---

# REST API Reference

## Base URL

```text
http://localhost:8080/api/students
```

---

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/students` | Get all students |
| GET | `/api/students/{id}` | Get student by ID |
| GET | `/api/students/department/{dept}` | Filter by department |
| GET | `/api/students/result/Pass` | Get passed students |
| GET | `/api/students/result/Fail` | Get failed students |
| GET | `/api/students/toppers` | Get top performers |
| GET | `/api/students/search?name=abc` | Search by name |
| POST | `/api/students` | Add student |
| PUT | `/api/students/{id}` | Update student |
| DELETE | `/api/students/{id}` | Delete student |

---

## Sample JSON Body

```json
{
  "studentName": "Neymar",
  "rollNumber": "EC2024001",
  "department": "ECE",
  "subject": "Digital Electronics",
  "marksObtained": 55,
  "totalMarks": 100
}
```

---

# Thymeleaf Annotations Explained

| Annotation | Purpose |
|---|---|
| `th:text` | Set text dynamically |
| `th:href` | Dynamic URL |
| `th:each` | Loop through list |
| `th:if` | Conditional rendering |
| `th:object` | Bind form object |
| `th:field` | Bind input field |
| `th:action` | Form submission URL |
| `${}` | Variable expression |
| `@{}` | URL expression |

---

# Spring Boot Annotations Explained

| Annotation | Purpose |
|---|---|
| `@SpringBootApplication` | Main Spring Boot configuration |
| `@Entity` | Maps class to database table |
| `@Table` | Specifies table name |
| `@Id` | Primary key |
| `@GeneratedValue` | Auto increment |
| `@Repository` | Database access layer |
| `@Service` | Business logic layer |
| `@Controller` | Returns HTML pages |
| `@RestController` | Returns JSON data |
| `@Autowired` | Dependency Injection |
| `@GetMapping` | Handle GET request |
| `@PostMapping` | Handle POST request |
| `@PutMapping` | Handle PUT request |
| `@DeleteMapping` | Handle DELETE request |
| `@PathVariable` | Read value from URL |
| `@RequestParam` | Read query parameter |
| `@RequestBody` | Read JSON body |
| `@Valid` | Trigger validation |

---

# Database Schema

```sql
CREATE TABLE student (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    student_name VARCHAR(100),
    roll_number VARCHAR(50),
    department VARCHAR(100),
    subject VARCHAR(100),
    marks_obtained INT,
    total_marks INT,
    percentage DOUBLE,
    grade VARCHAR(5),
    result VARCHAR(10)
);
```

---

# Grade Calculation Logic

| Percentage | Grade | Result |
|---|---|---|
| ≥ 90 | A+ | Pass |
| ≥ 80 | A | Pass |
| ≥ 70 | B | Pass |
| ≥ 60 | C | Pass |
| ≥ 40 | D | Pass |
| < 40 | F | Fail |

---

# How It Differs from J2EE Project

| J2EE | Spring Boot |
|---|---|
| JSP | Thymeleaf |
| Manual JDBC | JPA/Hibernate |
| External Tomcat | Embedded Tomcat |
| web.xml | application.properties |
| Manual Dependency Injection | `@Autowired` |
| WAR deployment | Executable JAR |
| More boilerplate | Less code |

---

# Common Errors and Fixes

| Error | Cause | Fix |
|---|---|---|
| Access denied for user | Wrong MySQL password | Update DB password |
| Unknown database | DB not created | Create database |
| Port 8080 already in use | Another app using port | Change server port |
| Template not found | Wrong HTML filename | Check templates folder |
| CSS not loading | Wrong static folder | Use `resources/static/css` |

---

# Frontend Pages

| URL | Description |
|---|---|
| `/` | Home page |
| `/add` | Add student form |
| `/edit/{id}` | Update form |
| `/department?name=CSE` | Department filter |
| `/toppers` | Top performers |

---

# Future Improvements

- Authentication/Login
- Pagination
- Swagger/OpenAPI
- PDF Export
- Excel Export
- Search Filters
- Dashboard Charts
- Docker Deployment

---

# Conclusion

The Student Result Management System demonstrates a complete modern Java web application using:

- Spring Boot
- REST APIs
- MVC Architecture
- JPA/Hibernate
- Thymeleaf
- MySQL

It is a good example of replacing traditional J2EE Servlet/JSP architecture with modern Spring Boot development.