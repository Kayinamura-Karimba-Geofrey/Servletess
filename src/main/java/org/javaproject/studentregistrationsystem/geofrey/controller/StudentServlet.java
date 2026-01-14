package org.javaproject.studentregistrationsystem.geofrey.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.javaproject.studentregistrationsystem.geofrey.model.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletContext;

@WebServlet("/register")
public class StudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String regNo = request.getParameter("regNo");
        String course = request.getParameter("course");

        if (name.isEmpty() || regNo.isEmpty() || course.isEmpty()) {
            request.setAttribute("error", "All fields are required!");
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            rd.forward(request, response);
            return;
        }

        // Create student object
        Student student = new Student(name, regNo, course);

        // Get the list from ServletContext (application scope)
        ServletContext context = getServletContext();
        List<Student> studentList = (List<Student>) context.getAttribute("students");

        if (studentList == null) {
            studentList = new ArrayList<>();
            context.setAttribute("students", studentList);
        }

        // Add new student
        studentList.add(student);

        // Forward to success page
        request.setAttribute("student", student);
        RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
        rd.forward(request, response);
    }
}
