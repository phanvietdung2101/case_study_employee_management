<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 3/19/2020
  Time: 11:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View employee</title>
</head>
<body>
<h1>Employee detail</h1>
<p>
    <a href="employeeList">Back to employee list</a>
</p>
<table>
    <tr>
        <td>Name: </td>
        <td>${requestScope["employee"].getName()}</td>
    </tr>
    <tr>
        <td>Email: </td>
        <td>${requestScope["employee"].getEmail()}</td>
    </tr>
    <tr>
        <td>Address: </td>
        <td>${requestScope["employee"].getAddress()}</td>
    </tr>
    <tr>
        <td>Salary: </td>
        <td>${requestScope["employee"].getSalary()}</td>
    </tr>
</table>

</body>
</html>
