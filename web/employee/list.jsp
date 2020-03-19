<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee List</title>
</head>
<body>
<h1><a href="/employeeList">Employee list</a>></h1>

<p>
    <a href="/employeeList?action=add">Add new employee</a>
</p>
<form action="" method="get">
    <select name="listCategory" id="listCategory" onchange="this.form.submit()">
        <option>All</option>
        <option value="Marketing">Marketing</option>
        <option value="Production">Production</option>
        <option value="Research and Development">Research and Development</option>
        <option value="Human Resource Management">Human Resource Management</option>
        <option value="Accounting and Finance">Accounting and Finance</option>
    </select>
</form>
<table border="1">
    <tr>
        <td>Name</td>
        <td>Email</td>
        <td>Address</td>
        <td>Salary</td>
        <td>Department</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
        <c:forEach items='${requestScope["employeeList"]}' var="employee">
            <tr>
                <td><a href="/employeeList?action=view&id=${employee.getId()}">${employee.getName()}</a></td>
                <td>${employee.getEmail()}</td>
                <td>${employee.getAddress()}</td>
                <td>${employee.getSalary()}</td>
                <td>${employee.getDepartment()}</td>
                <td><a href="/employeeList?action=edit&id=${employee.getId()}">edit</a></td>
                <td><a href="/employeeList?action=delete&id=${employee.getId()}">delete</a></td>
            </tr>
        </c:forEach>
</table>
</body>
</html>