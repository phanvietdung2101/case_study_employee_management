<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleting customer</title>
</head>
<body>
<h1>Delete customer</h1>
<p>
    <a href="/employeeList">Back to employee list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Employee information</legend>
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
                <td><input type="submit" value="Delete employee"></td>
                <td><a href="/employeeList">Back to employee list</a></td>
            </tr>
        </table>
    </fieldset>
</body>
</html>