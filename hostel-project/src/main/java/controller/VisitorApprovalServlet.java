package controller;

import dao.VisitorDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/VisitorApprovalServlet")
public class VisitorApprovalServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idParam = request.getParameter("id");

        if (idParam != null && !idParam.isEmpty()) {
            try {
                int id = Integer.parseInt(idParam);

                VisitorDAO dao = new VisitorDAO();
                dao.updateVisitorStatus(id);

            } catch (NumberFormatException e) {
                System.err.println("Invalid visitor ID in URL: " + idParam);
            }
        }

        response.sendRedirect("visitorApproval.jsp");
    }
}
