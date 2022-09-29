<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
    th, tr{
    padding-left: 20px;
    padding-right: 20px;
    text-align: center;
    }
</style>
<meta charset="UTF-8">
<title>Lift Scores List</title>
</head>
<body>
    <h1>List of Lift Scores</h1>
    <form method="post" action = "liftScoreNavigationServlet">
    <table>
        <tr>
            <th></th>
            <th>Date</th>
            <th>Score</th>
            <th>Member</th>
            <th>Lift</th>
        <c:forEach items="${requestScope.allLiftScores}" var="liftscore">
        <tr>
            <td><input type = "radio" name = "id" value = "${liftscore.id}"></td>
            <td>${liftscore.dateOfScore}</td>
            <td>${liftscore.score}</td>
            <td>${liftscore.gymMember.firstName} ${liftscore.gymMember.lastName}</td>
            <td>${liftscore.lift.name}</td>
        </tr>
        </c:forEach>
    </table><br />
    <input type = "submit" value = "edit" name = "doThisToLiftScore">
    <input type = "submit" value = "delete" name = "doThisToLiftScore">
    <input type = "submit" value = "add" name = "doThisToLiftScore"><br /><br /><br />
    </form>
    <a href = "index.html">Main Menu</a><br />
    <a href = "viewAllMembersServlet">View the complete list of members </a><br />
</body>
</html>