package org.javaproject.studentregistrationsystem.geofrey.controller;

import org.javaproject.studentregistrationsystem.geofrey.dao.StudentDAO;
import org.javaproject.studentregistrationsystem.geofrey.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private final StudentDAO studentDAO = new StudentDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String regNumber = request.getParameter("regNumber");

        Student student = studentDAO.login(firstName, regNumber);

        if (student != null) {
            HttpSession session = request.getSession();
            session.setAttribute("loggedStudent", student);
            response.sendRedirect("viewStudents.jsp");
        } else {
            request.setAttribute("error", "Invalid name or registration number");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
