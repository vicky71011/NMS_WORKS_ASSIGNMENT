<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="dao.BookDAO, model.Book, java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>All Books</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="topbar">
    <span>&#128218; Library Management System</span>
    <a href="dashboard.jsp" class="logout-link">&#8592; Dashboard</a>
</div>

<div class="page-wrap">
    <h2>&#128196; All Books</h2>

    <% if ("book_deleted".equals(request.getParameter("msg"))) { %>
    <p class="success-msg">&#10003; Book deleted successfully.</p>
    <% } %>

    <%
        BookDAO dao = new BookDAO();
        List<Book> books = dao.getAllBooks();
    %>

    <div class="table-actions">
        <a href="addBook.jsp"><button class="btn-sm btn-blue">&#10133; Add Book</button></a>
    </div>

    <table>
        <thead>
        <tr>
            <th>#</th>
            <th>Title</th>
            <th>Author</th>
            <th>Genre</th>
            <th>Total</th>
            <th>Available</th>
            <th>Status</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <% for (Book b : books) { %>
        <tr>
            <td><%= b.getBookId() %></td>
            <td><strong><%= b.getTitle() %></strong></td>
            <td><%= b.getAuthor() %></td>
            <td><span class="genre-tag"><%= b.getGenre() %></span></td>
            <td><%= b.getTotalCopies() %></td>
            <td><%= b.getAvailableCopies() %></td>
            <td>
                    <span class="<%= "Available".equals(b.getStatus()) ? "badge-green" : "badge-red" %>">
                        <%= b.getStatus() %>
                    </span>
            </td>
            <td>
                <a href="DeleteBookServlet?bookId=<%= b.getBookId() %>"
                   onclick="return confirm('Delete this book?')">
                    <button class="btn-sm btn-red">&#128465; Delete</button>
                </a>
            </td>
        </tr>
        <% } %>

        <% if (books.isEmpty()) { %>
        <tr><td colspan="8" class="empty-row">No books in the library yet. Add one!</td></tr>
        <% } %>
        </tbody>
    </table>
</div>
</body>
</html>