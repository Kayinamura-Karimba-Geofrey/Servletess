<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Login</title>
</head>
<body>
<h2>Student Login</h2>

<c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
</c:if>

<form method="post" action="login">
    <label>First Name:</label>
    <input type="text" name="firstName" required><br><br>

    <label>Registration Number:</label>
    <input type="text" name="regNumber" required><br><br>

    <input type="submit" value="Login">
</form>
</body>
</html>
