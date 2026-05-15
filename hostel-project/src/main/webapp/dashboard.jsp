<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">

    <h2>&#127968; Student Dashboard</h2>

    <% String msg = request.getParameter("msg");
       if ("complaint_success".equals(msg)) { %>
        <p class="success-msg">&#10003; Complaint submitted successfully!</p>
    <% } else if ("visitor_success".equals(msg)) { %>
        <p class="success-msg">&#10003; Visitor entry added successfully!</p>
    <% } %>

    <div class="btn-group">

        <a href="complaint.jsp">
            <button class="btn-blue">&#128196; Raise Complaint</button>
        </a>

        <a href="visitor.jsp">
            <button class="btn-green">&#128100; Add Visitor</button>
        </a>

        <a href="complaintApproval.jsp">
            <button class="btn-orange">&#9989; Complaint Approval</button>
        </a>

        <a href="visitorApproval.jsp">
            <button class="btn-purple">&#128203; Visitor Approval</button>
        </a>

    </div>

</div>
</body>
</html>
