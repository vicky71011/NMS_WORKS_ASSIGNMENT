<%-- visitor.jsp — VIEW: Add a visitor entry --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Visitor Entry</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">

    <h2>&#128100; Visitor Entry</h2>

    <% if ("1".equals(request.getParameter("error"))) { %>
        <p class="error-msg">&#10060; Failed to add visitor. Please try again.</p>
    <% } %>

    <form action="VisitorServlet" method="post">

        <input type="text"
               name="studentName"
               placeholder="Student Name"
               required>

        <input type="text"
               name="visitorName"
               placeholder="Visitor Name"
               required>

        <input type="text"
               name="visitTime"
               placeholder="Visit Time (e.g. 3:00 PM)"
               required>

        <button type="submit">Submit Visitor</button>

    </form>

    <br>
    <a href="dashboard.jsp">&#8592; Back to Dashboard</a>

</div>
</body>
</html>
