<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hostel Login</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">

    <h2>&#127968; Hostel Login</h2>

    <% if ("1".equals(request.getParameter("error"))) { %>
        <p class="error-msg">&#10060; Invalid email or password. Try again.</p>
    <% } %>

    <form action="LoginServlet" method="post">

        <input type="email"
               name="email"
               placeholder="Enter Email..."
               required>

        <input type="password"
               name="password"
               placeholder="Enter Password..."
               required>

        <button type="submit">Login</button>

    </form>

</div>
</body>
</html>
