<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="dao.BookDAO, dao.BorrowDAO, model.Book, java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Dashboard — Library</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="topbar">
    <span>&#128218; Library Management System</span>
    <a href="login.jsp" class="logout-link">Logout</a>
</div>

<div class="page-wrap">

    <h2>&#127968; Dashboard</h2>

    <% String msg = request.getParameter("msg");
        if ("book_added".equals(msg)) { %>
    <p class="success-msg">&#10003; Book added successfully!</p>
    <% } else if ("borrow_success".equals(msg)) { %>
    <p class="success-msg">&#10003; Book borrowed successfully!</p>
    <% } %>

    <%
        BookDAO bkDao = new BookDAO();
        List<Book> allBooks = bkDao.getAllBooks();

        int totalBooks = allBooks.size();
        int availableBooks = 0;
        int outOfStock = 0;
        for (Book b : allBooks) {
            if ("Available".equals(b.getStatus())) availableBooks++;
            else outOfStock++;
        }

        BorrowDAO brDao = new BorrowDAO();
        int activeBorrows = brDao.getActiveRecords().size();
    %>

    <div class="stats-grid">
        <div class="stat-card">
            <div class="stat-icon">&#128218;</div>
            <div class="stat-num"><%= totalBooks %></div>
            <div class="stat-label">Total Books</div>
        </div>
        <div class="stat-card">
            <div class="stat-icon">&#9989;</div>
            <div class="stat-num"><%= availableBooks %></div>
            <div class="stat-label">Available</div>
        </div>
        <div class="stat-card">
            <div class="stat-icon">&#128203;</div>
            <div class="stat-num"><%= activeBorrows %></div>
            <div class="stat-label">Currently Borrowed</div>
        </div>
        <div class="stat-card">
            <div class="stat-icon">&#128683;</div>
            <div class="stat-num"><%= outOfStock %></div>
            <div class="stat-label">Out of Stock</div>
        </div>
    </div>

    <h3 style="margin: 28px 0 14px;">Quick Actions</h3>
    <div class="action-grid">
        <a href="addBook.jsp">
            <div class="action-card blue">
                <div class="action-icon">&#10133;</div>
                <div>Add New Book</div>
            </div>
        </a>
        <a href="viewBooks.jsp">
            <div class="action-card green">
                <div class="action-icon">&#128196;</div>
                <div>View All Books</div>
            </div>
        </a>
        <a href="borrowBook.jsp">
            <div class="action-card orange">
                <div class="action-icon">&#128100;</div>
                <div>Borrow a Book</div>
            </div>
        </a>
        <a href="borrowRecords.jsp">
            <div class="action-card purple">
                <div class="action-icon">&#128203;</div>
                <div>Borrow Records</div>
            </div>
        </a>
    </div>

</div>
</body>
</html>