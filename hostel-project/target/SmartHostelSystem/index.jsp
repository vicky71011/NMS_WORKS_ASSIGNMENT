<%-- index.jsp — Entry point, redirects to login --%>
<%--
    WHY THIS FILE?
    Tomcat looks for index.jsp when you visit http://localhost:8080/SmartHostelSystem/
    We immediately redirect to login.jsp so the user always starts at the login page.
--%>
<%
    response.sendRedirect("login.jsp");
%>
