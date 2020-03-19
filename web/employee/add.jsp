<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 3/19/2020
  Time: 8:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new employee</title>
    <style>
        .message{
            color: green;
        }
    </style>
</head>
<body>
<h1>Add new employee</h1>
<p>
    <c:if test='${requestScope["message"]!= null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/employeeList">Back to employee list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Employee information</legend>
        <table>
            <tr>
                <td>ID: </td>
                <td><input type="text" name="id" id="id"></td>
            </tr>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>Email: </td>
                <td><input type="text" name="email" id="email"></td>
            </tr>
            <tr>
                <td>Address: </td>
                <td><input type="text" name="address" id="address"></td>
            </tr>
            <tr>
                <td>Salary: </td>
                <td><input type="text" name="salary" id="salary"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Add employee"></td>
            </tr>
        </table>
    </fieldset>
</form>

</body>
</html>
