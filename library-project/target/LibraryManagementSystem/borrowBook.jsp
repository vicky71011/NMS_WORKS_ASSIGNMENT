<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="dao.BookDAO, model.Book, java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Borrow a Book</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="topbar">
    <span>&#128218; Library Management System</span>
    <a href="dashboard.jsp" class="logout-link">&#8592; Dashboard</a>
</div>

<div class="page-wrap">
    <div class="form-container">
        <h2>&#128100; Borrow a Book</h2>

        <% if ("no_copies".equals(request.getParameter("error"))) { %>
        <p class="error-msg">&#10060; No copies available for that book. Choose another.</p>
        <% } else if ("1".equals(request.getParameter("error"))) { %>
        <p class="error-msg">&#10060; Failed to borrow. Please try again.</p>
        <% } %>

        <%
            BookDAO dao = new BookDAO();
            List<Book> books = dao.getAllBooks();
        %>

        <form action="BorrowServlet" method="post">

            <div class="form-group">
                <label>Select Book *</label>
                <select name="bookId" required>
                    <option value="">-- Choose a Book --</option>
                    <% for (Book b : books) { %>
                    <option value="<%= b.getBookId() %>"
                            <%= "Out of Stock".equals(b.getStatus()) ? "disabled" : "" %>>
                        <%= b.getTitle() %> by <%= b.getAuthor() %>
                        (<%= b.getAvailableCopies() %> available)
                    </option>
                    <% } %>
                </select>
            </div>

            <div class="form-group">
                <label>Student Name *</label>
                <input type="text" name="studentName"
                       placeholder="e.g. Pavithra K R" required>
            </div>

            <button type="submit" class="btn-primary">&#128100; Borrow Book</button>

        </form>
    </div>
</div>
</body>
</html>