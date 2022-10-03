<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lift Score Edit</title>
</head>
<body>
    <h1>Please Edit Any Necessary Info, then Click "Save Lift Score</h1>
    <h2> Member Name: ${liftScoreToEdit.gymMember.firstName} ${liftScoreToEdit.gymMember.lastName}</h2>
    <form action = "editLiftScoreServlet" method = "post">
        Date: <input type = "date" name = "dateOfScore" value = "${liftScoreToEdit.dateOfScore}"><br><br>
        Score: <input type = "number" name = "score" min = "1" value = "${liftScoreToEdit.score}"><br><br>
        <input type = "hidden" name = "id" value="${liftScoreToEdit.id}">
        <input type = "submit" value="Save Lift Score">
    </form>
</body>
</html>