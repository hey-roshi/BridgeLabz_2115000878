package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final String USER_ID = "admin";
    private static final String PASSWORD = "password123";
    private static final Pattern NAME_PATTERN = Pattern.compile("^[A-Z][a-zA-Z]{2,}$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(
            "^(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z\\d]).{8,}$"); // Fixed: \\d instead of \d

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String id = request.getParameter("userid");
        String name = request.getParameter("name");
        String pass = request.getParameter("password");

        out.println("<html><head><link rel='stylesheet' type='text/css' href='style.css'></head><body>");
        out.println("<div class='container'>");

        if (!NAME_PATTERN.matcher(name).matches()) {
            out.println("<h2 class='error'>Invalid Name. It should start with a capital letter and have at least 3 characters.</h2>");
        } else if (!PASSWORD_PATTERN.matcher(pass).matches()) {
            out.println("<h2 class='error'>Invalid Password. It must be at least 8 characters long, contain at least one uppercase letter, one numeric digit, and exactly one special character.</h2>");
        } else if (USER_ID.equals(id) && PASSWORD.equals(pass)) {
            out.println("<h2>Login Successful! Welcome, " + name + "</h2>");
        } else {
            out.println("<h2 class='error'>Invalid Credentials. Please Try Again.</h2>");
        }

        out.println("</div>");
        out.println("</body></html>");
    }
}
