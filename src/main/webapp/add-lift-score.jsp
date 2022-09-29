<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
    th, tr{
    padding-left: 10px;
    padding-right: 10px;
    text-align: center;
    }
</style>
<meta charset="UTF-8">
<title>Add New Lift Score</title>
</head>
<body>
    <h1>List of Gym Members</h1>
    <form method="post" action = "addLiftScoreServlet">
    <table>
        <tr>
            <th></th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Age</th>
            <th>Waiver Signed</th>
        <c:forEach items="${requestScope.allMembers}" var="currentmember">
        <tr>
            <td><input type = "radio" name = "memberId" value = "${currentmember.id}"></td>
            <td>${currentmember.firstName}</td>
            <td>${currentmember.lastName}</td>
            <td>${currentmember.age}</td>
            <td>${currentmember.waiverSigned}</td>
        </tr>
        </c:forEach>
    </table>
    <h1>List of Lifts</h1>
    <table>
        <tr>
            <th></th>
            <th>Lift Name</th>
        <c:forEach items="${requestScope.allLifts}" var="currentlift">
        <tr>
            <td><input type = "radio" name = "liftId" value = "${currentlift.id}"></td>
            <td>${currentlift.name}</td>
        </c:forEach>
    </table>
    <br />
    Score: <input type = "number" name = "score" min = "1"><br><br><br>
    Score Date: <input type = "date" id = "dateOfScore" name = "dateOfScore"><br /><br />
    <input type = "submit" value = "add" name = "insertLiftScore"><br/><br/>
    </form>
        <a href = "index.html">Main Menu</a><br />
    <a href = "viewAllMembersServlet">View the complete list of members </a><br />
</body>
</html>