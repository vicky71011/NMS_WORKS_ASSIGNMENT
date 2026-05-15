# Smart Hostel Management System

A web-based Smart Hostel Management System developed using Java Servlets, JSP, JDBC, MySQL, HTML, and CSS.  
The system helps manage hostel activities such as student login, complaint registration, visitor management, and approval workflows.

---

# Features

- Admin Login Authentication
- Student Complaint Registration
- Complaint Approval and Status Update
- Visitor Entry Management
- Visitor Approval System
- MySQL Database Integration
- MVC Architecture
- JSP Based User Interface
- JDBC Connectivity
- Apache Tomcat Deployment

---

# Technologies Used

| Technology | Purpose |
|---|---|
| Java | Backend Development |
| JSP | Frontend Pages |
| Servlets | Controller Layer |
| JDBC | Database Connectivity |
| MySQL | Database |
| HTML/CSS | UI Design |
| Apache Tomcat | Web Server |
| Maven | Dependency Management |

---

# Project Structure

```text
hostel-project/
│
├── src/
│   └── main/
│       ├── java/
│       │   ├── controller/
│       │   ├── dao/
│       │   └── model/
│       │
│       └── webapp/
│           ├── css/
│           ├── WEB-INF/
│           ├── index.jsp
│           ├── login.jsp
│           ├── dashboard.jsp
│           ├── complaint.jsp
│           ├── complaintApproval.jsp
│           ├── visitor.jsp
│           └── visitorApproval.jsp
│
├── hostel_db.sql
├── pom.xml
└── README.md
```

---

# Modules

## Login Module

- Admin authentication using email and password
- Session-based login handling
- Redirects user to dashboard after successful login

### Default Credentials

```text
Email: admin@gmail.com
Password: admin123
```

---

## Complaint Management

- Students can register complaints
- Complaints are stored in MySQL database
- Admin can approve or resolve complaints

---

## Visitor Management

- Students can register visitor details
- Visitor approval handled by admin
- Approval status updated in database

---

# Database Configuration

## Create Database

```sql
CREATE DATABASE hostel_db;
```

---

## Import SQL File

Execute:

```text
hostel_db.sql
```

inside MySQL Workbench or IntelliJ Database Tool.

---

# JDBC Configuration

Update database credentials inside:

```text
src/main/java/dao/DBConnection.java
```

```java
private static final String URL = "jdbc:mysql://localhost:3306/hostel_db";
private static final String USERNAME = "root";
private static final String PASSWORD = "your_password";
```

---

# Tomcat Configuration

This project uses Apache Tomcat 10.

## Steps

1. Download Tomcat 10
2. Configure Tomcat in IntelliJ IDEA
3. Add WAR exploded artifact
4. Run the server

---

# How to Run the Project

## Step 1

Clone the repository:

```bash
git clone https://github.com/vicky71011/NMS_INTERN.git
```

---

## Step 2

Open project in IntelliJ IDEA.

---

## Step 3

Configure MySQL database.

---

## Step 4

Execute:

```text
hostel_db.sql
```

---

## Step 5

Configure Tomcat 10 server.

---

## Step 6

Run the application.

---

# Application URL

```text
http://localhost:8080/SmartHostelSystem_war_exploded/login.jsp
```

---

# MVC Architecture

```text
JSP → Servlet → DAO → MySQL
```

| Layer | Components |
|---|---|
| View | JSP Pages |
| Controller | Servlets |
| Model | Java Classes |
| DAO | Database Operations |
| Database | MySQL |

---

# Functional Workflow

## Login Flow

```text
login.jsp
    ↓
LoginServlet
    ↓
dashboard.jsp
```

---

## Complaint Flow

```text
complaint.jsp
    ↓
ComplaintServlet
    ↓
ComplaintDAO
    ↓
MySQL Database
```

---

## Visitor Flow

```text
visitor.jsp
    ↓
VisitorServlet
    ↓
VisitorDAO
    ↓
MySQL Database
```

---

# Screenshots

## Login Page

Add screenshot inside:

```text
output/screenshots/
```

---

## Dashboard

Add screenshot inside:

```text
output/screenshots/
```

---

## Complaint Module

Add screenshot inside:

```text
output/screenshots/
```

---

# Future Enhancements

- Student Registration Module
- Role-Based Authentication
- Email Notifications
- QR-Based Visitor Verification
- REST API Integration
- Mobile Responsive Design
- Spring Boot Migration
- Admin Analytics Dashboard

---

# Author

**Vignesh S**

---

# License

This project is developed for educational and internship purposes.