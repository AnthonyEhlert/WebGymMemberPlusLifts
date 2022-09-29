<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Info Edit</title>
</head>
<body>
    <h1>Please Edit Any Necessary Info, then Click "Save Member Info</h1>
    <form action = "editMemberServlet" method = "post">
        First Name: <input type = "text" name = "firstName" value = "${memberToEdit.firstName}"><br><br>
        Last Name: <input type = "text" name = "lastName" value = "${memberToEdit.lastName}"><br><br>
        Age: <input type = "number" name = "age" min = "1" value = "${memberToEdit.age}"><br>
        <h2> Current Waiver Status: ${memberToEdit.waiverSigned}</h2>
        Waiver Signed? True or False?:<br>
        <input type = "radio" id = "true" name = "waiverSigned" value = "True" required>
        <label for = "true">True</label><br><br>
        <input type = "radio" id = "false" name = "waiverSigned" value = "False">
        <label for = "false">False</label><br><br>
        <input type = "hidden" name = "id" value="${memberToEdit.id}">
        <input type = "submit" value="Save Member Info">
    </form>
</body>
</html>