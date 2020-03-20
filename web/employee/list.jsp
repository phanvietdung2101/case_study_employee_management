<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<html>
<head>
    <title>Employee List</title>
</head>
<body>
<div class="container-fluid">
<h1><a href="/employeeList">Employee list</a></h1>
<p>
    <a href="/employeeList?action=add">Add new employee</a>
</p>
<form action="" method="get">
    Sort by department:
    <select name="listCategory" id="listCategory" onchange="this.form.submit()">
        <option></option>
        <option value="Marketing">Marketing</option>
        <option value="Production">Production</option>
        <option value="Research and Development">Research and Development</option>
        <option value="Human Resource Management">Human Resource Management</option>
        <option value="Accounting and Finance">Accounting and Finance</option>
    </select>
    Sort by:
    <select name="sort" id="sort" onchange="this.form.submit()">
        <option></option>
        <option value="nameAscending">nameAscending</option>
        <option value="nameDescending">nameDescending</option>
        <option value="salaryAscending">salaryAscending</option>
        <option value="salaryDescending">salaryDescending</option>
    </select>
</form>
<br>
<table border="1" class="table">
    <thead class="thead-dark">
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
        <th>Salary</th>
        <th>Department</th>
        <th>Edit</th>
        <th>Delete</th>
    </thead>
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
</div>
</body>
</html>