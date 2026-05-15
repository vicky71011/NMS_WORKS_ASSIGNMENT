# Library Management System

A simple Java web-based Library Management System built using Servlets, JSP, JDBC, and MySQL.  
This project allows a librarian to manage books, borrow books, return books, and view borrowing records.

## Features

- Librarian login
- Add new books
- View all books
- Delete books
- Borrow books
- Return books
- View borrow history
- Live dashboard statistics

## Tech Stack

- Java 17
- Jakarta Servlet API 6.0
- JSP
- JSTL
- JDBC
- MySQL
- Maven
- Apache Tomcat

## Project Structure

- `controller/` → Servlets
- `dao/` → Database access classes
- `model/` → POJO model classes
- `src/main/webapp/` → JSP pages, CSS, and web resources
- `pom.xml` → Maven dependencies
- `library_db.sql` → Database schema and sample data

## Main Files

### Controllers
- `AddBookServlet.java`
- `BorrowServlet.java`
- `DeleteBookServlet.java`
- `LoginServlet.java`
- `ReturnServlet.java`

### DAO Layer
- `DBConnection.java`
- `BookDAO.java`
- `BorrowDAO.java`

### Model Classes
- `Book.java`
- `BorrowRecord.java`

## Database Setup

1. Open MySQL.
2. Create the database using the SQL file:
   ```sql
   source library_db.sql;
   ```
   Or copy and run the contents of `library_db.sql`.

3. The SQL file creates:
    - `books` table
    - `borrow_records` table
    - sample records

## Database Configuration

Check `DBConnection.java`:

```java
private static final String URL = "jdbc:mysql://localhost:3306/library_db?useSSL=false&serverTimezone=UTC";
private static final String USERNAME = "root";
private static final String PASSWORD = "root123";
```

Update:
- `USERNAME` if your MySQL username is different
- `PASSWORD` if your MySQL password is different
- `URL` if your DB name, host, or port is different

## Maven Dependencies

The project uses:
- `jakarta.servlet-api`
- `jakarta.servlet.jsp-api`
- `jakarta.servlet.jsp.jstl-api`
- `jakarta.servlet.jsp.jstl`
- `mysql-connector-j`

Packaging type is `war`, so deploy it on a servlet container like Apache Tomcat.

## How to Run

1. Import the project into IntelliJ IDEA or Eclipse as a Maven project.
2. Make sure Apache Tomcat is configured.
3. Make sure MySQL is running.
4. Execute `library_db.sql`.
5. Update DB credentials in `DBConnection.java` if required.
6. Build and run the project on Tomcat.
7. Open the application in your browser.

## Default Login

```text
Email: librarian@gmail.com
Password: lib123
```

## Application Flow

- `login.jsp` → login
- `dashboard.jsp` → main dashboard
- `addBook.jsp` → add books
- `viewBooks.jsp` → view all books
- `borrowBook.jsp` → borrow a book
- `borrowRecords.jsp` → view records and return books

## Notes

- New books are added with status `Available`
- Borrowing reduces available copies
- Returning increases available copies
- If available copies become 0, status changes to `Out of Stock`

## Future Improvements

- Store librarian credentials in database
- Add logout session invalidation
- Add edit/update book feature
- Use proper date type instead of `VARCHAR`
- Add form validation and search feature
- Restrict unauthorized access using session checks

## Author

Vignesh S