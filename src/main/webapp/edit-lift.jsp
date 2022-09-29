<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lift Info Edit</title>
</head>
<body>
    <h1>Please Edit Any Necessary Info, then Click "Save Lift Info"</h1>
    <form action = "editLiftServlet" method = "post">
        Name: <input type = "text" name = "name" value = "${liftToEdit.name}"><br><br>
        <input type = "hidden" name = "id" value="${liftToEdit.id}">
        <input type = "submit" value="Save Lift Info">
    </form>
</body>
</html>