package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final String LIBRARIAN_EMAIL = "librarian@gmail.com";
    private static final String LIBRARIAN_PASSWORD = "lib123";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (LIBRARIAN_EMAIL.equals(email) && LIBRARIAN_PASSWORD.equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", email);
            session.setMaxInactiveInterval(30 * 60);

            response.sendRedirect("dashboard.jsp");
        } else {
            response.sendRedirect("login.jsp?error=1");
        }
    }
}