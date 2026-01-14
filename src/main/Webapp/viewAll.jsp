<%@ page
    import="java.util.*, org.hibernate.Session, org.javaproject.studentregistrationsystem.geofrey.config.HibernateUtil, org.javaproject.studentregistrationsystem.geofrey.model.Student"
    %>
    <!DOCTYPE html>
    <html>

    <head>
        <title>All Students</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    </head>

    <body>
        <div class="container">
            <h2>All Registered Students</h2>

            <% Session hibernateSession=HibernateUtil.getSessionFactory().openSession(); List<Student> students =
                hibernateSession.createQuery("FROM Student", Student.class).list();
                hibernateSession.close();

                if (students.isEmpty()) {
                %>
                <p>No students registered yet.</p>
                <% } else { %>
                    <table border="1">
                        <tr>
                            <th>Name</th>
                            <th>Reg No</th>
                            <th>Course</th>
                        </tr>
                        <% for(Student s : students) { %>
                            <tr>
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
                    <% } %>

                        <br>
                        <a href="register.jsp">Register Another Student</a> |
                        <a href="index.jsp">Go Home</a>
        </div>
    </body>

    </html>