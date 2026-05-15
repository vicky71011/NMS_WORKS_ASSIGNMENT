<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Library Login</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
    <div class="logo">&#128218;</div>
    <h2>Library Management System</h2>
    <p class="subtitle">Librarian Login</p>

    <% if ("1".equals(request.getParameter("error"))) { %>
    <p class="error-msg">&#10060; Invalid credentials. Please try again.</p>
    <% } %>

    <form action="LoginServlet" method="post">
        <div class="form-group">
            <label>Email</label>
            <input type="email" name="email"
                   placeholder="librarian@gmail.com" required>
        </div>
        <div class="form-group">
            <label>Password</label>
            <input type="password" name="password"
                   placeholder="lib123" required>
        </div>
        <button type="submit" class="btn-primary">Login</button>
    </form>

    <p class="hint">Credentials: [librarian@gmail.com](mailto:librarian@gmail.com) / lib123</p>
</div>
</body>
</html>