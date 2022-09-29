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
<title>Member List</title>
</head>
<body>
    <h1>List of Gym Members</h1>
    <form method="post" action = "navigationServlet">
    <table>
        <tr>
            <th></th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Age</th>
            <th>Waiver Signed</th>
        <c:forEach items="${requestScope.allMembers}" var="currentmember">
        <tr>
            <td><input type = "radio" name = "id" value = "${currentmember.id}"></td>
            <td>${currentmember.firstName}</td>
            <td>${currentmember.lastName}</td>
            <td>${currentmember.age}</td>
            <td>${currentmember.waiverSigned}</td>
        </tr>
        </c:forEach>
    </table>
    <input type = "submit" value = "edit" name = "doThisToMember">
    <input type = "submit" value = "delete" name = "doThisToMember">
    <input type = "submit" value = "add" name = "doThisToMember">
    </form>
    <br /><br />
    <a href = "index.html">Main Menu</a><br />
</body>
</html>