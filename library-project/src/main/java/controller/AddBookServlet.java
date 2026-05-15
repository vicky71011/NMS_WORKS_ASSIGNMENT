package controller;

import dao.BookDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Book;
import java.io.IOException;

@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String title        = request.getParameter("title");
        String author       = request.getParameter("author");
        String genre        = request.getParameter("genre");
        String copiesStr    = request.getParameter("totalCopies");

        int totalCopies = 1;
        try {
            totalCopies = Integer.parseInt(copiesStr);
        } catch (NumberFormatException e) {
            response.sendRedirect("addBook.jsp?error=invalid_copies");
            return;
        }

        Book b = new Book();
        b.setTitle(title);
        b.setAuthor(author);
        b.setGenre(genre);
        b.setTotalCopies(totalCopies);

        BookDAO dao = new BookDAO();
        boolean result = dao.addBook(b);

        if (result) {
            response.sendRedirect("dashboard.jsp?msg=book_added");
        } else {
            response.sendRedirect("addBook.jsp?error=1");
        }
    }
}
