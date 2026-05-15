<%-- visitorApproval.jsp — VIEW: Admin approves visitor entries --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="dao.VisitorDAO" %>
<%@ page import="model.Visitor" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Visitor Approval</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container wide">

    <h2>&#128203; Visitor Approval</h2>

    <%
        VisitorDAO dao = new VisitorDAO();
        List<Visitor> visitors = dao.getAllVisitors();
    %>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Student</th>
                <th>Visitor</th>
                <th>Visit Time</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <% for (Visitor v : visitors) { %>
            <tr>
                <td><%= v.getVisitorId() %></td>
                <td><%= v.getStudentName() %></td>
                <td><%= v.getVisitorName() %></td>
                <td><%= v.getVisitTime() %></td>
                <td>
                    <span class="<%= "Approved".equals(v.getApprovalStatus()) ? "badge-green" : "badge-orange" %>">
                        <%= v.getApprovalStatus() %>
                    </span>
                </td>
                <td>
                    <% if ("Pending".equals(v.getApprovalStatus())) { %>
                        <a href="VisitorApprovalServlet?id=<%= v.getVisitorId() %>">
                            <button class="btn-small">Approve</button>
                        </a>
                    <% } else { %>
                        <span class="text-muted">Done</span>
                    <% } %>
                </td>
            </tr>
            <% } %>

            <% if (visitors.isEmpty()) { %>
            <tr><td colspan="6" style="text-align:center; color:#888;">No visitors found.</td></tr>
            <% } %>
        </tbody>
    </table>

    <br>
    <a href="dashboard.jsp">&#8592; Back to Dashboard</a>

</div>
</body>
</html>
