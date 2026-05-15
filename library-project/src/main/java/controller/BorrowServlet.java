package controller;

import dao.BorrowDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.BorrowRecord;
import java.io.IOException;

@WebServlet("/BorrowServlet")
public class BorrowServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String bookIdStr = request.getParameter("bookId");
        String studentName = request.getParameter("studentName");

        int bookId;
        try {
            bookId = Integer.parseInt(bookIdStr);
        } catch (NumberFormatException e) {
            response.sendRedirect("borrowBook.jsp?error=invalid_id");
            return;
        }

        BorrowRecord br = new BorrowRecord();
        br.setBookId(bookId);
        br.setStudentName(studentName);

        BorrowDAO dao = new BorrowDAO();
        boolean result = dao.borrowBook(br);

        if (result) {
            response.sendRedirect("dashboard.jsp?msg=borrow_success");
        } else {
            response.sendRedirect("borrowBook.jsp?error=no_copies");
        }
    }
}