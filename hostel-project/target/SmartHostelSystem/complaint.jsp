<%-- complaint.jsp — VIEW: Register a complaint --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register Complaint</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">

    <h2>&#128196; Register Complaint</h2>

    <% if ("1".equals(request.getParameter("error"))) { %>
        <p class="error-msg">&#10060; Failed to submit. Please try again.</p>
    <% } %>

    <%--
        action="ComplaintServlet" → triggers ComplaintServlet.doPost()
        Each input name attribute matches what the Servlet reads via
        request.getParameter("studentName"), etc.
    --%>
    <form action="ComplaintServlet" method="post">

        <input type="text"
               name="studentName"
               placeholder="Student Name"
               required>

        <input type="text"
               name="roomNo"
               placeholder="Room Number (e.g. B-204)"
               required>

        <%-- Dropdown — value is sent to Servlet as "complaintType" --%>
        <select name="complaintType">
            <option value="Water Issue">Water Issue</option>
            <option value="WiFi Issue">WiFi Issue</option>
            <option value="Electricity Problem">Electricity Problem</option>
            <option value="Cleaning Issue">Cleaning Issue</option>
        </select>

        <textarea name="description"
                  placeholder="Describe the issue in detail..."></textarea>

        <button type="submit">Submit Complaint</button>

    </form>

    <br>
    <a href="dashboard.jsp">&#8592; Back to Dashboard</a>

</div>
</body>
</html>
