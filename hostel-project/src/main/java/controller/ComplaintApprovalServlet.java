package controller;

import dao.ComplaintDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ComplaintApprovalServlet")
public class ComplaintApprovalServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idParam = request.getParameter("id");

        if (idParam != null && !idParam.isEmpty()) {
            try {
                int id = Integer.parseInt(idParam);

                ComplaintDAO dao = new ComplaintDAO();
                dao.updateComplaintStatus(id);

            } catch (NumberFormatException e) {
                System.err.println("Invalid complaint ID in URL: " + idParam);
            }
        }

        response.sendRedirect("complaintApproval.jsp");
    }
}
