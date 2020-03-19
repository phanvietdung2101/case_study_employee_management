<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit employee</title>
    <style>
        .message {
            color: green;
        }
    </style>
</head>
<body>
<p1>Edit employee</p1>
<p>
    <c:if test = '${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p><a href="/employeeList">Back to employee list</a></p>
<form method="post">
    <fieldset>
        <legend>Employee information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name" value="${requestScope["employee"].getName()}"></td>
            </tr>
            <tr>
                <td>Email: </td>
                <td><input type="text" name="email" id="email" value="${requestScope["employee"].getEmail()}"></td>
            </tr>
            <tr>
                <td>Address: </td>
                <td><input type="text" name="address" id="address" value="${requestScope["employee"].getAddress()}"></td>
            </tr>
            <tr>
                <td>Salary: </td>
                <td><input type="text" name="salary" id="salary" value="${requestScope["employee"].getSalary()}"></td>
            </tr>
            <tr>
                <td>Department: </td>
                <td><input type="text" name="department" id="department" value="${requestScope["employee"].getDepartment()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update employee"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
