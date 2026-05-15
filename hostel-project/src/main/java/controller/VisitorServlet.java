package controller;

import dao.VisitorDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Visitor;
import java.io.IOException;

@WebServlet("/VisitorServlet")
public class VisitorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String studentName = request.getParameter("studentName");
        String visitorName = request.getParameter("visitorName");
        String visitTime   = request.getParameter("visitTime");

        Visitor v = new Visitor();
        v.setStudentName(studentName);
        v.setVisitorName(visitorName);
        v.setVisitTime(visitTime);

        VisitorDAO dao = new VisitorDAO();
        boolean result = dao.addVisitor(v);

        if (result) {
            response.sendRedirect("dashboard.jsp?msg=visitor_success");
        } else {
            response.sendRedirect("visitor.jsp?error=1");
        }
    }
}
