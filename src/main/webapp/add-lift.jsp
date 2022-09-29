<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Lift</title>
</head>
<body>
    <h1>Enter the new lift</h1>
    <form action = "addLiftServlet" method = "post">
        Lift Name: <input type = "text" name = "name"><br><br>
        <input type = "submit" value = "Add Lift">
    </form> <br /><br />
    <a href = "index.html">Main Menu</a><br />
</body>
</html>