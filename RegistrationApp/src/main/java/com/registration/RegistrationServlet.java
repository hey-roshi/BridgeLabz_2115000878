package com.registration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/register")  // Ensure this matches the form action URL
public class RegistrationServlet extends HttpServlet {
    private static final List<User> userList = new ArrayList<>();  // Store users in memory

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form parameters
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Create a new User object
        User user = new User(name, email, password);
        userList.add(user);  // Store user in the list

        // Print all registered users in IntelliJ Terminal
        System.out.println("Registered Users:");
        userList.forEach(System.out::println);

        // Send response to the client
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Registration Successful!</h2>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("<a href='index.html'>Register Another User</a>");
    }
}
