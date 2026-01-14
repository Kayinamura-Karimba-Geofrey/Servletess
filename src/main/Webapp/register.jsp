<!DOCTYPE html>
<html>
<head>
    <title>Register Student</title>
    <link rel="stylesheet" href="css/syle.css">
</head>
<body>
<div class="container">
    <h2>Student Registration Form</h2>

    <p class="error">${error}</p>

    <form action="register" method="post">
        <input type="text" name="name" placeholder="Enter Name"><br>
        <input type="text" name="regNo" placeholder="Enter Reg No"><br>
        <input type="text" name="course" placeholder="Enter Course"><br>
        <input type="submit" value="Register">
    </form>

    <br>
    <a href="index.jsp">Go Home</a>
</div>
</body>
</html>
