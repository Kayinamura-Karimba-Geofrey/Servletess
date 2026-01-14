<%@ page import="java.util.List" %>
    <%@ page import="org.javaproject.studentregistrationsystem.geofrey.model.Student" %>
        <%@ page import="org.javaproject.studentregistrationsystem.geofrey.dao.StudentDAO" %>
            <%@ page session="true" %>

                <% Student loggedStudent=(Student) session.getAttribute("loggedStudent"); if (loggedStudent==null) {
                    response.sendRedirect("login.jsp"); return; } StudentDAO dao=new StudentDAO(); List<Student>
                    students = dao.getAllStudents();
                    %>

                    <html>

                    <head>
                        <title>All Registered Students</title>
                        <link rel="stylesheet" href="css/style.css">
                    </head>

                    <body>
                        <div class="container">
                            <h2>Welcome, <%= loggedStudent.getName() %>!</h2>
                            <h3>All Registered Students</h3>

                            <table border="1">
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Registration Number</th>
                                    <th>Course</th>
                                </tr>
                                <% for (Student s : students) { %>
                                    <tr>
                                        <td>
                                            <%= s.getId() %>
                                        </td>
                                        <td>
                                            <%= s.getName() %>
                                        </td>
                                        <td>
                                            <%= s.getRegNo() %>
                                        </td>
                                        <td>
                                            <%= s.getCourse() %>
                                        </td>
                                    </tr>
                                    <% } %>
                            </table>

                            <br>
                            <a href="logout.jsp">Logout</a> | <a href="register.jsp">Register Another Student</a> | <a
                                href="index.jsp">Go Home</a>
                        </div>
                    </body>

                    </html>