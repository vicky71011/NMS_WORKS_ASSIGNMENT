<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="dao.BorrowDAO, model.BorrowRecord, java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Borrow Records</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="topbar">
    <span>&#128218; Library Management System</span>
    <a href="dashboard.jsp" class="logout-link">&#8592; Dashboard</a>
</div>

<div class="page-wrap">
    <h2>&#128203; Borrow Records</h2>

    <% if ("return_success".equals(request.getParameter("msg"))) { %>
    <p class="success-msg">&#10003; Book returned successfully!</p>
    <% } %>

    <%
        BorrowDAO dao = new BorrowDAO();
        List<BorrowRecord> records = dao.getAllRecords();
    %>

    <table>
        <thead>
        <tr>
            <th>#</th>
            <th>Book Title</th>
            <th>Student</th>
            <th>Borrow Date</th>
            <th>Return Date</th>
            <th>Status</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <% for (BorrowRecord br : records) { %>
        <tr>
            <td><%= br.getRecordId() %></td>
            <td><strong><%= br.getBookTitle() %></strong></td>
            <td><%= br.getStudentName() %></td>
            <td><%= br.getBorrowDate() %></td>
            <td>
                <%= br.getReturnDate() != null ? br.getReturnDate() : "—" %>
            </td>
            <td>
                    <span class="<%= "Returned".equals(br.getStatus()) ? "badge-green" : "badge-orange" %>">
                        <%= br.getStatus() %>
                    </span>
            </td>
            <td>
                <% if ("Borrowed".equals(br.getStatus())) { %>
                <a href="ReturnServlet?recordId=<%= br.getRecordId() %>">
                    <button class="btn-sm btn-green">&#8617; Return</button>
                </a>
                <% } else { %>
                <span class="text-muted">Done</span>
                <% } %>
            </td>
        </tr>
        <% } %>

        <% if (records.isEmpty()) { %>
        <tr><td colspan="7" class="empty-row">No borrow records yet.</td></tr>
        <% } %>
        </tbody>
    </table>

</div>
</body>
</html>