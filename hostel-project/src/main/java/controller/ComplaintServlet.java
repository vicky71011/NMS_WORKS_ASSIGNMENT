package controller;

import dao.ComplaintDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Complaint;
import java.io.IOException;

@WebServlet("/ComplaintServlet")
public class ComplaintServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String studentName   = request.getParameter("studentName");
        String roomNo        = request.getParameter("roomNo");
        String complaintType = request.getParameter("complaintType");
        String description   = request.getParameter("description");

        Complaint c = new Complaint();
        c.setStudentName(studentName);
        c.setRoomNo(roomNo);
        c.setComplaintType(complaintType);
        c.setDescription(description);

        ComplaintDAO dao = new ComplaintDAO();
        boolean result = dao.addComplaint(c);

        if (result) {
            response.sendRedirect("dashboard.jsp?msg=complaint_success");
        } else {
            response.sendRedirect("complaint.jsp?error=1");
        }
    }
}
