<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Book</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="topbar">
    <span>&#128218; Library Management System</span>
    <a href="dashboard.jsp" class="logout-link">&#8592; Dashboard</a>
</div>

<div class="page-wrap">
    <div class="form-container">
        <h2>&#10133; Add New Book</h2>

        <% if ("1".equals(request.getParameter("error"))) { %>
        <p class="error-msg">&#10060; Failed to add book. Please try again.</p>
        <% } %>

        <form action="AddBookServlet" method="post">

            <div class="form-group">
                <label>Book Title *</label>
                <input type="text" name="title"
                       placeholder="e.g. The Alchemist" required>
            </div>

            <div class="form-group">
                <label>Author *</label>
                <input type="text" name="author"
                       placeholder="e.g. Paulo Coelho" required>
            </div>

            <div class="form-group">
                <label>Genre *</label>
                <select name="genre" required>
                    <option value="">-- Select Genre --</option>
                    <option value="Fiction">Fiction</option>
                    <option value="Non-Fiction">Non-Fiction</option>
                    <option value="Science">Science</option>
                    <option value="Technology">Technology</option>
                    <option value="History">History</option>
                    <option value="Biography">Biography</option>
                    <option value="Self-Help">Self-Help</option>
                    <option value="Mathematics">Mathematics</option>
                </select>
            </div>

            <div class="form-group">
                <label>Total Copies *</label>
                <input type="number" name="totalCopies"
                       min="1" max="100" value="1" required>
            </div>

            <button type="submit" class="btn-primary">&#10133; Add Book</button>

        </form>
    </div>
</div>
</body>
</html>