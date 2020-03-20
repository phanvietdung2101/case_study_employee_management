<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 3/19/2020
  Time: 11:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<html>
<head>
    <title>View employee</title>
</head>
<body>
<div class="container-fluid">
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
    <tr>
        <td>Department: </td>
        <td>${requestScope["employee"].getDepartment()}</td>
    </tr>
</table>
</div>
</body>
</html>
