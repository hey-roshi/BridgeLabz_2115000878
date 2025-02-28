package com.Login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final String USER_ID = "admin";
    private static final String PASSWORD = "password123";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String id = request.getParameter("userid");
        String pass = request.getParameter("password");

        if (USER_ID.equals(id) && PASSWORD.equals(pass)) {
            out.println("<h2>Login Successful! Welcome, " + id + "</h2>");
        } else {
            out.println("<h2>Invalid Credentials. Please Try Again.</h2>");
        }
    }
}


