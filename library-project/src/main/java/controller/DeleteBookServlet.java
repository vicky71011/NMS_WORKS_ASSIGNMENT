package controller;

import dao.BookDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteBookServlet")
public class DeleteBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String bookIdStr = request.getParameter("bookId");

        if (bookIdStr != null && !bookIdStr.isEmpty()) {
            try {
                int bookId = Integer.parseInt(bookIdStr);

                BookDAO dao = new BookDAO();
                dao.deleteBook(bookId);

            } catch (NumberFormatException e) {
                System.err.println("DeleteBookServlet: Invalid book ID → " + bookIdStr);
            }
        }

        response.sendRedirect("viewBooks.jsp?msg=book_deleted");
    }
}