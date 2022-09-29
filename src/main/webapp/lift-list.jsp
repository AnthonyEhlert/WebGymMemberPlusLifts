<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
    th, tr{
    padding-left: 15px;
    padding-right: 15px;
    text-align: center;
    }
</style>
<meta charset="UTF-8">
<title>Lift List</title>
</head>
<body>
    <h1>List of Lifts</h1>
    <form method="post" action = "liftNavigationServlet">
    <table>
        <tr>
            <th></th>
            <th>Lift Name</th>
        <c:forEach items="${requestScope.allLifts}" var="currentlift">
        <tr>
            <td><input type = "radio" name = "id" value = "${currentlift.id}"></td>
            <td>${currentlift.name}</td>
        </c:forEach>
    </table><br /><br />
    <input type = "submit" value = "edit" name = "doThisToLift">
    <input type = "submit" value = "delete" name = "doThisToLift">
    <input type = "submit" value = "add" name = "doThisToLift"><br /><br />
    <a href = "index.html">Main Menu</a><br />
    <a href = "viewAllMembersServlet">View the complete list of members </a><br />
    <a href = "viewAllLiftScoresServlet">View the complete list of recorded scores</a>
    </form>
</body>
</html>