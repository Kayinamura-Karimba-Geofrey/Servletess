<%@ page import="java.util.*, org.javaproject.studentregistrationsystem.geofrey.model.Student" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Students</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/syle.css">
</head>
<body>
<div class="container">
    <h2>All Registered Students</h2>

    <%
        List<Student> students = (List<Student>) application.getAttribute("students");
        if (students == null || students.isEmpty()) {
    %>
    <p>No students registered yet.</p>
    <%
    } else {
    %>
    <table border="1" width="100%" style="border-collapse: collapse; text-align: left;">
        <tr>
            <th>Name</th>
            <th>Reg No</th>
            <th>Course</th>
        </tr>
        <% for(Student s : students) { %>
        <tr>
            <td><%= s.getName() %></td>
            <td><%= s.getRegNo() %></td>
            <td><%= s.getCourse() %></td>
        </tr>
        <% } %>
    </table>
    <%
        }
    %>

    <br>
    <a href="register.jsp">Register Another Student</a> |
    <a href="index.jsp">Go Home</a>
</div>
</body>
</html>
