package controller;

import dao.BorrowDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ReturnServlet")
public class ReturnServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String recordIdStr = request.getParameter("recordId");

        if (recordIdStr != null && !recordIdStr.isEmpty()) {
            try {
                int recordId = Integer.parseInt(recordIdStr);

                BorrowDAO dao = new BorrowDAO();
                dao.returnBook(recordId);

            } catch (NumberFormatException e) {
                System.err.println("ReturnServlet: Invalid record ID → " + recordIdStr);
            }
        }

        response.sendRedirect("borrowRecords.jsp?msg=return_success");
    }
}