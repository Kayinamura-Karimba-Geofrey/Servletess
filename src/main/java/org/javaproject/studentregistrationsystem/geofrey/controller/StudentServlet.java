package org.javaproject.studentregistrationsystem.geofrey.controller;

import java.io.IOException;

import org.javaproject.studentregistrationsystem.geofrey.config.HibernateUtil;
import org.javaproject.studentregistrationsystem.geofrey.model.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@WebServlet("/register")
public class StudentServlet extends HttpServlet {

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

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            // Check if regNo already exists
            Query<Student> query = session.createQuery("FROM Student WHERE regNo = :reg", Student.class);
            query.setParameter("reg", regNo);
            if (!query.list().isEmpty()) {
                request.setAttribute("error", "Registration number already exists!");
                RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
                rd.forward(request, response);
                return;
            }

            // Save new student
            Student student = new Student(name, regNo, course);
            session.save(student);

            tx.commit();
            request.setAttribute("student", student);
            RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
