<%-- complaintApproval.jsp — VIEW: Admin resolves complaints --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="dao.ComplaintDAO" %>
<%@ page import="model.Complaint" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Complaint Approval</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container wide">

    <h2>&#9989; Complaint Approval</h2>

    <%--
        Call the DAO directly from JSP to fetch all complaints.
        WHY DAO from JSP?
          In a small J2EE project this is acceptable. In a larger app you would
          use a Servlet to fetch the data, put it in request.setAttribute(),
          then forward to JSP (request.getRequestDispatcher("view.jsp").forward()).
    --%>
    <%
        ComplaintDAO dao = new ComplaintDAO();
        List<Complaint> complaints = dao.getAllComplaints();
    %>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Student</th>
                <th>Room</th>
                <th>Type</th>
                <th>Description</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <%--
                Java enhanced for-loop inside JSP scriptlet.
                Each iteration creates one <tr> row.
            --%>
            <% for (Complaint c : complaints) { %>
            <tr>
                <td><%= c.getComplaintId() %></td>
                <td><%= c.getStudentName() %></td>
                <td><%= c.getRoomNo() %></td>
                <td><%= c.getComplaintType() %></td>
                <td><%= c.getDescription() %></td>
                <td>
                    <%-- Color the status badge based on value --%>
                    <span class="<%= "Resolved".equals(c.getStatus()) ? "badge-green" : "badge-orange" %>">
                        <%= c.getStatus() %>
                    </span>
                </td>
                <td>
                    <% if ("Pending".equals(c.getStatus())) { %>
                        <%--
                            Clicking "Resolve" sends a GET request to:
                            /ComplaintApprovalServlet?id=<complaintId>
                            The Servlet reads ?id= and calls the DAO.
                        --%>
                        <a href="ComplaintApprovalServlet?id=<%= c.getComplaintId() %>">
                            <button class="btn-small">Resolve</button>
                        </a>
                    <% } else { %>
                        <span class="text-muted">Done</span>
                    <% } %>
                </td>
            </tr>
            <% } %>

            <% if (complaints.isEmpty()) { %>
            <tr><td colspan="7" style="text-align:center; color:#888;">No complaints found.</td></tr>
            <% } %>
        </tbody>
    </table>

    <br>
    <a href="dashboard.jsp">&#8592; Back to Dashboard</a>

</div>
</body>
</html>
