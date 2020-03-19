<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 3/18/2020
  Time: 11:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee List</title>
</head>
<body>
<h1>Employee list</h1>
<p>
    <a href="/employeeList?action=create">Add new employee</a>
</p>
<table border="1">
    <tr>
        <td>Name</td>
        <td>Email</td>
        <td>Address</td>
        <td>Salary</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <%--    <c:forEach items='${requestScope["employeeList"]}' var="employee">--%>
    <%--        <tr>--%>
    <%--            <td><a href="/employeeList?action=view&id=${employee.getId()}">${employee.getName()}</a></td>--%>
    <%--            <td>${employee.getEmail()}</td>--%>
    <%--            <td>${employee.getAddress()}</td>--%>
    <%--            <td>${employee.getEmail()}</td>--%>
    <%--            <td><a href="/employeeList?action=edit&id=${employee.getId()}">edit</a></td>--%>
    <%--            <td><a href="/employeeList?action=delete&id=${employee.getId()}">delete</a></td>--%>
    <%--        </tr>--%>
    <%--    </c:forEach>--%>
</table>
</body>
</html>